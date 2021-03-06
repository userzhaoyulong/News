package com.atyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atyou.dao.NewscolMapper;
import com.atyou.dao.UserlogMapper;
import com.atyou.pojo.ColResult;
import com.atyou.pojo.CommentExample;
import com.atyou.pojo.CommentResult;
import com.atyou.pojo.Userlog;
import com.atyou.pojo.UserlogExample;
import com.atyou.pojo.CommentExample.Criteria;
import com.atyou.service.UserMyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserMyServiceImpl implements UserMyService {

	@Autowired
	private NewscolMapper newscolMapper;
	@Autowired
	private UserlogMapper userlogMapper;
	
	@Override
	public PageInfo colPage(Integer pn, Integer userId) throws Exception {
		 //引入分页查询，使用PageHelper分页功能  
	    //在查询之前传入当前页，然后多少记录  
	    PageHelper.startPage(pn,5);  
	    //startPage后紧跟的这个查询就是分页查询  
	   
	    List<ColResult> emps = newscolMapper.queryCommUserNoDetail(userId);
	    //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
	    PageInfo pageInfo = new PageInfo<>(emps,5);  
	    //pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
	    
		return pageInfo;

	}

	@Override
	public PageInfo ipPage(Integer pn, Integer userId) throws Exception {
		 //引入分页查询，使用PageHelper分页功能  
	    //在查询之前传入当前页，然后多少记录  
	    PageHelper.startPage(pn,5);  
	    //startPage后紧跟的这个查询就是分页查询  
	   UserlogExample example = new UserlogExample();
	   com.atyou.pojo.UserlogExample.Criteria criteria = example.createCriteria();
	   criteria.andUserIdEqualTo(userId);
	    List<Userlog> emps = userlogMapper.selectByExample(example);
	    //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
	    PageInfo pageInfo = new PageInfo<>(emps,5);  
	    //pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
	    
		return pageInfo;
	}

}
