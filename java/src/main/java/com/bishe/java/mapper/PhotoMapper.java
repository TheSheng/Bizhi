package com.bishe.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.java.pojo.Photo;
import com.bishe.java.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {
    void insertById(@Param("photo") Photo photo);
    List<Photo> selectByType(@Param("type")String type);
    List<Photo> selectByTuiJian();
    List<Photo> selectByHuo();
    List<Photo> selectByNew();
    List<Map>  getNumBytype();
    List<Integer>  get0ShouCang();
    List<Integer>  get0Zan();
    List<Photo>  getScoreTen();
    List<Map> getSumZan();
    List<Map> getSumShoucang();

    List<Photo> selectByAuthor(@Param("author")String author);
    List<Photo> selectByMsg(@Param("msg")String msg);
    void updateZanByAction(@Param("count")Integer count,@Param("id")Integer id);
    void updateShoucangByAction(@Param("count")Integer count,@Param("id")Integer id);
    void updatePinglunByAction(@Param("count")Integer count,@Param("id")Integer id);
    List<Photo> selectInList(@Param("list") Set<String> idString);
    void updateByUrlString(@Param("urlString")String urlString);


}
