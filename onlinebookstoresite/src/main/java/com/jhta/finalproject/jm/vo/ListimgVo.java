package com.jhta.finalproject.jm.vo;

import java.util.Date;

public class ListimgVo {
	private String imgorgfilename;
	private int imgnum;
	private String imgsavefilename;
	private int thumbnail;
	private int btype;
	private int bnum;
	private int bnum2;
	private String btitle;
	private String bwriter;
	private Date bpublishdate;
	private String bpublisher;
	private int bprice;
	private int bpoint;
	private int bshipinfo;
	private int bcount;
	private String bcontent;
	private int bhit;
	private int scatenum;
	private Date bregdate;
	private int startRow; //시작행
	private int endRow; //끝행
	
	public ListimgVo() {

	}

	public ListimgVo(String imgorgfilename, int imgnum, String imgsavefilename, int thumbnail, int btype, int bnum,
			int bnum2, String btitle, String bwriter, Date bpublishdate, String bpublisher, int bprice, int bpoint,
			int bshipinfo, int bcount, String bcontent, int bhit, int scatenum, Date bregdate, int startRow,
			int endRow) {
		super();
		this.imgorgfilename = imgorgfilename;
		this.imgnum = imgnum;
		this.imgsavefilename = imgsavefilename;
		this.thumbnail = thumbnail;
		this.btype = btype;
		this.bnum = bnum;
		this.bnum2 = bnum2;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bpublishdate = bpublishdate;
		this.bpublisher = bpublisher;
		this.bprice = bprice;
		this.bpoint = bpoint;
		this.bshipinfo = bshipinfo;
		this.bcount = bcount;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.scatenum = scatenum;
		this.bregdate = bregdate;
		this.startRow = startRow;
		this.endRow = endRow;
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

	public int getBnum2() {
		return bnum2;
	}

	public void setBnum2(int bnum2) {
		this.bnum2 = bnum2;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public Date getBpublishdate() {
		return bpublishdate;
	}

	public void setBpublishdate(Date bpublishdate) {
		this.bpublishdate = bpublishdate;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
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

	public int getBshipinfo() {
		return bshipinfo;
	}

	public void setBshipinfo(int bshipinfo) {
		this.bshipinfo = bshipinfo;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	public int getScatenum() {
		return scatenum;
	}

	public void setScatenum(int scatenum) {
		this.scatenum = scatenum;
	}

	public Date getBregdate() {
		return bregdate;
	}

	public void setBregdate(Date bregdate) {
		this.bregdate = bregdate;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
}
