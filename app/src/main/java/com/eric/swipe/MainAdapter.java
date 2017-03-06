package com.eric.swipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eric.swipe.model.ShoppingCartProductItemModel;
import com.eric.swipe.model.ShoppingCartProductModel;
import com.eric.swipe.model.ShoppingCartPromotionModel;
import com.eric.swipe.utils.DensityUtils;
import com.eric.swipe.utils.StringUtils;
import com.eric.swipe.view.FrontViewToMove;

import java.util.List;

public class MainAdapter extends BaseExpandableListAdapter implements FrontViewToMove.OnMoveChangeListener {
    private FrontViewToMove mViewToMove, mViewDown;
    private List<ShoppingCartProductModel> sections;
    private ExpandableListView mLv;
    private LayoutInflater inflater;
    private Context mContext;

    public MainAdapter(Context mContext, List<ShoppingCartProductModel> sections,
                       ExpandableListView mLv) {
        this.sections = sections;
        this.mContext = mContext;
        this.mLv = mLv;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getGroupCount() {
        return sections.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sections.get(groupPosition).getItems().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return sections != null ? sections.get(groupPosition) : 0;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sections.get(groupPosition).getItems().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ShoppingCartProductModel cartProductModel = sections.get(groupPosition);
        ViewHodler groupView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_shoppingcart_group, null);
            groupView = new ViewHodler(convertView);
            convertView.setTag(groupView);
        } else {
            groupView = (ViewHodler) convertView.getTag();
        }
        ShoppingCartPromotionModel promotionMode = cartProductModel.getPromotion();
        if (promotionMode != null) {
            groupView.llChild.setVisibility(View.VISIBLE);
            groupView.selection.setVisibility(promotionMode.isSpecial() ? View.GONE : View.VISIBLE);
            groupView.tag.setText(promotionMode.getTemplate());
            groupView.title.setText(promotionMode.getTitle());
        } else {
            groupView.llChild.setVisibility(View.GONE);
            groupView.llLine.setVisibility(View.VISIBLE);
        }
        groupView.llChild.setVisibility(promotionMode != null ? View.VISIBLE : View.GONE);
        groupView.llLine.setVisibility(promotionMode != null ? View.GONE : View.VISIBLE);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded,
                             View convertView, ViewGroup viewGroup) {
        final ViewHodler childView;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_shoppingcart_child, null);
            childView = new ViewHodler(convertView);
            convertView.setTag(childView);
        } else {
            childView = (ViewHodler) convertView.getTag();
        }
        int width = DensityUtils.dip2px(mContext, 80);
        childView.viewToMove = new FrontViewToMove(childView.rlCartItem, mLv, width);

        ShoppingCartProductItemModel itemModel = sections.get(groupPosition).getItems()
                .get(childPosition);
        //ImageLoader.loadImage(childView.ivCover, itemModel.getProductImage());
        childView.tvTitle.setText(itemModel.getProductName());
        String price = StringUtils.retainTwo(itemModel.getProductPrice());
        childView.tvPrice.setText("¥ " + price);
        //特殊商品默认勾选,禁止取消勾选
        childView.rlChildSelected.setFocusable(itemModel.isLocked() ? false : true);
        childView.rlChildSelected.setClickable(!itemModel.isLocked() ? false : true);
        childView.cbSelected.setChecked(itemModel.isSelected());
        childView.ivCover.setBackgroundResource(R.drawable.bg_hyaline);
        childView.tvCount.setVisibility(itemModel.isLocked() ? View.VISIBLE : View.GONE);
        childView.tvCount.setText("x" + itemModel.getQuantity());
        childView.viewToMove.setMoveChangeListener(this);
        //因为重写ontouch事件使onChildClickListener失效，需要设置次监听来补救
        childView.rlCartItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                childView.viewToMove.reinStatement();

            }
        });
        //侧滑删除按钮点击监听
        childView.itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                childView.viewToMove.reinStatement();

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onMoveChanged(FrontViewToMove viewToMove) {
        if (viewToMove != null) {
            mViewToMove = viewToMove;
        }
    }

    @Override
    public boolean onMoved(FrontViewToMove viewToMove) {
        if (viewToMove != null && mViewDown != null && !viewToMove.equals(mViewDown)) {
            return true;
        } else {
            mViewDown = viewToMove;
            if (viewToMove != null && !viewToMove.equals(mViewToMove)) {
                if (mViewToMove != null) {
                    mViewToMove.reinStatement();
                }
            }
            return false;
        }
    }

    @Override
    public void onUpMotion() {
        mViewDown = null;
    }

    private class ViewHodler {
        LinearLayout llChild;
        LinearLayout llLine;
        TextView tag;
        TextView title;
        TextView selection;

        RelativeLayout rlChildSelected;
        CheckBox cbSelected;
        ImageView ivCover;
        TextView tvTitle;
        TextView tvPrice;
        TextView tvCount;
        TextView tvStock;
        RelativeLayout rlCartItem;
        LinearLayout itemDelete;
        FrontViewToMove viewToMove;

        public ViewHodler(View convertView) {
            this.llChild = (LinearLayout) convertView.findViewById(R.id.llChild);
            this.llLine = (LinearLayout) convertView.findViewById(R.id.ll_line);
            this.tag = (TextView) convertView.findViewById(R.id.tv_groupTag);
            this.title = (TextView) convertView.findViewById(R.id.tv_groupTitle);
            this.selection = (TextView) convertView.findViewById(R.id.tv_groupSelection);

            this.rlChildSelected = (RelativeLayout) convertView.findViewById(R.id.rl_ChildSelected);
            this.cbSelected = (CheckBox) convertView.findViewById(R.id.cbChildSelected);
            this.ivCover = (ImageView) convertView.findViewById(R.id.ivChildCover);
            this.tvTitle = (TextView) convertView.findViewById(R.id.ivChildTitle);
            this.tvPrice = (TextView) convertView.findViewById(R.id.ivChildPrice);
            this.tvCount = (TextView) convertView.findViewById(R.id.tv_childCount);
            this.tvStock = (TextView) convertView.findViewById(R.id.tv_stock);
            this.rlCartItem = (RelativeLayout) convertView.findViewById(R.id.rl_cartItem);
            this.itemDelete = (LinearLayout) convertView.findViewById(R.id.item_delete);
        }
    }
}
