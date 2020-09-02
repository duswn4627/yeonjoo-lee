package com.jhta.finalproject.yj.vo;

public class BigCategoryVO {
	private int bcatenum;
	private String bcataname;

	public BigCategoryVO() {
	}

	public BigCategoryVO(int bcatenum, String bcataname) {
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
