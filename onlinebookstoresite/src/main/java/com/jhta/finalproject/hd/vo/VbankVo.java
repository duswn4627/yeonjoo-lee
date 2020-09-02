package com.jhta.finalproject.hd.vo;

public class VbankVo {
	private int bpaynum;
	private String vbank_name;
	private long vbank_num;
	private String vbank_holder;
	public VbankVo() {}
	public VbankVo(int bpaynum, String vbank_name, long vbank_num, String vbank_holder) {
		super();
		this.bpaynum = bpaynum;
		this.vbank_name = vbank_name;
		this.vbank_num = vbank_num;
		this.vbank_holder = vbank_holder;
	}
	public int getBpaynum() {
		return bpaynum;
	}
	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
	}
	public String getVbank_name() {
		return vbank_name;
	}
	public void setVbank_name(String vbank_name) {
		this.vbank_name = vbank_name;
	}
	public long getVbank_num() {
		return vbank_num;
	}
	public void setVbank_num(long vbank_num) {
		this.vbank_num = vbank_num;
	}
	public String getVbank_holder() {
		return vbank_holder;
	}
	public void setVbank_holder(String vbank_holder) {
		this.vbank_holder = vbank_holder;
	}
	
	
	
}
