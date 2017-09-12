package org.lanqiao.dao;

import java.sql.Date;
import java.util.List;

import org.lanqiao.entity.Student;

public class StudentImp extends BaseDao<Student> implements StudentDao {

	public List<Student> getstudentByPage(int pageSize, int pageNum) {
		return executeQuery("select * from students limit " + pageSize * (pageNum - 1) + "," + pageSize);
	}

	public int getMaxPage(int pageSize) {
		return executeQueryMaxPage("select count(*)from students", pageSize);

	}

	public int updatestudent(Student s) {
		return executeUpdate("update students set stuName=?, stuGender=? ,stuBirthday=? ,classId=? where stuId=?", new Object[] {
				s.getStuName(), s.getStuGender(), new Date(s.getStuBirthday().getTime()), s.getClassId(), s.getStuId() });
	}

	@Override
	public Student getStuById(String id) {
		return super.executeQuery("select * from students where stuId=?", new Object[] { id }).get(0);
	}

	@Override
	public int insertStudent(Student s) {
		return executeUpdate("insert into students (stuName, stuGender ,stuBirthday ,classId) values(?,?,?,?)",
				new Object[] { s.getStuName(), s.getStuGender(), new Date(s.getStuBirthday().getTime()), s.getClassId() });
	}

	@Override
	public int deleteStu(int id) {
		return executeUpdate("delete from students where stuId=?", new Object[] { id });
	}

}
