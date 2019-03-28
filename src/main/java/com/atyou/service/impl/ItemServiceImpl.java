package com.atyou.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.atyou.common.TaotaoResult;
import com.atyou.dao.DetailMapper;
import com.atyou.pojo.Detail;
import com.atyou.service.ItemService;
import com.atyou.util.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 商品管理
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private DetailMapper detailMapper;
	
	//商品添加
	@Override
	public TaotaoResult addItem(Detail item, String desc) throws Exception {
		
		//生成商品id
		//final Integer itemId = (int) IDUtils.genItemId();
		//补全item的属性
		//item.setId(itemId);
			//商品状态 1 正常 2下架 3删除	
		item.setTitle(item.getTitle());
		item.setSummary("1");
		item.setWriter(item.getWriter());
		item.setImage1(item.getImage1());
		item.setContent(item.getContent());
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCategoryId(item.getCategoryId());
		item.setParentCategoryId(item.getParentCategoryId());
		//商品表插入数据
		detailMapper.insert(item);
		//创建一个商品描述表对应的pojo
		/*
		//向Activemq发送商品添加消息
		jmsTemplate.send(destination,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				//要发送商品id
				TextMessage textMessage = session.createTextMessage(itemId + "");
				return textMessage;
			}
		});*/
		//返回结果
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult updateItem(Detail item, String desc) throws Exception {
		item.setSummary("1");
		item.setUpdateTime(new Date());
		
		//商品表插入数据
		detailMapper.updateByPrimaryKey(item);
		//创建一个商品描述表对应的pojo
		/*
		//向Activemq发送商品添加消息
		jmsTemplate.send(destination,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				//要发送商品id
				TextMessage textMessage = session.createTextMessage(itemId + "");
				return textMessage;
			}
		});*/
		//返回结果
		return TaotaoResult.ok();
	}


	
}
