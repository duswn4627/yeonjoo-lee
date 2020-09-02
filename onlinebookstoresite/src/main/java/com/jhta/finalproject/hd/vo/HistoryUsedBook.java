package com.jhta.finalproject.hd.vo;

public class HistoryUsedBook {
	private String obname;
	private int obstatus;
	private int snum;
	private int smnum;
	private String sid;
	
	public HistoryUsedBook() {}

	public HistoryUsedBook(String obname, int obstatus, int snum, int smnum, String sid) {
		super();
		this.obname = obname;
		this.obstatus = obstatus;
		this.snum = snum;
		this.smnum = smnum;
		this.sid = sid;
	}

	public String getObname() {
		return obname;
	}

	public void setObname(String obname) {
		this.obname = obname;
	}

	public int getObstatus() {
		return obstatus;
	}

	public void setObstatus(int obstatus) {
		this.obstatus = obstatus;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public int getSmnum() {
		return smnum;
	}

	public void setSmnum(int smnum) {
		this.smnum = smnum;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
