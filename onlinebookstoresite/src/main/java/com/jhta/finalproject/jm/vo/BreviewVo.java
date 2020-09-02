package com.jhta.finalproject.jm.vo;

import java.util.Date;

public class BreviewVo {

	private int reviewnum;
	private int mnum;
	private int bnum;
	private String reviewcontent;
	private int bscore;
	private Date breviewregdate;
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
	
	public BreviewVo() {}

	public BreviewVo(int reviewnum, int mnum, int bnum, String reviewcontent, int bscore, Date breviewregdate,
			String mname, String mid, String mpwd, String email, String phone, String addr, Date regdate, int grade,
			int mstatus, String birth, String sex) {
		super();
		this.reviewnum = reviewnum;
		this.mnum = mnum;
		this.bnum = bnum;
		this.reviewcontent = reviewcontent;
		this.bscore = bscore;
		this.breviewregdate = breviewregdate;
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

	public int getReviewnum() {
		return reviewnum;
	}

	public void setReviewnum(int reviewnum) {
		this.reviewnum = reviewnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getReviewcontent() {
		return reviewcontent;
	}

	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}

	public int getBscore() {
		return bscore;
	}

	public void setBscore(int bscore) {
		this.bscore = bscore;
	}

	public Date getBreviewregdate() {
		return breviewregdate;
	}

	public void setBreviewregdate(Date breviewregdate) {
		this.breviewregdate = breviewregdate;
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