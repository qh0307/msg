package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Student;

public interface StudentDao {

	
	
	public abstract List<Student>getstudentByPage(int pageSize,int pageNum);
		
    public abstract Student getStuById(String id) ;
    	
    
	
	public abstract int getMaxPage(int pageSize);
		
	
	public abstract int updatestudent(Student s);
	
	public int insertStudent(Student s);
	public  int deleteStu(int id) ;
		
	
}
