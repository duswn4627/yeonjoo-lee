package com.jhta.finalproject.jm.vo;

import java.sql.Clob;
import java.util.Date;

public class AllListVo {

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
	private int reviewnum;
	private int mnum;
	private int bnum3;
	private Clob reviewcontent;
	private int bscore;
	private Date breviewregdate;
	
	public AllListVo() {}

	public AllListVo(String imgorgfilename, int imgnum, String imgsavefilename, int thumbnail, int btype, int bnum,
			int bnum2, String btitle, String bwriter, Date bpublishdate, String bpublisher, int bprice, int bpoint,
			int bshipinfo, int bcount, String bcontent, int bhit, int scatenum, Date bregdate, int reviewnum, int mnum,
			int bnum3, Clob reviewcontent, int bscore, Date breviewregdate) {
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
		this.reviewnum = reviewnum;
		this.mnum = mnum;
		this.bnum3 = bnum3;
		this.reviewcontent = reviewcontent;
		this.bscore = bscore;
		this.breviewregdate = breviewregdate;
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

	public int getBnum3() {
		return bnum3;
	}

	public void setBnum3(int bnum3) {
		this.bnum3 = bnum3;
	}

	public Clob getReviewcontent() {
		return reviewcontent;
	}

	public void setReviewcontent(Clob reviewcontent) {
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
