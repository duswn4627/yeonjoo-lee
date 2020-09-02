package com.jhta.finalproject.yr.vo;

import java.sql.Date;

public class SettlementJoinVo {

	//acount
//	ANUM	NUMBER
//	MNUM	NUMBER
//	BANK	VARCHAR2(50 BYTE)
//	ACCOUNT	NUMBER
	private int anum;
	private int mnum;
	private String bank;
	private int account;
	//member
	private String mname;
	//settlement
//	SENUM	NUMBER
//	ANUM	NUMBER
//	REQMONEY	NUMBER
//	SESTATUS	NUMBER
//	APPDATE	DATE
//	COMDATE	DATE
	private int senum;
	private int reqmoney;
	private int sestatus;
	private Date appdate;
	private Date comdate;
	
	
	

	@Override
	public String toString() {
		return "SettlementJoinVo [anum=" + anum + ", mnum=" + mnum + ", bank=" + bank + ", account=" + account
				+ ", mname=" + mname + ", senum=" + senum + ", reqmoney=" + reqmoney + ", sestatus=" + sestatus
				+ ", appdate=" + appdate + ", comdate=" + comdate + "]";
	}



	public SettlementJoinVo() {
		// TODO Auto-generated constructor stub
	}
	

	
	public SettlementJoinVo(int anum, int mnum, String bank, int account, String mname, int senum, int reqmoney,
			int sestatus, Date appdate, Date comdate) {
		super();
		this.anum = anum;
		this.mnum = mnum;
		this.bank = bank;
		this.account = account;
		this.mname = mname;
		this.senum = senum;
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
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
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
