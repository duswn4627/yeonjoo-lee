package com.jhta.finalproject.hd.vo;

public class UsedOrderListVo {
	private int cartnum; //장바구니 번호
	private int btype; // 책타입
	private int bnum; //책번호
	private int bcount; //수량 
	private String obname; //책제목
	private int obstatus; //책품질
	private int oborgprice; //원래가격(정가)
	private int obsaleprice; // 판매가
	private int totalvalue;// 판매가 * 수량
	private String sid; //판매자 아이디
	private int smnum; //판매자 회원번호
	private int obdelfee; //중고 배송료.
	private String imgsavefilename; //섬네일 이미지파일이름.
	private String imgpath; //이미지 경로 set
	private String statusString;//리스트에서의 보여질 이름. set ( [중고-'품질'] + bname )
	
	public UsedOrderListVo() {}

	public UsedOrderListVo(int cartnum, int btype, int bnum, int bcount, String obname, int obstatus, int oborgprice,
			int obsaleprice, int totalvalue, String sid, int smnum, int obdelfee, String imgsavefilename,
			String imgpath, String statusString) {
		super();
		this.cartnum = cartnum;
		this.btype = btype;
		this.bnum = bnum;
		this.bcount = bcount;
		this.obname = obname;
		this.obstatus = obstatus;
		this.oborgprice = oborgprice;
		this.obsaleprice = obsaleprice;
		this.totalvalue = totalvalue;
		this.sid = sid;
		this.smnum = smnum;
		this.obdelfee = obdelfee;
		this.imgsavefilename = imgsavefilename;
		this.imgpath = imgpath;
		this.statusString = statusString;
	}

	public int getCartnum() {
		return cartnum;
	}

	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
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

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getObname() {
		return obname;
	}

	public void setObname(String obname) {
		this.obname = obname;
	}

	public int getObstatus() {
		return obstatus;
	}

	public void setObstatus(int obstatus) {
		this.obstatus = obstatus;
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

	public int getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getSmnum() {
		return smnum;
	}

	public void setSmnum(int smnum) {
		this.smnum = smnum;
	}

	public int getObdelfee() {
		return obdelfee;
	}

	public void setObdelfee(int obdelfee) {
		this.obdelfee = obdelfee;
	}

	public String getImgsavefilename() {
		return imgsavefilename;
	}

	public void setImgsavefilename(String imgsavefilename) {
		this.imgsavefilename = imgsavefilename;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	
	


}
