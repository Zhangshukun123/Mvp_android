package com.shd.shop.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/28.
 */

public class BaseModel implements Serializable, MultiItemEntity {
    public MetaBean meta;

    public boolean isSuccess() {
        if (null != meta && meta.success) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        return null != meta ? meta.message : "";
    }

    public String code() {
        return null != meta ? meta.code : "";
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
