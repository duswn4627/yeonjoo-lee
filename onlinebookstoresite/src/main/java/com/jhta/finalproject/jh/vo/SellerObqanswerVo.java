package com.jhta.finalproject.jh.vo;

import java.util.Date;

public class SellerObqanswerVo {
	private int obqnum;
	private int snum;
	private String obqacontent;
	private Date obqregdate;
	
	public SellerObqanswerVo() {}
	
	public SellerObqanswerVo(int obqnum, int snum, String obqacontent, Date obqregdate) {
		super();
		this.obqnum = obqnum;
		this.snum = snum;
		this.obqacontent = obqacontent;
		this.obqregdate = obqregdate;
	}
	public int getObqnum() {
		return obqnum;
	}
	public void setObqnum(int obqnum) {
		this.obqnum = obqnum;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getObqacontent() {
		return obqacontent;
	}
	public void setObqacontent(String obqacontent) {
		this.obqacontent = obqacontent;
	}
	public Date getObqregdate() {
		return obqregdate;
	}
	public void setObqregdate(Date obqregdate) {
		this.obqregdate = obqregdate;
	}
	
}
