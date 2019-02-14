package com.shd.shop.entity;

public class OrderDate extends BaseModel {


    public static final int TIME = 1;
    public static final int STAT = 2;
    public static final int DETAILS = 3;
    private int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


    public DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public class DataBean {

    }


}
