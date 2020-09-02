package com.jhta.finalproject.jm.vo;

import java.util.Date;

public class ObQnaInsertVo {
	
	private int obqnum;
	private String obqtitle;
	private String obqcontent;
	private int obqstatus;
	private Date obqdate;
	private int obnum;
	private int mnum;
	
	public ObQnaInsertVo() {}

	public ObQnaInsertVo(int obqnum, String obqtitle, String obqcontent, int obqstatus, Date obqdate, int obnum,
			int mnum) {
		super();
		this.obqnum = obqnum;
		this.obqtitle = obqtitle;
		this.obqcontent = obqcontent;
		this.obqstatus = obqstatus;
		this.obqdate = obqdate;
		this.obnum = obnum;
		this.mnum = mnum;
	}

	public int getObqnum() {
		return obqnum;
	}

	public void setObqnum(int obqnum) {
		this.obqnum = obqnum;
	}

	public String getObqtitle() {
		return obqtitle;
	}

	public void setObqtitle(String obqtitle) {
		this.obqtitle = obqtitle;
	}

	public String getObqcontent() {
		return obqcontent;
	}

	public void setObqcontent(String obqcontent) {
		this.obqcontent = obqcontent;
	}

	public int getObqstatus() {
		return obqstatus;
	}

	public void setObqstatus(int obqstatus) {
		this.obqstatus = obqstatus;
	}

	public Date getObqdate() {
		return obqdate;
	}

	public void setObqdate(Date obqdate) {
		this.obqdate = obqdate;
	}

	public int getObnum() {
		return obnum;
	}

	public void setObnum(int obnum) {
		this.obnum = obnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	
	
}
