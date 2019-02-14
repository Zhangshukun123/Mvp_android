package com.shd.shop.entity;


/**
 * Created by Administrator on 2017/6/21 0021.
 */

public class RegisterModel extends BaseModel {

    private MetaBean meta;
    private Object data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
