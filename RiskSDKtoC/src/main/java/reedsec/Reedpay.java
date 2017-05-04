package reedsec;

/**
 * Hello world!
 */
public class Reedpay {

    /**
     * 风控请求的地址
     */
//    public static volatile String cloud_url = "http://192.168.3.106:7111/api/";
//    public static volatile String cloud_url = "https://spdev-verify.reedsec.com/api/";
    public static volatile String cloud_url = "http://192.168.3.109:6010/api/";

    /**
     * 瑞赛发放的合作伙伴代码。测试环境与生产环境不同
     */
    public static volatile String partner_id;
    /**
     * 瑞赛发放的接入密钥。测试环境与生产环境不同
     */
    public static volatile String partner_key;

    /**
     * 时间来源 web,android,ios
     */
    public static volatile String app;

    /**
     * #获取token时使用
     */
    public static volatile String AppID;
    public static volatile String AppSecret;
    /**
     * 是否在接口中开启jwt验证(1：验证，2：不验证)
     */
    public static volatile String is_token;

    /**
     * 是否开启debug，开启可以打印部分日志信息
     */
    public static volatile Boolean DEBUG = false;

}
