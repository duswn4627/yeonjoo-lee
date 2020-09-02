package com.jhta.finalproject.hd.vo;

public class HistoryDetailBookListVo {
	private int bpaynum;
	private int bnum;
	private int point;
	private int bcount;
	private int bprice; 
	private String btitle;
	private int pbnum;
	private int totalvalue;
	//중고일때만 사용함 ///
	private int obstatus;
	private String statusString;
	private String sid;
	// ============///
	public HistoryDetailBookListVo() {}
	public HistoryDetailBookListVo(int bpaynum, int bnum, int point, int bcount, int bprice, String btitle, int pbnum,
			int totalvalue, int obstatus, String statusString, String sid) {
		super();
		this.bpaynum = bpaynum;
		this.bnum = bnum;
		this.point = point;
		this.bcount = bcount;
		this.bprice = bprice;
		this.btitle = btitle;
		this.pbnum = pbnum;
		this.totalvalue = totalvalue;
		this.obstatus = obstatus;
		this.statusString = statusString;
		this.sid = sid;
	}
	public int getBpaynum() {
		return bpaynum;
	}
	public void setBpaynum(int bpaynum) {
		this.bpaynum = bpaynum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public int getPbnum() {
		return pbnum;
	}
	public void setPbnum(int pbnum) {
		this.pbnum = pbnum;
	}
	public int getTotalvalue() {
		return totalvalue;
	}
	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}
	public int getObstatus() {
		return obstatus;
	}
	public void setObstatus(int obstatus) {
		this.obstatus = obstatus;
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
	
	
	
}
