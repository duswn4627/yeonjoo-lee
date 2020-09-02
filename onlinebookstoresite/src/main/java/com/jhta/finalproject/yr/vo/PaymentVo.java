package com.jhta.finalproject.yr.vo;

import java.sql.Date;

public class PaymentVo {
//	BPAYNUM	NUMBER
//	BADDR	VARCHAR2(500 BYTE)
//	BPHONE	NVARCHAR2(30 CHAR)
//	BFINALMONEY	NUMBER
//	BODERDATE	DATE
//	BPAYDATE	DATE
//	BSTATUS	NUMBER
//	BTYPE	NUMBER
//	BNUM	NUMBER
//	ORDERMONEY	NUMBER
//	USEDPOINT	NUMBER
//	MeTHODPAYMENT	NUMBER
//	RECEIVER	VARCHAR2(20 BYTE)
//	MNUM	NUMBER

	private int bpaynum; // 지불번호
	private String baddr; // 주문자 집 주소
	private String bphone; // 주문자 전화번호
	private int bfinalmoney; // 결제금액
	private Date borderdate; // 주문날짜
	private Date bpaydate; // 결제 날짜
	private int bstatus; // 상태 (0:주문(입금전), 1:결제완료,2:배송중,3:수령완료(구매확정),4:cs상태)
	private int ordermoney; // 주문금액
	private int usedpoint; // 포인트 사용량
	private int methodpayment; // 지불방법(0:카드,1:무통장)
	private String receiver;// 수령인
	private int delfee;// 배송료
	private int mnum; // 회원 번호

	public PaymentVo() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentVo(int bpaynum, String baddr, String bphone, int bfinalmoney, Date borderdate, Date bpaydate,
			int bstatus, int ordermoney, int usedpoint, int methodpayment, String receiver, int delfee, int mnum) {
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
		this.methodpayment = methodpayment;
		this.receiver = receiver;
		this.delfee = delfee;
		this.mnum = mnum;
	}

	public Date getBorderdate() {
		return borderdate;
	}

	public void setBorderdate(Date borderdate) {
		this.borderdate = borderdate;
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

	
	public int getOdermoney() {
		return ordermoney;
	}

	public void setOdermoney(int ordermoney) {
		this.ordermoney = ordermoney;
	}

	public int getUsedpoint() {
		return usedpoint;
	}

	public void setUsedpoint(int usedpoint) {
		this.usedpoint = usedpoint;
	}

	public int getMethodpayment() {
		return methodpayment;
	}

	public void setMethodpayment(int mothodpayment) {
		this.methodpayment = mothodpayment;
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

	public int getOrdermoney() {
		return ordermoney;
	}

	public void setOrdermoney(int ordermoney) {
		this.ordermoney = ordermoney;
	}

	public int getDelfee() {
		return delfee;
	}

	public void setDelfee(int delfee) {
		this.delfee = delfee;
	}
	
	
}
