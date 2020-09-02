package com.jhta.finalproject.jh.vo;

public class SellerBigcategoryVo {
	private int bcatenum;
	private String bcataname;
	public SellerBigcategoryVo() {}
	
	public SellerBigcategoryVo(int bcatenum, String bcataname) {
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
