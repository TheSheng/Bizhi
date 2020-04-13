package com.bishe.java.controller;

import com.bishe.java.pojo.User;

import com.bishe.java.util.HttpUtils;
import com.bishe.java.util.ResponseError;
import com.bishe.java.util.ResponseOk;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@RestController
@CrossOrigin(value = "*",maxAge = 3600)
public class DuanxinController {

    public  String ma(){
        Random rd=new Random();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<4;i++){
            str.append(rd.nextInt(10));
        }
        return  str.toString();
    }
    public String times(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return  simpleDateFormat.format(new Date());
    }
    @PostMapping("/sendDuanxin")
    public ResponseEntity send(@RequestBody User  user) throws Exception{

        String host = "https://cdcxdxjk.market.alicloudapi.com";
        String path = "/chuangxin/dxjk";
        String method = "POST";
        String ma=ma();
        String appcode = "1038d8ebf621457eae4a310349d09e21";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("content", "【壁纸推荐平台】您的验证码是"+ma+",三分钟之内有效");
        //注意测试可用：【创信】你的验证码是：#code#，3分钟内有效！，发送自定义内容联系旺旺或QQ：726980650报备
        querys.put("mobile", user.getUsername());
        Map<String, String> bodys = new HashMap<String, String>();
        HttpResponse response=null;

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
             response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(EntityUtils.toString(response.getEntity()));

            return ResponseOk.create(ma);
            //获取response的body

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseError.create(e.getMessage());
        }
    }

}
