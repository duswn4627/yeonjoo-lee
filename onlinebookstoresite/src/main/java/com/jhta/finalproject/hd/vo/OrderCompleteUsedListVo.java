package com.jhta.finalproject.hd.vo;

public class OrderCompleteUsedListVo {
	private int bnum;
	private String imgsavefilename;
	private String obname;
	private int oborgprice;
	private int obsaleprice;
	private int bcount;
	private String sid;
	private String imgpath;
	private int totalvalue;
	private int obstatus; // 책품질
	private String statusString; //책품질 
	public OrderCompleteUsedListVo() {}
	public OrderCompleteUsedListVo(int bnum, String imgsavefilename, String obname, int oborgprice, int obsaleprice,
			int bcount, String sid, String imgpath, int totalvalue, int obstatus, String statusString) {
		super();
		this.bnum = bnum;
		this.imgsavefilename = imgsavefilename;
		this.obname = obname;
		this.oborgprice = oborgprice;
		this.obsaleprice = obsaleprice;
		this.bcount = bcount;
		this.sid = sid;
		this.imgpath = imgpath;
		this.totalvalue = totalvalue;
		this.obstatus = obstatus;
		this.statusString = statusString;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getImgsavefilename() {
		return imgsavefilename;
	}
	public void setImgsavefilename(String imgsavefilename) {
		this.imgsavefilename = imgsavefilename;
	}
	public String getObname() {
		return obname;
	}
	public void setObname(String obname) {
		this.obname = obname;
	}
	public int getOborgprice() {
		return oborgprice;
	}
	public void setOborgprice(int oborgprice) {
		this.oborgprice = oborgprice;
	}
	public int getObsaleprice() {
		return obsaleprice;
	}
	public void setObsaleprice(int obsaleprice) {
		this.obsaleprice = obsaleprice;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public int getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}
	public int getObstatus() {
		return obstatus;
	}
	public void setObstatus(int obstatus) {
		this.obstatus = obstatus;
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	

}
