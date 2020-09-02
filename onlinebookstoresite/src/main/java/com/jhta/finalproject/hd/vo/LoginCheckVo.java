package com.jhta.finalproject.hd.vo;

// 로그인시 사용함. 
public class LoginCheckVo {
	private String mnum;
	private String mid;
	private int mstatus;
	private int snum; //중고판매자번호. NVL사용으로 판매자번호가 없으면 0번들어감.
	public LoginCheckVo() {}
	public LoginCheckVo(String mnum, String mid, int mstatus, int snum) {
		super();
		this.mnum = mnum;
		this.mid = mid;
		this.mstatus = mstatus;
		this.snum = snum;
	}
	public String getMnum() {
		return mnum;
	}
	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getMstatus() {
		return mstatus;
	}
	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	
	
}
