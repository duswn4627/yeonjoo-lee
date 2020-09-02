package com.jhta.finalproject.hd.vo;

public class refundBookVo {
	private int bnum;
	private int bcount;
	public refundBookVo() {}
	public refundBookVo(int bnum, int bcount) {
		super();
		this.bnum = bnum;
		this.bcount = bcount;
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
