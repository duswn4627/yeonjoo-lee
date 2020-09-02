package com.jhta.finalproject.hd.vo;

public class OrderCompleteListVo {
	private int bnum;
	private String imgsavefilename;
	private String btitle;
	private int bprice;
	private int bpoint;
	private int bcount;
	private int totalvalue;
	private int totalpoint;
	private String imgpath;
	
	public OrderCompleteListVo() {}

	public OrderCompleteListVo(int bnum, String imgsavefilename, String btitle, int bprice, int bpoint, int bcount,
			int totalvalue, int totalpoint, String imgpath) {
		super();
		this.bnum = bnum;
		this.imgsavefilename = imgsavefilename;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bpoint = bpoint;
		this.bcount = bcount;
		this.totalvalue = totalvalue;
		this.totalpoint = totalpoint;
		this.imgpath = imgpath;
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

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public int getBpoint() {
		return bpoint;
	}

	public void setBpoint(int bpoint) {
		this.bpoint = bpoint;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public int getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}

	public int getTotalpoint() {
		return totalpoint;
	}

	public void setTotalpoint(int totalpoint) {
		this.totalpoint = totalpoint;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	

	
	
}
