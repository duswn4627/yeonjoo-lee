package com.jhta.finalproject.hd.vo;

//장바구니 리스트 VO

public class CartListVo {
	private int mnum;  //회원번호
	private int bnum;  //책번호
	private String btitle; //책제목
	private int bprice; //책가격
	private int bpoint; //적립포인트
	private int bshipinfo; //배송료
	private int stored; //재고
	private int bcount;  //카트에 넣은 수량
	private int cartnum; //카트번호 -> 주문할때 카트번호 0이 아니면 장바구니에서 삭제해야함.
	private String imgsavefilename; // 주문할때 / 장바구니에서 섬네일사진 가져옴..
	
	public CartListVo() {}
	

	public CartListVo(int mnum, int bnum, String btitle, int bprice, int bpoint, int bshipinfo, int stored, int bcount,
			int cartnum, String imgsavefilename) {
		super();
		this.mnum = mnum;
		this.bnum = bnum;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bpoint = bpoint;
		this.bshipinfo = bshipinfo;
		this.stored = stored;
		this.bcount = bcount;
		this.cartnum = cartnum;
		this.imgsavefilename = imgsavefilename;
	}


	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
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

	public int getStored() {
		return stored;
	}

	public void setStored(int stored) {
		this.stored = stored;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public int getCartnum() {
		return cartnum;
	}

	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}

	public String getImgsavefilename() {
		return imgsavefilename;
	}

	public void setImgsavefilename(String imgsavefilename) {
		this.imgsavefilename = imgsavefilename;
	}
	
}