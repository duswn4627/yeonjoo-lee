package com.jhta.finalproject.jm.vo;

import java.util.Date;

public class OldBreviewVo {

	private int sreviewnum;
	private int mnum;
	private int obnum;
	private String sreviewcontent;
	private int sscore;
	private Date sreviewregdate;
	private String mname;
	private String mid;
	private String mpwd;
	private String email;
	private String phone;
	private String addr;
	private Date regdate;
	private int grade;
	private int mstatus;
	private String birth;
	private String sex;
	
	public OldBreviewVo() {}

	public OldBreviewVo(int sreviewnum, int mnum, int obnum, String sreviewcontent, int sscore, Date sreviewregdate,
			String mname, String mid, String mpwd, String email, String phone, String addr, Date regdate, int grade,
			int mstatus, String birth, String sex) {
		super();
		this.sreviewnum = sreviewnum;
		this.mnum = mnum;
		this.obnum = obnum;
		this.sreviewcontent = sreviewcontent;
		this.sscore = sscore;
		this.sreviewregdate = sreviewregdate;
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

	public int getSreviewnum() {
		return sreviewnum;
	}

	public void setSreviewnum(int sreviewnum) {
		this.sreviewnum = sreviewnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getObnum() {
		return obnum;
	}

	public void setObnum(int obnum) {
		this.obnum = obnum;
	}

	public String getSreviewcontent() {
		return sreviewcontent;
	}

	public void setSreviewcontent(String sreviewcontent) {
		this.sreviewcontent = sreviewcontent;
	}

	public int getSscore() {
		return sscore;
	}

	public void setSscore(int sscore) {
		this.sscore = sscore;
	}

	public Date getSreviewregdate() {
		return sreviewregdate;
	}

	public void setSreviewregdate(Date sreviewregdate) {
		this.sreviewregdate = sreviewregdate;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}