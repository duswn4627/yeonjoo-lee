package com.jhta.finalproject.hd.vo;

import java.sql.Date;

//문의내역 리스트 출력할때 사용 
public class QnaHistoryVo {
	private int qnanum;
	private int mnum;
	private String qnatitle;
	private String qnacontent;
	private int qnastatus;
	private Date qnadate;
	
	//마이페이지 메인 최근리스트에서만 사용 
	private String statusStr;
	
	public QnaHistoryVo() {}

	public QnaHistoryVo(int qnanum, int mnum, String qnatitle, String qnacontent, int qnastatus, Date qnadate,
			String statusStr) {
		super();
		this.qnanum = qnanum;
		this.mnum = mnum;
		this.qnatitle = qnatitle;
		this.qnacontent = qnacontent;
		this.qnastatus = qnastatus;
		this.qnadate = qnadate;
		this.statusStr = statusStr;
	}

	public int getQnanum() {
		return qnanum;
	}

	public void setQnanum(int qnanum) {
		this.qnanum = qnanum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getQnatitle() {
		return qnatitle;
	}

	public void setQnatitle(String qnatitle) {
		this.qnatitle = qnatitle;
	}

	public String getQnacontent() {
		return qnacontent;
	}

	public void setQnacontent(String qnacontent) {
		this.qnacontent = qnacontent;
	}

	public int getQnastatus() {
		return qnastatus;
	}

	public void setQnastatus(int qnastatus) {
		this.qnastatus = qnastatus;
	}

	public Date getQnadate() {
		return qnadate;
	}

	public void setQnadate(Date qnadate) {
		this.qnadate = qnadate;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
	
}
