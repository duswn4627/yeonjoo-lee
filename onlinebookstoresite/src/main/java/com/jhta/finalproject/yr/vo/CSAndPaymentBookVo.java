package com.jhta.finalproject.yr.vo;

import java.util.Date;

//PAYMENTBOOK_NUM NOT NULL NUMBER 
//STATUS                   NUMBER 
//APLCTDATE                DATE   
//RECOMDATE                DATE   
//TYPE                     NUMBER 
//COUNT                    NUMBER 


//refund, books, paymentbook
public class CSAndPaymentBookVo {

	private int bpaynum;
	private int btype;
	private int bnum;
	private int bcount;
	private String btitle; // 책이름
	private int bprice; // 책 가격
	private int point; // 포인트
	private int paymentbook_num; // cs책번호
	private int status; // 상태
	private Date aplctdate; // 신청날짜
	private Date recomdate; // 처리날짜
	private int type; // 취소 ,반품, 환불
	private int count; // cs책 갯수

	public CSAndPaymentBookVo() {
		super();
	}



	public CSAndPaymentBookVo(int bpaynum, int btype, int bnum, int bcount, String btitle, int bprice, int point,
			int paymentbook_num, int status, Date aplctdate, Date recomdate, int type, int count) {
		super();
		this.bpaynum = bpaynum;
		this.btype = btype;
		this.bnum = bnum;
		this.bcount = bcount;
		this.btitle = btitle;
		this.bprice = bprice;
		this.point = point;
		this.paymentbook_num = paymentbook_num;
		this.status = status;
		this.aplctdate = aplctdate;
		this.recomdate = recomdate;
		this.type = type;
		this.count = count;
	}

	@Override
	public String toString() {
		return "CSAndPaymentBookVo [bpaynum=" + bpaynum + ", btype=" + btype + ", bnum=" + bnum + ", bcount=" + bcount
				+ ", btitle=" + btitle + ", bprice=" + bprice + ", point=" + point + ", paymentbook_num="
				+ paymentbook_num + ", status=" + status + ", aplctdate=" + aplctdate + ", recomdate=" + recomdate
				+ ", type=" + type + ", count=" + count + "]";
	}


	
	
	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}



	public int getBpaynum() {
		return bpaynum;
	}

	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
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

	public int getPaymentbook_num() {
		return paymentbook_num;
	}

	public void setPaymentbook_num(int paymentbook_num) {
		this.paymentbook_num = paymentbook_num;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getAplctdate() {
		return aplctdate;
	}

	public void setAplctdate(Date aplctdate) {
		this.aplctdate = aplctdate;
	}

	public Date getRecomdate() {
		return recomdate;
	}

	public void setRecomdate(Date recomdate) {
		this.recomdate = recomdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
