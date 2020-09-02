package com.jhta.finalproject.jm.vo;

public class BigcateVo {
	private int bcatenum;
	private String bcataname;
	
	public BigcateVo() {}

	public BigcateVo(int bcatenum, String bcataname) {
		super();
		this.bcatenum = bcatenum;
		this.bcataname = bcataname;
	}

	public int getBcatenum() {
		return bcatenum;
	}

	public void setBcatenum(int bcatenum) {
		this.bcatenum = bcatenum;
	}

	public String getBcataname() {
		return bcataname;
	}

	public void setBcataname(String bcataname) {
		this.bcataname = bcataname;
	}
}
