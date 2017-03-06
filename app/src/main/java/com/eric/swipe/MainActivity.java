package com.eric.swipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import com.eric.swipe.model.ShoppingCartProductModel;
import com.eric.swipe.model.ShoppingCartTopModel;
import com.eric.swipe.utils.FileUtils;
import com.eric.swipe.utils.ParseUtils;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @Module :
 * @Comments : 主页
 * @Author : eric.chen
 * @CreateDate : 2016-3-15
 * @ModifiedBy : eric.chen
 * @ModifiedDate: 2016-3-15
 * @Modified :
 */
public class MainActivity extends AppCompatActivity {
    private ExpandableListView mELv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        mELv=(ExpandableListView) findViewById(R.id.mELv);
    }

    private void initData(){
       String json = FileUtils.getFileTxt(this);
        ShoppingCartTopModel cartTopModel = ParseUtils.parseJson(json,
                new TypeToken<ShoppingCartTopModel>() {
                }.getType());
        List<ShoppingCartProductModel> productModels = cartTopModel.getData().getSections();
        MainAdapter adapter=new MainAdapter(this, productModels, mELv);
        mELv.setAdapter(adapter);
        mELv.setGroupIndicator(null);
        for (int i = 0; i < productModels.size(); i++) {
            mELv.expandGroup(i);
        }
        mELv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
    }
}
