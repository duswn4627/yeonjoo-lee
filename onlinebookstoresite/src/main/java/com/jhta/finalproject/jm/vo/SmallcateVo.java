package com.jhta.finalproject.jm.vo;

public class SmallcateVo {
	private int scatenum;
	private int bcatenum;
	private String scataname;
	
	public SmallcateVo() {}

	public SmallcateVo(int scatenum, int bcatenum, String scataname) {
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
