# SwipeExpandableListview
使用swipelistview实现侧滑删除这样Demo已经很普及了，但是项目需要，expandableListview的item也要实现侧滑删除，参照swipelistview的ontouch事件，对getChildItem中的每个item设置点击事件以及ontouch事件。
<br>
例如：侧滑出item1再去点击其他的item，item1恢复原样...等等
