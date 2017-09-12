package org.lanqiao.service;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Messager;

public interface MsgService {
	
public	List<Messager>getMessagerByPage(int pageSize,int pageNum);

public  int getMaxPage(int pageSize);

public int addMsg(Messager messager);

public List<Messager>searchMsg(Map map);


}
