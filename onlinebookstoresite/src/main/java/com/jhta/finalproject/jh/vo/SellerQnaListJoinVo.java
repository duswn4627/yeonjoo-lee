package com.jhta.finalproject.jh.vo;

import java.util.Date;

public class SellerQnaListJoinVo {
	private String obname;
	private String obqtitle;
	private String obqcontent;
	private String mid;
	private int obqstatus;
	private Date obqdate;
	private int obnum;
	private int obqnum;
	private int mnum;
	
	public SellerQnaListJoinVo() {}

	public SellerQnaListJoinVo(String obname, String obqtitle, String obqcontent, String mid, int obqstatus,
			Date obqdate, int obnum, int obqnum, int mnum) {
		super();
		this.obname = obname;
		this.obqtitle = obqtitle;
		this.obqcontent = obqcontent;
		this.mid = mid;
		this.obqstatus = obqstatus;
		this.obqdate = obqdate;
		this.obnum = obnum;
		this.obqnum = obqnum;
		this.mnum = mnum;
	}

	public String getObname() {
		return obname;
	}

	public void setObname(String obname) {
		this.obname = obname;
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

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public int getObqnum() {
		return obqnum;
	}

	public void setObqnum(int obqnum) {
		this.obqnum = obqnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	
	
}
