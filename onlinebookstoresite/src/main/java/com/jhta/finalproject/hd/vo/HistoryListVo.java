package com.jhta.finalproject.hd.vo;

import java.sql.Date;

public class HistoryListVo {
	private int ordernum;
	private Date borderdate;
	private int bfinalmoney;
	private int delfee;
	private int bstatus;
	private int ordermoney;
	private String mname;
	private String receiver;
	private int btype;
	private String ordername;
	
	//주문상태 ((( 마이페이지 최근 리스트에서만 사용함 )))
	private String statusStr;
	
	public HistoryListVo() {}

	public HistoryListVo(int ordernum, Date borderdate, int bfinalmoney, int delfee, int bstatus, int ordermoney,
			String mname, String receiver, int btype, String ordername, String statusStr) {
		super();
		this.ordernum = ordernum;
		this.borderdate = borderdate;
		this.bfinalmoney = bfinalmoney;
		this.delfee = delfee;
		this.bstatus = bstatus;
		this.ordermoney = ordermoney;
		this.mname = mname;
		this.receiver = receiver;
		this.btype = btype;
		this.ordername = ordername;
		this.statusStr = statusStr;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public Date getBorderdate() {
		return borderdate;
	}

	public void setBorderdate(Date borderdate) {
		this.borderdate = borderdate;
	}

	public int getBfinalmoney() {
		return bfinalmoney;
	}

	public void setBfinalmoney(int bfinalmoney) {
		this.bfinalmoney = bfinalmoney;
	}

	public int getDelfee() {
		return delfee;
	}

	public void setDelfee(int delfee) {
		this.delfee = delfee;
	}

	public int getBstatus() {
		return bstatus;
	}

	public void setBstatus(int bstatus) {
		this.bstatus = bstatus;
	}

	public int getOrdermoney() {
		return ordermoney;
	}

	public void setOrdermoney(int ordermoney) {
		this.ordermoney = ordermoney;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
	

}
