package com.jhta.finalproject.yj.vo;

import java.util.Date;

public class MembersVO {
	private int mnum;
	private String mname;
	private String mid;
	private String mpwd;
	private String email;
	private String phone;
	private String addr;
	private Date regdate;
	private int grade;
	private int mstatus;
	private Date birth;
	private String sex;

	// 회원목록 뽑을 때 필요한
	private int age;

	public MembersVO() {
		super();
	}

	// 회원목록 뽑을 때 필요한
	public MembersVO(String mname, String mid, String email, String phone, Date regdate, int mstatus, Date birth,
			int age) {
		super();
		this.mname = mname;
		this.mid = mid;
		this.email = email;
		this.phone = phone;
		this.regdate = regdate;
		this.mstatus = mstatus;
		this.birth = birth;
		this.age = age;
	}

	public MembersVO(int mnum, String mname, String mid, String mpwd, String email, String phone, String addr,
			Date regdate, int grade, int mstatus, Date birth, String sex) {
		super();
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpwd = mpwd;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.regdate = regdate;
		this.grade = grade;
		this.mstatus = mstatus;
		this.birth = birth;
		this.sex = sex;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getMstatus() {
		return mstatus;
	}

	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
