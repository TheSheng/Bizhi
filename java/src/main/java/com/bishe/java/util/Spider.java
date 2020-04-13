package com.bishe.java.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bishe.java.mapper.PhotoMapper;
import com.bishe.java.pojo.Photo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName： Spider
 * @description: 爬虫
 * @author: lisheng
 * @create: 2020-02-21 09:53
 **/
@Component
@EnableScheduling
public class Spider {

        @Autowired
        PhotoMapper photoMapper;
        final ExecutorService executorService = Executors.newCachedThreadPool();

        final String baseUrl="https://www.duitang.com/napi/blog/list/by_filter_id/?include_fields=top_comments%2Cis_root%2Csource_link%2Citem%2Cbuyable%2Croot_id%2Cstatus%2Clike_count%2Csender%2Calbum%2Creply_count&filter_id=";
        final String sufferUrl="&start=0&_=1582249509801";

        @Scheduled(cron = "1 1/10 * * * *")
        @PostConstruct
        public void generateSprider(){
            List<String> type=new ArrayList<String>(){{
                add("文字句子");
                add("壁纸"); add("美食菜谱");add("美妆造型");
                add("时尚搭配");
                add("搞笑萌宠"); add("人物明星");
            }};
            Map<String,String> urlMap=new HashMap<>();
            type.forEach(x->{
                String url = baseUrl+x+sufferUrl;
                urlMap.put(x,url);
            });

            executorService.execute(()-> urlMap.entrySet().forEach(x->Spider(x)));
        }
        public void Spider(Map.Entry<String,String> entry){
            try {
                CloseableHttpClient client = null;
                CloseableHttpResponse response = null;
                try {
                    HttpGet httpGet = new HttpGet(entry.getValue());
                    client = HttpClients.createDefault();
                    response = client.execute(httpGet);
                    HttpEntity entity = response.getEntity();
                    JSONObject result = JSON.parseObject(EntityUtils.toString(entity),JSONObject.class);
                    JSONArray itemList = result.getJSONObject("data").getJSONArray("object_list");
                    for (Object x : itemList) {
                        try {
                            JSONObject json = (JSONObject) x;
                            Photo photo = new Photo();
                            JSONObject head = json.getJSONObject("album");
                            photo.setId(json.getInteger("id"));
                            photo.setTitle(head.getString("name"));
                            JSONObject photo1 = json.getJSONObject("photo");
                            photo.setPhoto(photo1.getString("path"));
                            photo.setHeight(photo1.getInteger("height"));

                            JSONObject authorMsg = json.getJSONObject("sender");
                            photo.setAuthor(authorMsg.getString("username"));
                            photo.setAuthorUrl(authorMsg.getString("avatar"));

                            photo.setMsg(json.getString("msg"));
                            Long time = json.getTimestamp("add_datetime_ts").getTime()*1000L;
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String format = simpleDateFormat.format(new Date(time));
                            photo.setTime(format);
                            photo.setType(entry.getKey());
                            photo.setZan(json.getInteger("like_count"));
                            photo.setShoucang(json.getInteger("favorite_count"));
                            photo.setPinglun(0);
                            photo.setDown(0);
                            System.out.println(JSON.toJSONString(photo));
                            photoMapper.insertById(photo);
                        }
                       catch (DuplicateKeyException e) {
                            System.out.println("有重复的内容，自动过滤");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                } finally {
                    if (response != null) {
                        response.close();
                    }
                    if (client != null) {
                        client.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
