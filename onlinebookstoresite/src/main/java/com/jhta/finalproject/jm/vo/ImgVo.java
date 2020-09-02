package com.jhta.finalproject.jm.vo;

public class ImgVo {
	private String imgorgfilename;
	private int imgnum;
	private String imgsavefilename;
	private int thumbnail;
	private int btype;
	private int bnum;
	
	public ImgVo() {}
	
	public ImgVo(String imgorgfilename, int imgnum, String imgsavefilename, int thumbnail, int btype, int bnum) {
		super();
		this.imgorgfilename = imgorgfilename;
		this.imgnum = imgnum;
		this.imgsavefilename = imgsavefilename;
		this.thumbnail = thumbnail;
		this.btype = btype;
		this.bnum = bnum;
	}

	public String getImgorgfilename() {
		return imgorgfilename;
	}
	public void setImgorgfilename(String imgorgfilename) {
		this.imgorgfilename = imgorgfilename;
	}
	public int getImgnum() {
		return imgnum;
	}
	public void setImgnum(int imgnum) {
		this.imgnum = imgnum;
	}
	public String getImgsavefilename() {
		return imgsavefilename;
	}
	public void setImgsavefilename(String imgsavefilename) {
		this.imgsavefilename = imgsavefilename;
	}
	public int getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(int thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getBtype() {
		return btype;
	}
	public void setBtype(int btype) {
		this.btype = btype;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	
}
