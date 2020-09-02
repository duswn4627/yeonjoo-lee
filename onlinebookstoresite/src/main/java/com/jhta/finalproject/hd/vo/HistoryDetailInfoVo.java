package com.jhta.finalproject.hd.vo;

import java.sql.Date;

public class HistoryDetailInfoVo {
	private int bpaynum;
	private Date borderdate;
	private int bstatus;
	private Date bpaydate;
	private String mid;
	private String mname;
	private String receiver;
	private String bphone;
	private String baddr;
	private int delfee;
	private int usedpoint;
	private int bfinalmoney; 
	private int methodpayment;
	
	public HistoryDetailInfoVo() {}

	public HistoryDetailInfoVo(int bpaynum, Date borderdate, int bstatus, Date bpaydate, String mid, String mname,
			String receiver, String bphone, String baddr, int delfee, int usedpoint, int bfinalmoney,
			int methodpayment) {
		super();
		this.bpaynum = bpaynum;
		this.borderdate = borderdate;
		this.bstatus = bstatus;
		this.bpaydate = bpaydate;
		this.mid = mid;
		this.mname = mname;
		this.receiver = receiver;
		this.bphone = bphone;
		this.baddr = baddr;
		this.delfee = delfee;
		this.usedpoint = usedpoint;
		this.bfinalmoney = bfinalmoney;
		this.methodpayment = methodpayment;
	}

	public int getBpaynum() {
		return bpaynum;
	}

	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
	}

	public Date getBorderdate() {
		return borderdate;
	}

	public void setBorderdate(Date borderdate) {
		this.borderdate = borderdate;
	}

	public int getBstatus() {
		return bstatus;
	}

	public void setBstatus(int bstatus) {
		this.bstatus = bstatus;
	}

	public Date getBpaydate() {
		return bpaydate;
	}

	public void setBpaydate(Date bpaydate) {
		this.bpaydate = bpaydate;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public String getBphone() {
		return bphone;
	}

	public void setBphone(String bphone) {
		this.bphone = bphone;
	}

	public String getBaddr() {
		return baddr;
	}

	public void setBaddr(String baddr) {
		this.baddr = baddr;
	}

	public int getDelfee() {
		return delfee;
	}

	public void setDelfee(int delfee) {
		this.delfee = delfee;
	}

	public int getUsedpoint() {
		return usedpoint;
	}

	public void setUsedpoint(int usedpoint) {
		this.usedpoint = usedpoint;
	}

	public int getBfinalmoney() {
		return bfinalmoney;
	}

	public void setBfinalmoney(int bfinalmoney) {
		this.bfinalmoney = bfinalmoney;
	}

	public int getMethodpayment() {
		return methodpayment;
	}

	public void setMethodpayment(int methodpayment) {
		this.methodpayment = methodpayment;
	}
	
	
	
}
