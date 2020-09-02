package com.jhta.finalproject.hd.vo;

import java.sql.Date;

public class MemberinfoVo {
	private String mname;
	private Date regdate;
	private String mpwd;
	private String email;
	private String phone;
	private String mid;
	private String addr;
	private String sex;
	private Date birth;
	private int grade;
	private int mstatus;
	public MemberinfoVo() {}
	
	
	public MemberinfoVo(String mname, Date regdate, String mpwd, String email, String phone, String mid, String addr,
			String sex, Date birth, int grade, int mstatus) {
		super();
		this.mname = mname;
		this.regdate = regdate;
		this.mpwd = mpwd;
		this.email = email;
		this.phone = phone;
		this.mid = mid;
		this.addr = addr;
		this.sex = sex;
		this.birth = birth;
		this.grade = grade;
		this.mstatus = mstatus;
	}


	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
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
	
	
	
}
