package com.shd.shop.model.main.shop.fragment;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.shd.shop.R;
import com.shd.shop.adapter.FragmentsAdapter;
import com.shd.shop.adapter.viepager.RecyclerViewPager;
import com.shd.shop.adapter.viepager.TabLayoutSupport;
import com.shd.shop.base.BaseFragment;
import com.shd.shop.widget.ViewUtils;

import butterknife.BindView;

public class ShopListFragment extends BaseFragment {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.rl_viewpager)
    RecyclerViewPager pager;

    @BindView(R.id.tv_title)
    TextView tv_title;


    public static String Tag;

    @Override
    public int LayoutView() {
        return R.layout.my_shop_layout;
    }

    @Override
    protected void doDoes() {
        switch (ShopListFragment.Tag) {
            case "my_shop_list":
                tv_title.setText("我的商品");
                break;
            case "my_order_list":
                tv_title.setText("我的订单");
                break;
        }

        FragmentsAdapter mAdapter = new FragmentsAdapter(ShopListFragment.Tag, getChildFragmentManager());
        LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,
                false);
        pager.setLayoutManager(layout);
        pager.setAdapter(mAdapter);
        pager.setHasFixedSize(true);
        pager.setLongClickable(true);
        ViewUtils.reflex(tabs);
        TabLayoutSupport.setupWithViewPager(tabs, pager, mAdapter);
    }

    @Override
    protected void initInjector() {

    }
}
