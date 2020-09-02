package com.jhta.finalproject.hd.vo;

public class AccountVo {
	private int anum;
	private int mnum;
	private String bank;
	private int account;
	
	public AccountVo() {}
	public AccountVo(int anum, int mnum, String bank, int account) {
		super();
		this.anum = anum;
		this.mnum = mnum;
		this.bank = bank;
		this.account = account;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	
	
}
