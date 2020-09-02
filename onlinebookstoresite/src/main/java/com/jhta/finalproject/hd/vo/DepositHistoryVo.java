package com.jhta.finalproject.hd.vo;

import java.sql.Date;

public class DepositHistoryVo {
	private int dnum;
	private int mnum;
	private int bpaynum;
	private int dtran;
	private Date trandate;
	private int dereason;
	
	public DepositHistoryVo() {}
	public DepositHistoryVo(int dnum, int mnum, int bpaynum, int dtran, Date trandate, int dereason) {
		super();
		this.dnum = dnum;
		this.mnum = mnum;
		this.bpaynum = bpaynum;
		this.dtran = dtran;
		this.trandate = trandate;
		this.dereason = dereason;
	}
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getBpaynum() {
		return bpaynum;
	}
	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
	}
	public int getDtran() {
		return dtran;
	}
	public void setDtran(int dtran) {
		this.dtran = dtran;
	}
	public Date getTrandate() {
		return trandate;
	}
	public void setTrandate(Date trandate) {
		this.trandate = trandate;
	}
	public int getDereason() {
		return dereason;
	}
	public void setDereason(int dereason) {
		this.dereason = dereason;
	}
	
	
	
}
