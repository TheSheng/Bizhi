package com.bishe.java.controller;

import com.bishe.java.mapper.PhotoMapper;
import com.bishe.java.pojo.Photo;
import com.bishe.java.util.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName： ChartsController
 * @description: 为数据可视化提供支持
 * @author: lisheng
 * @create: 2020-02-28 15:31
 **/
@RestController
@RequestMapping("/charts")
@CrossOrigin(value = "*",maxAge = 3600)
public class ChartsController {
    @Autowired
    PhotoMapper photoMapper;


    @GetMapping("/getNumByType")
    public ResponseEntity getNumByType(){
        List<Map> numBytype = photoMapper.getNumBytype();
        List<List> rs=new ArrayList<>();
        List<String> key=new ArrayList<>();
        List<Integer> value=new ArrayList<>();
        numBytype.forEach(x->
        {
            String type = x.get("type").toString();
            if(type.equals("壁纸")){
                type="高清壁纸";
            }
            key.add(type);
            value.add(Integer.parseInt(x.get("num").toString()));
        });
        rs.add(key);
        rs.add(value);
        return ResponseOk.create(rs);
    }
    @GetMapping("/getZeroShoucang")
    public ResponseEntity get0Shoucang(){
        List<Integer> shouCang = photoMapper.get0ShouCang();

        return ResponseOk.create(shouCang);
    }
    @GetMapping("/getZeroZan")
    public ResponseEntity get0Zan(){
        List<Integer> zan = photoMapper.get0Zan();

        return ResponseOk.create(zan);
    }
    @GetMapping("getScoreTen")
    public  ResponseEntity getScore10(){
        List<Photo> scoreTen = photoMapper.getScoreTen();
        List<List> rs=new ArrayList<>();
        List<Integer> score=new ArrayList<>();
        scoreTen.forEach(x->{
           score.add(x.getZan()+x.getShoucang());
        });
        rs.add(score);
        rs.add(scoreTen);
        return ResponseOk.create(rs);
    }
    @GetMapping("getSumZan")
    public  ResponseEntity getSumZan(){
        List<Map> sumZan = photoMapper.getSumZan();
        List<List> rs=new ArrayList<>();
        List<String> key=new ArrayList<>();
        List<Object> value=new ArrayList<>();
        sumZan.forEach(x->{
            key.add(x.get("type").toString());
            value.add(x.get("sum"));

        });
        rs.add(key);
        rs.add(value);
        return ResponseOk.create(rs);
    }
    @GetMapping("getSumShoucang")
    public  ResponseEntity getSumShoucang(){
        List<Map> sumShoucang = photoMapper.getSumShoucang();
        List<List> rs=new ArrayList<>();
        List<String> key=new ArrayList<>();
        List<Object> value=new ArrayList<>();
        sumShoucang.forEach(x->{
            key.add(x.get("type").toString());
            value.add(x.get("sum"));

        });
        rs.add(key);
        rs.add(value);
        return ResponseOk.create(rs);
    }

}
