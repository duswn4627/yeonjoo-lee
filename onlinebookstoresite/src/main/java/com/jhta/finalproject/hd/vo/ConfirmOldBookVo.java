package com.jhta.finalproject.hd.vo;

//중고책 구매확정시 사용 VO
public class ConfirmOldBookVo {
	private int bnum;
	private int paymentbook_num;
	private int obsaleprice;
	
	public ConfirmOldBookVo() {}
	public ConfirmOldBookVo(int bnum, int paymentbook_num, int obsaleprice) {
		super();
		this.bnum = bnum;
		this.paymentbook_num = paymentbook_num;
		this.obsaleprice = obsaleprice;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getPaymentbook_num() {
		return paymentbook_num;
	}
	public void setPaymentbook_num(int paymentbook_num) {
		this.paymentbook_num = paymentbook_num;
	}
	public int getObsaleprice() {
		return obsaleprice;
	}
	public void setObsaleprice(int obsaleprice) {
		this.obsaleprice = obsaleprice;
	} 	
}
