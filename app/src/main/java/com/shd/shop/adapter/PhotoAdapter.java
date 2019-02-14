package com.shd.shop.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jakewharton.rxbinding.view.RxView;
import com.shd.shop.R;
import com.shd.shop.adapter.Decoration.ItemTouchHelperAdapter;
import com.shd.shop.entity.PhotoDates;

import java.util.List;
import java.util.concurrent.TimeUnit;

import me.iwf.photopicker.PhotoPicker;


public class PhotoAdapter extends BaseQuickAdapter<PhotoDates, BaseViewHolder> implements ItemTouchHelperAdapter {

    private List<PhotoDates> data;
    private deleteItem item;
    private Activity activity;

    public PhotoAdapter(Activity activity, @Nullable List<PhotoDates> data, deleteItem item) {
        super(R.layout.photo_layout, data);
        this.activity = activity;
        this.data = data;
        this.item = item;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void convert(BaseViewHolder helper, PhotoDates item) {
        ImageButton ib_photo = helper.getView(R.id.takePhoto);

        Glide.with(ib_photo.getContext())
                .load(item.getPath())
                .apply(new RequestOptions().error(R.drawable.take_photo))
                .into(ib_photo);

        RxView.clicks(ib_photo).throttleFirst(1, TimeUnit.SECONDS).subscribe(aVoid -> {
            if (item.getPath() == null || item.getPath().equals("")) {
                PhotoPicker.builder()
                        .setPhotoCount((10 - helper.getAdapterPosition()))
                        .setShowCamera(true)
                        .setShowGif(true)
                        .start(activity, PhotoPicker.REQUEST_CODE);
            }
        });

        ib_photo.setOnTouchListener((v, event) -> {
            if (item.getPath() != null && !item.getPath().equals("")) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ViewCompat.animate(ib_photo)
                            .setDuration(200)
                            .scaleX(1.3f)
                            .scaleY(1.3f)
                            .start();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    ViewCompat.animate(ib_photo)
                            .setDuration(200)
                            .scaleX(1f)
                            .scaleY(1f)
                            .start();
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    ViewCompat.animate(ib_photo)
                            .setDuration(200)
                            .scaleX(1f)
                            .scaleY(1f)
                            .start();
                }
            }
            return false;
        });
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {

    }

    @Override
    public void onItemDelete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
        item.romoveDate(position);
    }

    @Override
    public int datesize() {
        return data.size();
    }


    public interface deleteItem {
        void romoveDate(int position);
    }
}
