package com.jhta.finalproject.yj.vo;

import java.util.Date;

public class BooksVO {
	private int bnum; // å��ȣ
	private String btitle; // å����
	private String bwriter; // �۰�
	private Date bpublishdate; // �Ⱓ��
	private String bpublisher; // ���ǻ�
	private int bprice; // ����
	private int bpoint; // ��������Ʈ
	private int bcount; // ����
	private String bcontent; // å����
	private int bhit; // ��ȸ��
	private int scatenum; // ����ī�װ���ȣ
	private Date bregdate; // å�����

	public BooksVO() {
	}

	public BooksVO(int bnum, String btitle, String bwriter, Date bpublishdate, String bpublisher, int bprice,
			int bpoint, int bcount, String bcontent, int bhit, int scatenum, Date bregdate) {
		super();
		this.bnum = bnum;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bpublishdate = bpublishdate;
		this.bpublisher = bpublisher;
		this.bprice = bprice;
		this.bpoint = bpoint;
		this.bcount = bcount;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.scatenum = scatenum;
		this.bregdate = bregdate;
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
