package com.jhta.finalproject.jh.vo;

public class SellerPaymentbookVo {
	private int paymentbook_num;
	private int bpaynum;
	private int btype;
	private int bnum;
	private int bcount;
	
	public SellerPaymentbookVo() {}

	
	
	
	public SellerPaymentbookVo(int paymentbook_num, int bpaynum, int btype, int bnum, int bcount) {
		super();
		this.paymentbook_num = paymentbook_num;
		this.bpaynum = bpaynum;
		this.btype = btype;
		this.bnum = bnum;
		this.bcount = bcount;
	}

	public int getPaymentbook_num() {
		return paymentbook_num;
	}

	public void setPaymentbook_num(int paymentbook_num) {
		this.paymentbook_num = paymentbook_num;
	}

	public int getBpaynum() {
		return bpaynum;
	}

	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
}
