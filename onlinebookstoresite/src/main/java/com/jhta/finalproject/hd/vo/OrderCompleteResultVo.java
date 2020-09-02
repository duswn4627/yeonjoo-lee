package com.jhta.finalproject.hd.vo;

public class OrderCompleteResultVo {
	private String name;  
	private int ordernum; //주문번호
	private String receiver;  //수령인
	private String ordername; //주문자이름 
	private int paymentmoney; //데이터베이스 지불한 금액 ( 배송비 , 사용한포인트 제외 )
	private int usedpoint; //데이베이스 사용한 포인트
	private int delfee; //데이터베이스 배송비
	private String addr;
	private String jibunaddr;
	private String roadaddr;

	public OrderCompleteResultVo() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public int getPaymentmoney() {
		return paymentmoney;
	}

	public void setPaymentmoney(int paymentmoney) {
		this.paymentmoney = paymentmoney;
	}

	public int getUsedpoint() {
		return usedpoint;
	}

	public void setUsedpoint(int usedpoint) {
		this.usedpoint = usedpoint;
	}

	public int getDelfee() {
		return delfee;
	}

	public void setDelfee(int delfee) {
		this.delfee = delfee;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getJibunaddr() {
		return jibunaddr;
	}
	public void setJibunaddr(String jibunaddr) {
		this.jibunaddr = jibunaddr;
	}
	public String getRoadaddr() {
		return roadaddr;
	}
	public void setRoadaddr(String roadaddr) {
		this.roadaddr = roadaddr;
	}
}
