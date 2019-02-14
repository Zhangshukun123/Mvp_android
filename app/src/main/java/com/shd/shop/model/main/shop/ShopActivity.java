package com.shd.shop.model.main.shop;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;

import com.shd.shop.R;
import com.shd.shop.base.BaseActivity;
import com.shd.shop.model.main.shop.fragment.AddCommodityFragment;
import com.shd.shop.model.main.shop.fragment.ShopListFragment;
import com.shd.shop.model.presenter.base.RxMvpPresenter;
import com.shd.shop.utils.PermissionUtils;
import com.shd.shop.utils.ToastUtils;

import java.util.ArrayList;

import me.iwf.photopicker.PhotoPicker;

public class ShopActivity extends BaseActivity {
    private AddCommodityFragment addCommodityFragment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.shop_activity;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void doDoes() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            addStatusViewWithColor(this, Color.WHITE);
        }
        String commodity = getIntent().getStringExtra("commodity");

        if (commodity != null) {
            addCommodityFragment = new AddCommodityFragment();
            loadFragment(R.id.frame_s, addCommodityFragment);
        } else {
            loadFragment(R.id.frame_s, new ShopListFragment());
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                if (addCommodityFragment != null) {
                    addCommodityFragment.callBackPhoto(photos);
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionUtils.CAMERA_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                ToastUtils.showToast("111");
            }
        }
    }



    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
