package com.jhta.finalproject.hd.vo;

import java.sql.Date;

public class AccountHistoryVo {
	private int senum;
	private int anum;
	private int reqmoney;
	private int sestatus;
	private Date appdate;
	private Date comdate;
	
	public AccountHistoryVo() {}
	
	public AccountHistoryVo(int senum, int anum, int reqmoney, int sestatus, Date appdate, Date comdate) {
		super();
		this.senum = senum;
		this.anum = anum;
		this.reqmoney = reqmoney;
		this.sestatus = sestatus;
		this.appdate = appdate;
		this.comdate = comdate;
	}
	public int getSenum() {
		return senum;
	}
	public void setSenum(int senum) {
		this.senum = senum;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public int getReqmoney() {
		return reqmoney;
	}
	public void setReqmoney(int reqmoney) {
		this.reqmoney = reqmoney;
	}
	public int getSestatus() {
		return sestatus;
	}
	public void setSestatus(int sestatus) {
		this.sestatus = sestatus;
	}
	public Date getAppdate() {
		return appdate;
	}
	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}
	public Date getComdate() {
		return comdate;
	}
	public void setComdate(Date comdate) {
		this.comdate = comdate;
	}
	
	
	
	
}
