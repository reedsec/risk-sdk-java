package reedsec.utils;

import reedsec.Reedpay;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class Utils {
    public static final String APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT_JSON = "text/json";
    private static String partner_id;
    private static String partner_key;
    private static String app;


    public static String postApi(String event_type, String method_type, String json) {

        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        String res = null;
        try {
            partner_id = Reedpay.partner_id;
            partner_key = Reedpay.partner_key;
            app = Reedpay.app;

            JSONObject request_body = new JSONObject();
            request_body.put("event_type", event_type);//事件类型
            request_body.put("app", app);//事件来源
            request_body.put("form_string", new JSONObject(json));

            JSONObject request_json = new JSONObject();
            request_json.put("partner_id", Integer.valueOf(partner_id));
            request_json.put("partner_key", partner_key);
//            request_json.put("device_cid","");
            request_json.put("request_body", request_body);

            String url = Reedpay.cloud_url + method_type;

            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
            if (Integer.valueOf(Reedpay.is_token) == 1) {
                String token = getToken();
                try {
                    JSONObject token_json = new JSONObject(token);
                    if (token_json.has("jwt")) {
                        httpPost.setHeader("Authorization", "JWT " + token_json.getString("jwt"));
                    } else {
                        if(Reedpay.DEBUG){
                            System.out.println("没有获取到jwt");
                        }
                    }
                } catch (Exception e) {//出现异常解析出现错误，没有jwt
                    System.out.println("cloud没有开启token验证");
                }
            }else{
                System.out.println("没有开启token验证");
            }

            StringEntity entityParams = new StringEntity(request_json.toString(), "UTF-8");
            if(Reedpay.DEBUG){
                System.out.println("发送请求：" + new String(EntityUtils.toByteArray(entityParams), "UTF-8"));
            }
            entityParams.setContentType(CONTENT_TYPE_TEXT_JSON);
            entityParams.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            httpPost.setEntity(entityParams);

            client = HttpClients.createDefault();
            response = client.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            if (response == null || httpEntity == null) {
                res = "操作失败";
            }
            res = new String(EntityUtils.toByteArray(httpEntity), "UTF-8");
            if(Reedpay.DEBUG){
                System.out.println("请求结果：" + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

    public static String getToken() {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        String res = null;

        try {
            String url = Reedpay.cloud_url + "getAccessJwt";
            if(Reedpay.DEBUG){
                System.out.println("请求url：" + url);
            }
            JSONObject token_json = new JSONObject();
            token_json.put("AppID", Reedpay.AppID);
            token_json.put("AppSecret", Reedpay.AppSecret);

            HttpPost httpPost = new HttpPost(url);
            StringEntity entityParams = new StringEntity(token_json.toString(), "UTF-8");
            if(Reedpay.DEBUG){
                System.out.println("发送请求：" + new String(EntityUtils.toByteArray(entityParams), "UTF-8"));
            }
            entityParams.setContentType(Utils.CONTENT_TYPE_TEXT_JSON);
            entityParams.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            httpPost.setEntity(entityParams);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            client = HttpClients.createDefault();
            response = client.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            if (response == null || httpEntity == null) {
                res = "操作失败";
            }
            res = new String(EntityUtils.toByteArray(httpEntity), "UTF-8");
            if(Reedpay.DEBUG){
                System.out.println("请求结果：" + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

}

