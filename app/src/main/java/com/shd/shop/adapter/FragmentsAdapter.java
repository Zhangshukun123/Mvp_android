package com.shd.shop.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.shd.shop.adapter.viepager.FragmentStatePagerAdapter;
import com.shd.shop.adapter.viepager.TabLayoutSupport;
import com.shd.shop.model.main.shop.fragment.MyShopListFragment;
import com.shd.shop.model.main.shop.fragment.ShopListFragment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FragmentsAdapter extends FragmentStatePagerAdapter implements TabLayoutSupport.ViewPagerTabLayoutAdapter {
    private LinkedHashMap<Integer, Fragment> mFragmentCache = new LinkedHashMap<>();

    private List<String> titles;


    public FragmentsAdapter(String tag, FragmentManager fm) {
        super(fm);
        if (tag.equals("my_shop_list")) {
            titles = new ArrayList<>();
            titles.add("出售中");
            titles.add("已下架");
            titles.add("审核中");
        }

        if (tag.equals("my_order_list")) {
            titles = new ArrayList<>();
            titles.add("待付款");
            titles.add("待发货");
            titles.add("待收货");
            titles.add("交易成功");
        }

    }

    @Override
    public Fragment getItem(int position, Fragment.SavedState savedState) {
        Fragment f = mFragmentCache.containsKey(position) ? mFragmentCache.get(position)
                : new MyShopListFragment();
        Log.e("test", "getItem:" + position + " from cache" + mFragmentCache.containsKey
                (position));
        if (savedState == null || f.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", position);
            f.setArguments(bundle);
            Log.e("test", "setArguments:" + position);
        } else if (!mFragmentCache.containsKey(position)) {
            f.setInitialSavedState(savedState);
            Log.e("test", "setInitialSavedState:" + position);
        }
        mFragmentCache.put(position, f);
        return f;
    }

    @Override
    public void onDestroyItem(int position, Fragment fragment) {
        // onDestroyItem
        while (mFragmentCache.size() > 5) {
            Object[] keys = mFragmentCache.keySet().toArray();
            mFragmentCache.remove(keys[0]);
        }
    }

    @Override
    public String getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}
