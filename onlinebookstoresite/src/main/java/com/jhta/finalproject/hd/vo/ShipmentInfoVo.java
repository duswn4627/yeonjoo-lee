package com.jhta.finalproject.hd.vo;

public class ShipmentInfoVo {
	private int mnum;
	private String mname;
	private String phone;
	private String addr;
	private String email;
	public ShipmentInfoVo() {}
	
	public ShipmentInfoVo(int mnum, String mname, String phone, String addr, String email) {
		super();
		this.mnum = mnum;
		this.mname = mname;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
