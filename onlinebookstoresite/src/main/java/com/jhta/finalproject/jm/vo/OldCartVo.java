package com.jhta.finalproject.jm.vo;

public class OldCartVo {
	private int cartnum; //장바구니 번호
	private int bcount;  // 수량 
	private int obnum; //책번호 
	private String imgsavefilename; //썸네일 사진이름
	private int oborgprice; // 원래가격 
	private int obsaleprice; //판매가격 
	private int obstatus; // 품질 상태
	private int snum; //판매자번호 
	private int mnum; //회원번호
	private String obname; // 책제목
	private int obdelfee;  //배송비.
	
	public OldCartVo() {}

	public OldCartVo(int cartnum, int bcount, int obnum, String imgsavefilename, int oborgprice, int obsaleprice,
			int obstatus, int snum, int mnum, String obname, int obdelfee) {
		super();
		this.cartnum = cartnum;
		this.bcount = bcount;
		this.obnum = obnum;
		this.imgsavefilename = imgsavefilename;
		this.oborgprice = oborgprice;
		this.obsaleprice = obsaleprice;
		this.obstatus = obstatus;
		this.snum = snum;
		this.mnum = mnum;
		this.obname = obname;
		this.obdelfee = obdelfee;
	}

	public int getCartnum() {
		return cartnum;
	}

	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public int getObnum() {
		return obnum;
	}

	public void setObnum(int obnum) {
		this.obnum = obnum;
	}

	public String getImgsavefilename() {
		return imgsavefilename;
	}

	public void setImgsavefilename(String imgsavefilename) {
		this.imgsavefilename = imgsavefilename;
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

	public int getObstatus() {
		return obstatus;
	}

	public void setObstatus(int obstatus) {
		this.obstatus = obstatus;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getObname() {
		return obname;
	}

	public void setObname(String obname) {
		this.obname = obname;
	}

	public int getObdelfee() {
		return obdelfee;
	}

	public void setObdelfee(int obdelfee) {
		this.obdelfee = obdelfee;
	}

	
}
