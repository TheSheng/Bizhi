package com.bishe.java.controller;

import com.bishe.java.mapper.PhotoMapper;
import com.bishe.java.pojo.Photo;
import com.bishe.java.util.ResponseError;
import com.bishe.java.util.ResponseOk;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName： ActionController
 * @description:
 * @author: lisheng
 * @create: 2020-02-27 11:17
 **/
@RestController
@RequestMapping("/action")
@CrossOrigin(value = "*",maxAge = 3600)
public class ActionController {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    PhotoMapper photoMapper;

    @GetMapping("/getZanShoucang")
    public ResponseEntity getList(@RequestParam("username")String username){
        try {


            Set<String> zan = redisTemplate.opsForSet().members("userZan:" + username);
            Set<String> shoucang = redisTemplate.opsForSet().members("userShoucang:" + username);
            Map<String, Set<String>> action = new HashMap<>();
            action.put("zan", zan);
            action.put("shoucang", shoucang);
            return ResponseOk.create(action);
        }catch (Exception e){
            return ResponseError.create(e.getMessage());
        }
    }
    @GetMapping("/action")
    public void action(@RequestParam("username")String username,@RequestParam("type") String type,@RequestParam("photoId") String photoId){
        if("zan".equals(type)){
            redisTemplate.opsForSet().add("userZan:"+username,photoId);
            photoMapper.updateZanByAction(1,Integer.valueOf(photoId));
        }else if("clearzan".equals(type)){
            redisTemplate.opsForSet().remove("userZan:"+username,photoId);
            photoMapper.updateZanByAction(-1,Integer.valueOf(photoId));

        }else if("shoucang".equals(type)){
            redisTemplate.opsForSet().add("userShoucang:"+username,photoId);
            photoMapper.updateShoucangByAction(1,Integer.valueOf(photoId));

        }else if("clearshoucang".equals(type)){
            redisTemplate.opsForSet().remove("userShoucang:"+username,photoId);
            photoMapper.updateShoucangByAction(-1,Integer.valueOf(photoId));

        }

    }
    @GetMapping("/getPingLun")
    public ResponseEntity getPinglun(@RequestParam("photoId") String id){
        List<String> range = redisTemplate.opsForList().range("photoPinglun:" + id, 0, -1);
        range.add("欢迎各位同学的踊跃发言");

        return  ResponseOk.create(range);
    }
    @GetMapping("/getPingLunNum")
    public ResponseEntity getPinglunNum(@RequestParam("photoId") String id){
        Long size = redisTemplate.opsForList().size("photoPinglun:" + id);

        return  ResponseOk.create(size);
    }
    @PostMapping("/pingLun")
    public void Pinglun(@RequestBody Map param){
        redisTemplate.opsForSet().add("userPinglun:"+param.get("phone"),MapUtils.getString(param,"photoId"));
        redisTemplate.opsForList().leftPush("photoPinglun:"+param.get("photoId"),MapUtils.getString(param,"pinglun"));
        photoMapper.updatePinglunByAction(1, MapUtils.getInteger(param,"photoId"));
    }
    @GetMapping("/getUserAction")
    public ResponseEntity getUserACtion(@RequestParam("type")String type,@RequestParam("user")String user){
        try {
            Set<String> members = redisTemplate.opsForSet().members("user" + type + ":" + user);
            List<Photo> photos = photoMapper.selectInList(members);
            return  ResponseOk.create(photos);
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseError.create(e.getMessage());
        }

    }


}
