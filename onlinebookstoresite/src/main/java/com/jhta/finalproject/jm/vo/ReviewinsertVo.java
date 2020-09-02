package com.jhta.finalproject.jm.vo;

import java.util.Date;

public class ReviewinsertVo {
	private int reviewnum;
	private int mnum;
	private int bnum;
	private String reviewcontent;
	private int bscore;
	private Date breviewregdate;
	
	public ReviewinsertVo() {}

	public ReviewinsertVo(int reviewnum, int mnum, int bnum, String reviewcontent, int bscore, Date breviewregdate) {
		super();
		this.reviewnum = reviewnum;
		this.mnum = mnum;
		this.bnum = bnum;
		this.reviewcontent = reviewcontent;
		this.bscore = bscore;
		this.breviewregdate = breviewregdate;
	}

	public int getReviewnum() {
		return reviewnum;
	}

	public void setReviewnum(int reviewnum) {
		this.reviewnum = reviewnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getReviewcontent() {
		return reviewcontent;
	}

	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}

	public int getBscore() {
		return bscore;
	}

	public void setBscore(int bscore) {
		this.bscore = bscore;
	}

	public Date getBreviewregdate() {
		return breviewregdate;
	}

	public void setBreviewregdate(Date breviewregdate) {
		this.breviewregdate = breviewregdate;
	}
	
	
	
}
