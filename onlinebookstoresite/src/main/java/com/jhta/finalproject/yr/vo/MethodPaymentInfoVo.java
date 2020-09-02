package com.jhta.finalproject.yr.vo;

public class MethodPaymentInfoVo {
	
	private String bpayment;
	private int price;
	private int methodpayment;
	private int count;
	
	
	
	
	@Override
	public String toString() {
		return "MethodPaymentInfoVo [bpayment=" + bpayment + ", price=" + price + ", methodpayment=" + methodpayment
				+ ", count=" + count + "]";
	}

	public MethodPaymentInfoVo() {}
	
	public MethodPaymentInfoVo(String bpayment, int price, int methodpayment, int count) {
		super();
		this.bpayment = bpayment;
		this.price = price;
		this.methodpayment = methodpayment;
		this.count = count;
	}

	public String getBpayment() {
		return bpayment;
	}

	public void setBpayment(String bpayment) {
		this.bpayment = bpayment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMethodpayment() {
		return methodpayment;
	}

	public void setMethodpayment(int methodpayment) {
		this.methodpayment = methodpayment;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
