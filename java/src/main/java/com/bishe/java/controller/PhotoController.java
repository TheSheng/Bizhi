package com.bishe.java.controller;

import com.bishe.java.mapper.PhotoMapper;
import com.bishe.java.pojo.Photo;
import com.bishe.java.util.PageInfo;
import com.bishe.java.util.ResponseError;
import com.bishe.java.util.ResponseOk;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName： PhotoController
 * @description:
 * @author: lisheng
 * @create: 2020-02-21 16:09
 **/
@RestController
@RequestMapping ("/photo")
@CrossOrigin(value = "*",maxAge = 3600)
public class PhotoController {
    @Autowired
    PhotoMapper photoMapper;
    @GetMapping("down")
    public  void download(@RequestParam("urlString") String urlString,HttpServletResponse response) throws Exception {
        photoMapper.updateByUrlString(urlString);
        String filename="photo.JPEG";
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = is.read(buff, 0, 100)) > 0) {
            byteArrayOutputStream.write(buff, 0, rc);
        }
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(byteArrayOutputStream.toByteArray());
    }

    @PostMapping("/getByType")
    public ResponseEntity getType(@RequestBody Map param){
        try {
            List<Photo> photos = null;
            PageHelper.startPage(MapUtils.getInteger(param, "page"), MapUtils.getInteger(param, "size"));
            if ("推荐".equals(MapUtils.getString(param, "type", "美食菜谱"))) {
                photos = photoMapper.selectByTuiJian();

            }else if("hot".equals(MapUtils.getString(param, "type", "美食菜谱"))) {
                 photos=photoMapper.selectByHuo();
            }
            else if("new".equals(MapUtils.getString(param, "type", "美食菜谱"))) {
                photos=photoMapper.selectByNew();
            }
            else{

                photos = photoMapper.selectByType(MapUtils.getString(param, "type", "美食菜谱"));
            }
            return ResponseOk.create(new PageInfo<>(photos));
        }catch (Exception e){
            return ResponseError.create(e.getMessage());
        }

    }
    @GetMapping("/getByAuthor")
    public ResponseEntity getByAuthor(@RequestParam("author") String author){
        try {
            List<Photo> photos = photoMapper.selectByAuthor(author);
            return ResponseOk.create(photos);
        }catch (Exception e){
            return ResponseError.create(e.getMessage());
        }

    }
    @GetMapping("/getByLike")
    public ResponseEntity getByLike(@RequestParam("like") String like){
        try {
            List<Photo> photos = photoMapper.selectByMsg(like);
            return ResponseOk.create(photos);
        }catch (Exception e){
            return ResponseError.create(e.getMessage());
        }

    }

}
