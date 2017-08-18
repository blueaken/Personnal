package com.blueaken.service;

import com.blueaken.util.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenjian on 2017/8/17.
 */
@Service
public class CIICMethods implements MethodsInterface {
    // 登录链接
    private String mLoginUrl = null;
    // 登录后跳转的页面
    private String mIndexUrl = null;
    // 获取网页中的相对路径拼接上这个头部构成完整请求路径
    private String mUrlHead = null;
    // 是否需要验证码
    private boolean isAuth = false;

    private HttpUtil httpUtil;

    public CIICMethods() {
        this.mLoginUrl = "http://172.16.4.29/oa/dlq/userlogin.asp";
        this.mIndexUrl = "http://172.16.4.29/oa/oaindexLogin.ciic";
        this.mUrlHead = mUrlHead;
        this.httpUtil = new HttpUtil();
    }

    public boolean login(String username, String passwd) {
        isAuth = false;
        System.out.println("login...");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("txtyhm", username));
        params.add(new BasicNameValuePair("txtkl", passwd));
//        params.add(new BasicNameValuePair("dl_flag", "0&submit="));
        HttpEntity he;
        try {
            he = new UrlEncodedFormEntity(params, "UTF-8");
            HttpResponse hr = httpUtil.post(mLoginUrl, he);
            if (hr != null && 302 == hr.getStatusLine().getStatusCode()) {
                System.out.println("自动登录成功");
            } else {
                System.out.println("密码错误");
                return false;
            }

//            String firstresult = EntityUtils.toString(hr.getEntity());
//            if (firstresult.contains("verifycode")) {
//                // 在异地登录或者登录频繁会出现验证码
//                isAuth = true;
//                System.out.println("需要验证码");
//                return false;
//            } else if (firstresult.contains("error_area")) {
//                System.out.println("密码错误");
//                return false;
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
