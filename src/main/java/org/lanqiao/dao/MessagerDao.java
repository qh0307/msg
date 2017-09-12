package org.lanqiao.dao;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Messager;

public interface MessagerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Messager record);

    int insertSelective(Messager record);

    Messager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messager record);

    int updateByPrimaryKey(Messager record);
    
    List<Messager>getMessagerByPage(int pageSize,int beginNum);   
    
    int getMessagercount();
    
    int insertMessager(Messager messager);
    
    List<Messager>searchMsg(Map map);
}