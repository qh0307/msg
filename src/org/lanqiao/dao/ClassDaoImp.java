package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Classes;

public class ClassDaoImp extends BaseDao<Classes> implements ClassDao {

	@Override
	public List<Classes> getClassesList() {
	return executeQuery("select * from classes");
	}

}
