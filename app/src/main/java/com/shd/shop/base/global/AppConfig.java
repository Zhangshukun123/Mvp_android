package com.shd.shop.base.global;

public class AppConfig {
    public static double LONGITUDE = 0.0;
    public static String CITY = "";

    public static final boolean ONLINE = true;//是否为正式环境
    public static final boolean printLog = true;//是否打印日记
    public static final boolean logAll = true; //是否将日记打印完整


    //===========================↓APP全局常量↓===============================//
    public final static String APP_PACK_PAGER = "com.shd.wenchangchicken";
    public final static String USER_PACK_PAGER = "com.shd.user";
    public final static String APP_SHARED_ID = "ShaoHuaDian";
    public final static String USER_TOKEN = "X-token";
    public final static String CURRENT_PAGER_ITEM = "currentPagerItem";//当前页面
    public final static String MAIN_ACTIVITY = "com.shd.wenchangchicken.main.MainActivity";//主页页面地址
    public final static String LOGIN_ACTIVITY = "com.shd.user.login.LoginActivity";//登陆页面地址
    public final static String USER_ID = "userId";//当前用户ID


    //网络请求的常量
    public static String net_appid;
    public static String net_token;
    //H5 url
    public static String url_inviting_friends;
    public static String url_vip;
    public static String url_shequ;
    public static String url_produce_detail;
    public static String base_h5_static = "";
    public static String SHOP_URL = "";//商户地址
    //域名
    public static String domain = "http://apph5.pengjipay.com:8085/a/rest/";
    public static double money = 1;
    public final static String MEATCH_SHOP_URL = "http://user.guotengkj.com:8191/dist/#/merchantDetail?goodsId=";

    public static void init() {
        if (ONLINE) {
//            domain = "http://user.weimishanghao.com/a/rest/";
            domain = "http://apph5.pengjipay.com:8085/a/rest/";
//            domain = "http://47.96.129.213:8087/a/rest/";

            net_appid = "lV7lHXt0CzS";
            net_token = "50e3d181d17d4af9a663a863f8c9ddb6";
            url_inviting_friends = "http://apph5.pengjipay.com:8085/#/inviteFriends?qrCode=";
            url_vip = "http://apph5.pengjipay.com:8085/#/vipPrivilege";
            url_shequ = "http://apph5.pengjipay.com:8089/#/activityIndex";
//            url_produce_detail = "http://apph5.pengjipay.com/#/goods?goodsId=";
            url_produce_detail = "http://apph5.pengjipay.com/#/newgoods?goodsId=";
            base_h5_static = "http://apph5.pengjipay.com/#/";
//            SHOP_URL = "http://apph5.pengjipay.com/#/merchantDetail?goodsId=";
            SHOP_URL = "http://apph5.pengjipay.com/#/newmerchantDetail?goodsId=";
        } else {
            //刘俊
//            domain = "http://192.168.1.246:8180/linker-webs-api-indubbo/a/rest/";
            //小强
//            domain = "http://192.168.1.85:8180/linker-webs-api-indubbo/a/rest/";
            domain = "http://47.96.129.213:8087/a/rest/";
            net_appid = "canairport001";
            net_token = "#@!1234567890!@#";
            /********************************************************************************************************/
            url_inviting_friends = "http://testapph5.pengjipay.com:8088/#/inviteFriends?qrCode=";
//            url_inviting_friends = "http://192.168.1.211:8080/weimiApi/dist/#/inviteFriends?qrCode=";
            url_vip = "http://testapph5.pengjipay.com:8088/#/vipPrivilege";
//            url_vip = "http://192.168.1.211:8080/weimiApi/dist/#/vipPrivilege";
//            url_shequ = "http://192.168.1.112:8088/dist";
//            url_shequ ="http://192.168.1.211:8080/shdSheQu/dist/#/activityIndex ";
            url_shequ = "http://testapph5.pengjipay.com:8089/#/activityIndex";
//            url_produce_detail = "http://192.168.1.146:8090/weimiApi/dist/#/goods?goodsId=";
//            url_produce_detail = "http://192.168.1.211:8080/spendless/dist/#/goods?goodsId=";
//            url_produce_detail = "http://testapph5.pengjipay.com:8088/#/goods?goodsId=";
//            url_produce_detail = "http://testapph5.pengjipay.com:8088/#/newgoods?goodsId=";
            url_produce_detail = "http://47.96.129.213:8088/#/newgoods?goodsId=";
//            base_h5_static = "http://192.168.1.211:8080/spendless/dist/#/";

//            base_h5_static = "http://testapph5.pengjipay.com:8088/#/";
            base_h5_static = "http://47.96.129.213:8088/#/";
//            SHOP_URL = "http://192.168.1.211:8056/#/merchantDetail?goodsId=";//测试
//            SHOP_URL = "http://testapph5.pengjipay.com:8088/#/newmerchantDetail?goodsId=";
            SHOP_URL = "http://47.96.129.213:8088/#/newmerchantDetail?goodsId=";
//            SHOP_URL = "http://testapph5.pengjipay.com:8088/#/merchantDetail?goodsId=";
            /********************************************************************************************************/


        }
    }
}
