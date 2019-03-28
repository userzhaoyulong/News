package com.atyou.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.atyou.pojo.ColResult;
import com.atyou.pojo.CommentResult;
import com.atyou.pojo.Newscol;
import com.atyou.pojo.NewscolExample;

public interface NewscolMapper {
    int countByExample(NewscolExample example);

    int deleteByExample(NewscolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Newscol record);

    int insertSelective(Newscol record);

    List<Newscol> selectByExample(NewscolExample example);

    Newscol selectByPrimaryKey(Integer id);
    List<ColResult> queryCommUserNoDetail(Integer userId);
    
    int updateByExampleSelective(@Param("record") Newscol record, @Param("example") NewscolExample example);

    int updateByExample(@Param("record") Newscol record, @Param("example") NewscolExample example);

    int updateByPrimaryKeySelective(Newscol record);

    int updateByPrimaryKey(Newscol record);
}