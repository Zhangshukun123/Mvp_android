package com.shd.shop.model.main.home;

import android.graphics.Color;
import android.os.Build;
import android.view.KeyEvent;
import android.widget.Toast;

import com.shd.shop.R;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.model.component.home.DaggerMainComponent;
import com.shd.shop.model.component.home.MainComponent;
import com.shd.shop.model.models.home.MainModule;
import com.shd.shop.model.models.home.factory.AgencyFragmentFactory;
import com.shd.shop.model.presenter.MainPresenter;
import com.shd.shop.model.view.MainView;
import com.shd.shop.server.DataServer;


import javax.inject.Inject;


public class MainActivity extends BaseActivity<MainPresenter, MainView> implements MainView {

    @Inject
    DataServer server;

    @Inject
    AgencyFragmentFactory factory;

    private long clickTime = 0;

    private static MainComponent mainComponent;


    public static MainComponent getMainComponent() {
        return mainComponent;
    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main_fra;
    }

    @Override
    protected void initInjector() {
        mainComponent = DaggerMainComponent.builder().
                applicationComponent(getAppComponent())
                .mainModule(new MainModule(this))
                .build();
        mainComponent.inject(this);
    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.TRANSPARENT);
        }
        mSwipeBackLayout.setEnableGesture(false);
        replaceFragment(R.id.frame, factory.getAgencyFragemt());
//        switch (server.getAgency()) {
//            case SUPPLER_AGENCY:
//                break;
//            case COM_AGENCY:
//                break;
//            case CITY_AGENCY:
//                break;
//            case PROVINEC_AGENCY:
//                break;
//            case SHOP_AGENCY:
//                break;
//        }
    }

    @Override
    protected void updateViews(boolean isRefresh) {
    }
    @Override
    public void onBackPressed() {
        exit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 是否触发按键为back键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        } else { // 如果不是back键正常响应
            return super.onKeyDown(keyCode, event);
        }
    }

    private void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(this, "再按一次后退键退出程序", Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            this.finish();
        }
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//       TextView tv= findViewById(R.id.tv);
//       tv.setText("8888888888888");
//      TinkerInstaller.onReceiveUpgradePatch(MainActivity.this, Environment.getExternalStorageDirectory().getAbsolutePath()+"/patch_signed_7zip.apk");
//    }
}
