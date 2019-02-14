package com.shd.shop.model.main.shop.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.shd.shop.R;
import com.shd.shop.adapter.Decoration.MyItemTouchHelperCallBack;
import com.shd.shop.adapter.PhotoAdapter;
import com.shd.shop.base.BaseFragment;
import com.shd.shop.entity.PhotoDates;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class AddCommodityFragment extends BaseFragment {

    @BindView(R.id.rl_take_photo)
    RecyclerView rl_take_photo;
    private List<PhotoDates> photoDates;
    private PhotoAdapter adapter;
    private MyItemTouchHelperCallBack callback;
    @Override
    public int LayoutView() {
        return R.layout.commodity_layout;
    }
    @Override
    protected void doDoes() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        linearLayoutManager.setOrientation(HORIZONTAL);
        rl_take_photo.setLayoutManager(linearLayoutManager);
        photoDates = new ArrayList<>();
        photoDates.add(new PhotoDates());
        adapter = new PhotoAdapter(getActivity(), photoDates, position -> {
            if (photoDates.size() == 9) {
                photoDates.add(new PhotoDates());
                callback.setDatesize(false);
                adapter.notifyDataSetChanged();
            }
        });
        callback = new MyItemTouchHelperCallBack(adapter);
        rl_take_photo.setAdapter(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rl_take_photo);
    }

    public void callBackPhoto(List<String> photo) {
        photoDates.remove(photoDates.size() - 1);
        for (int i = 0; i < photo.size(); i++) {
            photoDates.add(new PhotoDates(photo.get(i)));
        }
        if (photoDates.size() < 10) {
            photoDates.add(new PhotoDates());
        } else {
            callback.setDatesize(true);
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void initInjector() {
    }
}
