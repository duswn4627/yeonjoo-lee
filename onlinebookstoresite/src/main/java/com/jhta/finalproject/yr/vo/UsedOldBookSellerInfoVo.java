package com.jhta.finalproject.yr.vo;

import java.sql.Date;
import java.util.List;

/**
 * @author JHTA
 *
 */
public class UsedOldBookSellerInfoVo {
	private Date borderdate; //주문일자
	private Date bpaydate; //결제일자
	private int paymentbook_num; //주문번호
	private int bpaynum; //주문번호
	private int fprice; //판매금액
	private int settlement; // 정산금액
	private int bocomstatus; //처리상태
	private int seller; //판매자 번호
	private int buyer; // 구매자 번호
	private String sellername; //판매자 이름
	private String buyername; // 구매자 이름

	
	private List<String> obname; //책이름

	public UsedOldBookSellerInfoVo() {
		// TODO Auto-generated constructor stub
	}


	public UsedOldBookSellerInfoVo(Date borderdate, Date bpaydate, int paymentbook_num, int bpaynum, int fprice,
			int settlement, int bocomstatus, int seller, int buyer, String sellername, String buyername,
			List<String> obname) {
		super();
		this.borderdate = borderdate;
		this.bpaydate = bpaydate;
		this.paymentbook_num = paymentbook_num;
		this.bpaynum = bpaynum;
		this.fprice = fprice;
		this.settlement = settlement;
		this.bocomstatus = bocomstatus;
		this.seller = seller;
		this.buyer = buyer;
		this.sellername = sellername;
		this.buyername = buyername;
		this.obname = obname;
	}


	public Date getBorderdate() {
		return borderdate;
	}


	public void setBorderdate(Date borderdate) {
		this.borderdate = borderdate;
	}


	public Date getBpaydate() {
		return bpaydate;
	}


	public void setBpaydate(Date bpaydate) {
		this.bpaydate = bpaydate;
	}


	public int getBpaynum() {
		return bpaynum;
	}


	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
	}


	public int getFprice() {
		return fprice;
	}


	public void setFprice(int fprice) {
		this.fprice = fprice;
	}


	public int getSettlement() {
		return settlement;
	}


	public void setSettlement(int settlement) {
		this.settlement = settlement;
	}


	public int getBocomstatus() {
		return bocomstatus;
	}


	public void setBocomstatus(int bocomstatus) {
		this.bocomstatus = bocomstatus;
	}


	public int getSeller() {
		return seller;
	}


	public void setSeller(int seller) {
		this.seller = seller;
	}


	public int getBuyer() {
		return buyer;
	}


	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}


	public String getSellername() {
		return sellername;
	}


	public void setSellername(String sellername) {
		this.sellername = sellername;
	}


	public String getBuyername() {
		return buyername;
	}


	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}


	public List<String> getObname() {
		return obname;
	}


	public void setObname(List<String> obname) {
		this.obname = obname;
	}
	
	

	public int getPaymentbook_num() {
		return paymentbook_num;
	}


	public void setPaymentbook_num(int paymentbook_num) {
		this.paymentbook_num = paymentbook_num;
	}
	
}
