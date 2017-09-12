package org.lanqiao.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBPool {
	
		//1�������������͵Ķ���static��
		private static DBPool db = null;
		private DataSource ds = new ComboPooledDataSource("mysqlConnection");
		//2��˽�л����췽��
		private DBPool(){}
		//3�����巽�����ڻ�ȡ�������
		public static DBPool getInstance(){
			if(null == db){
				db = new DBPool();
			}
			return db;
		}
		public Connection getConn() {
			try {
				 return ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	}


