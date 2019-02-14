package com.shd.shop.entity;

public class SmsModel extends BaseModel{

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
