package org.lanqiao.entity;

import java.util.Date;

public class Student {
	private int stuId;
	private String stuName;
	private Date stuBirthday;
	private String stuGender;
	private String stuTelephone;
	private String stuEmail;
	private int classId;

	public Student() {
		super();
	}

	public Student(int stuId, String stuName, Date stuBirthday, String stuGender, String stuTelephone, String stuEmail,
			int classId) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuBirthday = stuBirthday;
		this.stuGender = stuGender;
		this.stuTelephone = stuTelephone;
		this.stuEmail = stuEmail;
		this.classId = classId;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Date getStuBirthday() {
		return stuBirthday;
	}

	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}

	public String getStuGender() {
		return stuGender;
	}

	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}

	public String getStuTelephone() {
		return stuTelephone;
	}

	public void setStuTelephone(String stuTelephone) {
		this.stuTelephone = stuTelephone;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public int getClassId() {
		return classId;
	}

	public Student(int stuId, String stuName, Date stuBirthday, String stuGender, int classId) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuBirthday = stuBirthday;
		this.stuGender = stuGender;
		this.classId = classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

}
