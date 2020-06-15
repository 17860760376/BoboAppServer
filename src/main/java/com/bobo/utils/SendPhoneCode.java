package com.bobo.utils;

import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装的获取手机手机验证码的方法，传入手机号，就可以给用户发送验证码
 */
public class SendPhoneCode {

    final static String APPCODE="6d10754e71084071bcf73e7987b0cab9";
    public static HttpResponse sendPhoneCode(String username,String PhoneCode){
        String host = "https://zwp.market.alicloudapi.com";
        String path = "/sms/sendv2";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + APPCODE);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content", "【云通知】您的验证码是"+PhoneCode+"。如非本人操作，请忽略本短信");
        querys.put("mobile", username);
        HttpResponse response = null;
        try {

            response = HttpUtils.doGet(host, path, method, headers, querys);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
