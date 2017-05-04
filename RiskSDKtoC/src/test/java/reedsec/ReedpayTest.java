package reedsec;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import reedsec.services.ReedpayServices;

/**
 * Unit test for simple Reedpay.
 */
public class ReedpayTest {

    @Before
    public void init(){
        //初始化
        Reedpay.partner_id = "100107";
        Reedpay.partner_key = "Aa9pA3GsBc7a";
        Reedpay.app = "web";
        Reedpay.is_token = "1";
        Reedpay.AppID = "admin";
        Reedpay.AppSecret = "qwerty";
        Reedpay.DEBUG = true;
    }

    @Test
    public void loan_verify(){
        JSONObject json = new JSONObject();
        json.put("account_id","12824324171");
        json.put("account_idcard","421083199014212541");
        json.put("account_name","测试");
        json.put("trans_type","loan");
        json.put("device_type","app");
        json.put("device_id","123");
        json.put("device_id_type","loan");
        json.put("client_ip","114.251.29.65");
        json.put("amount","1");
        json.put("trans_amount","1");
        json.put("trans_id","123456");
        String result = ReedpayServices.loan_verify(json.toString());
        System.out.println(result);
    }

    @Test
    public void coupon_verify(){
        JSONObject json = new JSONObject();
        json.put("account_id","a000001");
        json.put("trans_type","abc");
        json.put("device_type","abc");
        json.put("device_id","abc");
        json.put("client_ip","b000001");
        json.put("coupon_type","c000001");
        json.put("coupon_amount","abc");
        json.put("coupon_desc","abc");
        json.put("coupon_item","114.251.29.65");
        json.put("device_id_type","1");
        json.put("trans_amount","1");
        json.put("trans_id","123456");
        String result = ReedpayServices.coupon_verify(json.toString());
        System.out.println(result);
    }

    @Test
    public void sms_verify(){
        JSONObject json = new JSONObject();
        json.put("phone","a000001");
        json.put("account_id","1");
        json.put("trans_type","abc");
        json.put("device_type","abc");
        json.put("device_id","1");
        json.put("device_id_type","1");
        json.put("client_ip","114.251.29.65");
        json.put("trans_amount","1");
        json.put("trans_id","123456");
        String result = ReedpayServices.coupon_verify(json.toString());
        System.out.println(result);
    }

    @Test
    public void withdraw_verify(){
        JSONObject json = new JSONObject();
        json.put("account_id","1");
        json.put("account_name","abc");
        json.put("account_bankid","1");
        json.put("trans_type","abc");
        json.put("trans_id","1");
        json.put("device_type","1");
        json.put("device_id_type","1");
        json.put("device_id","1");
        json.put("client_ip","114.251.29.65");
        json.put("amount","1");
        json.put("trans_amount","1");
        json.put("trans_id","123456");
        String result = ReedpayServices.coupon_verify(json.toString());
        System.out.println(result);
    }

    @Test
    public void login_notify(){
        JSONObject json = new JSONObject();
        json.put("account_id","1");
        json.put("device_type","1");
        json.put("device_id_type","abc");
        json.put("device_id","1");
        json.put("client_ip","24.21.21.14");
        json.put("login_result","0");
        String result = ReedpayServices.coupon_verify(json.toString());
        System.out.println(result);
    }

    @Test
    public void register_notify(){
        JSONObject json = new JSONObject();
        json.put("account_id","13521452365");
        json.put("register_channel","abc");
        json.put("device_type","abc");
        json.put("device_id_type","abc");
        json.put("device_id","b000001");
        json.put("client_ip","114.251.29.65");
        String result = ReedpayServices.coupon_verify(json.toString());
        System.out.println(result);
    }

    @Test
    public void store_notify(){
        JSONObject json = new JSONObject();
        json.put("account_id","1");
        json.put("trans_type","store");
        json.put("trans_id","1145212214");
        json.put("amount","1");
        json.put("device_type","1");
        json.put("device_id_type","1");
        json.put("device_id","1");
        json.put("client_ip","114.251.29.65");
        String result = ReedpayServices.coupon_verify(json.toString());
        System.out.println(result);
    }
}


