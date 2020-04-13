package com.bishe.java.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @ClassName： Photo
 * @description: 壁纸实体类
 * @author: lisheng
 * @create: 2020-02-21 10:26
 **/
@TableName("photo")

public class Photo  implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private  String photo;
    private  String msg;
    private  String author;
    private  String authorUrl;
    private  String time;
    private  String type;
    private Integer zan;
    private Integer shoucang;
    private  Integer pinglun;
    private Integer down;
    private Integer height;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public Integer getShoucang() {
        return shoucang;
    }

    public void setShoucang(Integer shoucang) {
        this.shoucang = shoucang;
    }

    public Integer getPinglun() {
        return pinglun;
    }

    public void setPinglun(Integer pinglun) {
        this.pinglun = pinglun;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
