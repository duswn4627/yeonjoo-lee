package com.jhta.finalproject.jm.vo;

import java.util.Date;

public class BooksVo {
	private int bnum;
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
	public BooksVo(int bnum, String btitle, String bwriter, Date bpublishdate, String bpublisher, int bprice,
			int bpoint, int bshipinfo, int bcount, String bcontent, int bhit, int scatenum, Date bregdate) {
		super();
		this.bnum = bnum;
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
	}
	public BooksVo() {
		super();
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	
	
	
	
}
