package org.lanqiao.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.lanqiao.dao.MessagerDao;
import org.lanqiao.entity.Messager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MsgServiceImp implements MsgService {
   @Autowired
	MessagerDao dao;
	@Override
	public List<Messager> getMessagerByPage(int pageSize,int pageNum) {
	
			return dao.getMessagerByPage(pageSize,pageSize*(pageNum-1));
	}

	@Override
	public int getMaxPage(int pageSize) {
	
			int count= dao.getMessagercount();
	        return count % pageSize==0? count/pageSize:count/pageSize+1;
	}

	@Override
	public int addMsg(Messager messager) {

		return  dao.insertMessager(messager);
		
		  
	}

	@Override
	public List<Messager> searchMsg(Map map) {
	
		 return dao.searchMsg(map);
	}
	

}
