package reedsec.services;

import reedsec.utils.Utils;

/**
 * Created by lik@reedsec.com on 2017/5/3 0003.
 */
public class ReedpayServices {

    /**--------    验证类    --------**/
    //贷前验证
    public static String loan_verify(String json) {
        String result = Utils.postApi("loan_verify","riskVerify",json);
        return result;
    }

    //发券（红包）前验证
    public static String coupon_verify(String json) {
        String result = Utils.postApi("coupon_verify","riskVerify",json);
        return result;
    }

    //发送短信验证码判断
    public static String sms_verify(String json) {
        String result = Utils.postApi("sms_verify","riskVerify",json);
        return result;
    }

    //提现前验证
    public static String withdraw_verify(String json) {
        String result = Utils.postApi("withdraw_verify","riskVerify",json);
        return result;
    }

    //**--------    通知类    --------**//*
    //注册后通知
    public static String register_notify(String json) {
        String result = Utils.postApi("register_notify","riskNotify",json);
        return result;
    }

    //登陆后通知
    public static String login_notify(String json) {
        String result = Utils.postApi("login_notify","riskNotify",json);
        return result;
    }

    //充值后通知
    public static String store_notify(String json) {
        String result = Utils.postApi("store_notify","riskNotify",json);
        return result;
    }
}
