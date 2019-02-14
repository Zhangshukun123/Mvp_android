package com.shd.shop.model.main.home;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shd.shop.R;
import com.shd.shop.adapter.MenuItemAdapter;
import com.shd.shop.api.Agency;
import com.shd.shop.base.BaseFragment;
import com.shd.shop.model.component.home.DaggerAgencyBaseComponent;
import com.shd.shop.model.main.shop.ShopActivity;
import com.shd.shop.model.main.shop.fragment.ShopListFragment;
import com.shd.shop.model.models.home.AgencyModule;
import com.shd.shop.model.models.home.factory.AgencyFragmentFactory;
import com.shd.shop.model.presenter.MainPresenter;
import com.shd.shop.model.wrapper.GridDividerItemDecoration2;
import com.shd.shop.server.DataServer;
import com.shd.shop.utils.ToastUtils;
import com.shd.shop.utils.Utils;
import com.shd.shop.widget.ScrollInterceptScrollView;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;

public class AgencyBaseFragment extends BaseFragment {


    @BindView(R.id.function_item)
    RecyclerView funItem;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @BindView(R.id.scroll)
    ScrollInterceptScrollView scroll;

    @BindView(R.id.iv_header1)
    ImageView iv_header1;

    @BindView(R.id.iv_header2)
    ImageView iv_header2;

    @BindView(R.id.line_stat)
    LinearLayout lineStat;
    @BindView(R.id.line_order)
    LinearLayout lineOrder;
    @BindView(R.id.line_state_pay)
    LinearLayout lineStatePay;
    @BindView(R.id.line_shop_order)
    LinearLayout lineShopOrder;
    @BindView(R.id.line_add_shop)
    LinearLayout lineAddShop;


    @BindView(R.id.rl_header_height)
    RelativeLayout rl_header_height;
    @BindView(R.id.tv_agency)
    TextView tv_agency;


    @BindView(R.id.tv_shop_list)
    TextView tvShopList;
    @BindView(R.id.tv_my_order_list)
    TextView tv_my_order_list;

    @BindView(R.id.rl_add_commodity)
    RelativeLayout addCommodity;


    @Inject
    protected MenuItemAdapter supplier_adapter;


    @Inject
    DataServer server;

    @Override
    public int LayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void doDoes() {
        swipeBackLayout.setEnableGesture(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        funItem.setLayoutManager(gridLayoutManager);
        funItem.addItemDecoration(new GridDividerItemDecoration2(1, getResources().getColor(R.color.line_bg_color)));
        funItem.setAdapter(supplier_adapter);


        switch (server.getAgency()) {
            case SUPPLER_AGENCY:
                tv_agency.setVisibility(View.GONE);
                refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(3000));
                break;
            case COM_AGENCY:
                poxy("社区代首页");
                break;
            case CITY_AGENCY:
                poxy("市代首页");
                break;
            case PROVINEC_AGENCY:
                poxy("省代首页");
                break;
            case SHOP_AGENCY:
                tv_agency.setVisibility(View.GONE);
                refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(3000));
                shop_poxy();
                break;
        }
        RxView.clicks(tvShopList).throttleFirst(1, TimeUnit.SECONDS).subscribe(aVoid -> {
            ShopListFragment.Tag = "my_shop_list";
            startActivity(new Intent(getActivity(), ShopActivity.class));
        });
        RxView.clicks(tv_my_order_list).throttleFirst(1, TimeUnit.SECONDS).subscribe(aVoid -> {
            ShopListFragment.Tag = "my_order_list";
            startActivity(new Intent(getActivity(), ShopActivity.class));
        });

        RxView.clicks(addCommodity).throttleFirst(1, TimeUnit.SECONDS).subscribe(aVoid -> {
            Intent intent = new Intent(getActivity(), ShopActivity.class);
            intent.putExtra("commodity", "commodity");
            startActivity(intent);
        });

    }


    @Override
    protected void initInjector() {
        DaggerAgencyBaseComponent.builder().agencyModule(new AgencyModule((MainActivity) getActivity())).mainComponent(MainActivity.getMainComponent()).build().inject(this);
    }

    private void poxy(String title) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rl_header_height.getLayoutParams();
        layoutParams.height = Utils.dp2px(getActivity(), 195);
        rl_header_height.setLayoutParams(layoutParams);
        iv_header1.setVisibility(View.VISIBLE);
        iv_header2.setVisibility(View.GONE);
        lineStat.setVisibility(View.GONE);
        lineOrder.setVisibility(View.GONE);
        lineStatePay.setVisibility(View.GONE);
        lineShopOrder.setVisibility(View.GONE);
        lineAddShop.setVisibility(View.GONE);
        refreshLayout.setEnableRefresh(false);
        tv_agency.setText(title);
    }

    private void shop_poxy() {
        lineOrder.setVisibility(View.GONE);
        lineStatePay.setVisibility(View.GONE);
        lineShopOrder.setVisibility(View.GONE);
        lineAddShop.setVisibility(View.GONE);
    }

}
