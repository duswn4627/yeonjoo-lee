package com.jhta.finalproject.hd.vo;

//장바구니 -> 주문 넘어갈때 사용하는 VO
public class OrderListResultVo {
	private String btitle; //책제목
	private int bnum; //책번호
	private int bprice; //가격
	private int bpoint; //포인트
	private int bshipinfo;  // 배송정보?
	private String imgsavefilename; //섬네일 사진이름
 	private int cartNum;  //장바구니번호
	private int bcount;  //수량
	private String imgpath; //이미지 이름 + 저장폴더명 ( 컨트롤러에서 set )
	private int totalpoint; //수량 * 포인트  (컨트롤러에서 set)
	private int totalvalue; //수량 * 가격  (컨트롤러에서 set)
	public OrderListResultVo() {}
	public OrderListResultVo(String btitle, int bnum, int bprice, int bpoint, int bshipinfo, String imgsavefilename,
			int cartNum, int bcount, String imgpath, int totalpoint, int totalvalue) {
		super();
		this.btitle = btitle;
		this.bnum = bnum;
		this.bprice = bprice;
		this.bpoint = bpoint;
		this.bshipinfo = bshipinfo;
		this.imgsavefilename = imgsavefilename;
		this.cartNum = cartNum;
		this.bcount = bcount;
		this.imgpath = imgpath;
		this.totalpoint = totalpoint;
		this.totalvalue = totalvalue;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	public String getImgsavefilename() {
		return imgsavefilename;
	}
	public void setImgsavefilename(String imgsavefilename) {
		this.imgsavefilename = imgsavefilename;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public int getTotalpoint() {
		return totalpoint;
	}
	public void setTotalpoint(int totalpoint) {
		this.totalpoint = totalpoint;
	}
	public int getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}
	
	
}
