package com.jhta.finalproject.yj.vo;

public class SmallCategoryVO {
	private int scatenum;
	private int bcatenum;
	private String scataname;

	public SmallCategoryVO() {
	}

	public SmallCategoryVO(int scatenum, int bcatenum, String scataname) {
		super();
		this.scatenum = scatenum;
		this.bcatenum = bcatenum;
		this.scataname = scataname;
	}

	public int getScatenum() {
		return scatenum;
	}

	public void setScatenum(int scatenum) {
		this.scatenum = scatenum;
	}

	public int getBcatenum() {
		return bcatenum;
	}

	public void setBcatenum(int bcatenum) {
		this.bcatenum = bcatenum;
	}

	public String getScataname() {
		return scataname;
	}

	public void setScataname(String scataname) {
		this.scataname = scataname;
	}
}
