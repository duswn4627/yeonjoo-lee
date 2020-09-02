package com.jhta.finalproject.jh.vo;

import java.util.Date;

public class SellerBpaymentVo {
	private int bpaynum;
	private String baddr;
	private String bphone;
	private int bfinalmoney;
	private Date borderdate;
	private Date bpaydate;
	private int bstatus;
	private int ordermoney;
	private int usedpoint;
	private int mothodpayment;
	private String receiver;
	private int mnum;
	private int delfee;
	
	public SellerBpaymentVo() {}
	
	public SellerBpaymentVo(int bpaynum, String baddr, String bphone, int bfinalmoney, Date borderdate, Date bpaydate,
			int bstatus, int ordermoney, int usedpoint, int mothodpayment, String receiver, int mnum, int delfee) {
		super();
		this.bpaynum = bpaynum;
		this.baddr = baddr;
		this.bphone = bphone;
		this.bfinalmoney = bfinalmoney;
		this.borderdate = borderdate;
		this.bpaydate = bpaydate;
		this.bstatus = bstatus;
		this.ordermoney = ordermoney;
		this.usedpoint = usedpoint;
		this.mothodpayment = mothodpayment;
		this.receiver = receiver;
		this.mnum = mnum;
		this.delfee = delfee;
	}
	public int getBpaynum() {
		return bpaynum;
	}
	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
	}
	public String getBaddr() {
		return baddr;
	}
	public void setBaddr(String baddr) {
		this.baddr = baddr;
	}
	public String getBphone() {
		return bphone;
	}
	public void setBphone(String bphone) {
		this.bphone = bphone;
	}
	public int getBfinalmoney() {
		return bfinalmoney;
	}
	public void setBfinalmoney(int bfinalmoney) {
		this.bfinalmoney = bfinalmoney;
	}
	public Date getBorderdate() {
		return borderdate;
	}
	public void setBorderdate(Date borderdate) {
		this.borderdate = borderdate;
	}
	public Date getBpaydate() {
		return bpaydate;
	}
	public void setBpaydate(Date bpaydate) {
		this.bpaydate = bpaydate;
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
	public int getUsedpoint() {
		return usedpoint;
	}
	public void setUsedpoint(int usedpoint) {
		this.usedpoint = usedpoint;
	}
	public int getMothodpayment() {
		return mothodpayment;
	}
	public void setMothodpayment(int mothodpayment) {
		this.mothodpayment = mothodpayment;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getDelfee() {
		return delfee;
	}
	public void setDelfee(int delfee) {
		this.delfee = delfee;
	}
	
	
}
