package com.shd.shop.model.wrapper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ImageLoader {





    /**
     * Load image from source and set it into the imageView.
     *
     * @param context context.
     * @param source  could be Uri/String/File/ResourceId.
     * @param view    the imageView.
     */
    public static void load(Context context, Object source, ImageView view) {
         RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context)
                .load(source)
                .apply(requestOptions)
                .into(view);
    }

    public static void load(Object source, ImageView view) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(view.getContext())
                .load(source)
                .apply(requestOptions)
                .into(view);
    }

    public static void loadWithCircle(Context context, Object source, ImageView view) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context)
                .load(source)
                .apply(RequestOptions.circleCropTransform())
                .apply(requestOptions)
//                .placeholder(R.drawable.ic_github)
                .into(view);
    }


}
