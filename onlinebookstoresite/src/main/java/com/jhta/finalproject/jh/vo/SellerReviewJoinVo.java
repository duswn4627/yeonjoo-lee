package com.jhta.finalproject.jh.vo;

import java.util.Date;

public class SellerReviewJoinVo {
	private int sreviewnum;
	private String obname;
	private String sreviewcontent;
	private int sscore;
	private Date sreviewregdate;
	private String mid;
	private int mnum;
	private int obnum;
	private int snum;
	
	public SellerReviewJoinVo () {}
	
	public SellerReviewJoinVo(int sreviewnum, String obname, String sreviewcontent, int sscore, Date sreviewregdate,
			String mid, int mnum, int obnum, int snum) {
		super();
		this.sreviewnum = sreviewnum;
		this.obname = obname;
		this.sreviewcontent = sreviewcontent;
		this.sscore = sscore;
		this.sreviewregdate = sreviewregdate;
		this.mid = mid;
		this.mnum = mnum;
		this.obnum = obnum;
		this.snum = snum;
	}
	public int getSreviewnum() {
		return sreviewnum;
	}
	public void setSreviewnum(int sreviewnum) {
		this.sreviewnum = sreviewnum;
	}
	public String getObname() {
		return obname;
	}
	public void setObname(String obname) {
		this.obname = obname;
	}
	public String getSreviewcontent() {
		return sreviewcontent;
	}
	public void setSreviewcontent(String sreviewcontent) {
		this.sreviewcontent = sreviewcontent;
	}
	public int getSscore() {
		return sscore;
	}
	public void setSscore(int sscore) {
		this.sscore = sscore;
	}
	public Date getSreviewregdate() {
		return sreviewregdate;
	}
	public void setSreviewregdate(Date sreviewregdate) {
		this.sreviewregdate = sreviewregdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getObnum() {
		return obnum;
	}
	public void setObnum(int obnum) {
		this.obnum = obnum;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
}
