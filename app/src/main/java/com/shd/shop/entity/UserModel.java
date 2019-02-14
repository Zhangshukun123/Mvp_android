package com.shd.shop.entity;


import java.io.Serializable;

public class UserModel extends BaseModel implements Serializable {
    public DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public  class DataBean implements Serializable {
        public String userId;
        public String name;
        public String sex;
        public String birthday;
        public String headImg;
        public String nickName;
        public String phone;
        public String province;
        public String promoteurl;// 推广二维码URL
        public String city;
        public String area;
        public String address;
        public String sign;
        public String status;
        public String inviteCode;
        public String truename;
        public String levelName;  // "levelName":"普通微米",
        public String level;
        public String weimiBalance;
        public String noWeimiBalance;
        public String balance;
        public String noBalance;
        public String score;
        public String noScore;
        public String connNum;
        public String cardNum;
        public String bankCard;
        public String isRealName;
        public String expireDays;
        public String token;
        public String isCashPwd; //0无，1，有 设置提现密码
        public String defaultAddr;
        public String isopenlive;
        public String livePassword;
        public String defaultAddrId;//默认收货地址ID
        public String isWeiMiShop;// 0：不是   1:店长   2：店员
        public String weiMiShopId; // 微米店铺ID
        public String loginError;  //openId  1未绑定微信  0是绑定过微信
        public String customerUserId;//客服IM ID
        public String customerServicePhone;//客服电话


        @Override
        public String toString() {
            return "DataBean{" +
                    "userId='" + userId + '\'' +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", headImg='" + headImg + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", province='" + province + '\'' +
                    ", promoteurl='" + promoteurl + '\'' +
                    ", city='" + city + '\'' +
                    ", area='" + area + '\'' +
                    ", address='" + address + '\'' +
                    ", sign='" + sign + '\'' +
                    ", status='" + status + '\'' +
                    ", inviteCode='" + inviteCode + '\'' +
                    ", truename='" + truename + '\'' +
                    ", levelName='" + levelName + '\'' +
                    ", level='" + level + '\'' +
                    ", weimiBalance='" + weimiBalance + '\'' +
                    ", noWeimiBalance='" + noWeimiBalance + '\'' +
                    ", balance='" + balance + '\'' +
                    ", noBalance='" + noBalance + '\'' +
                    ", score='" + score + '\'' +
                    ", noScore='" + noScore + '\'' +
                    ", connNum='" + connNum + '\'' +
                    ", cardNum='" + cardNum + '\'' +
                    ", bankCard='" + bankCard + '\'' +
                    ", isRealName='" + isRealName + '\'' +
                    ", expireDays='" + expireDays + '\'' +
                    ", token='" + token + '\'' +
                    ", isCashPwd='" + isCashPwd + '\'' +
                    ", defaultAddr='" + defaultAddr + '\'' +
                    ", isopenlive='" + isopenlive + '\'' +
                    ", livePassword='" + livePassword + '\'' +
                    ", defaultAddrId='" + defaultAddrId + '\'' +
                    ", isWeiMiShop='" + isWeiMiShop + '\'' +
                    ", weiMiShopId='" + weiMiShopId + '\'' +
                    ", loginError='" + loginError + '\'' +
                    ", customerUserId='" + customerUserId + '\'' +
                    ", customerServicePhone='" + customerServicePhone + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "data=" + data +
                '}';
    }
}
