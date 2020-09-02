package com.jhta.finalproject.hd.vo;

import java.sql.Date;

public class QnaAnswerVo {
	private String maid;
	private int qnanum;
	private String qnacontent;
	private Date qnaregdate;
	
	public QnaAnswerVo() {}

	public QnaAnswerVo(String maid, int qnanum, String qnacontent, Date qnaregdate) {
		super();
		this.maid = maid;
		this.qnanum = qnanum;
		this.qnacontent = qnacontent;
		this.qnaregdate = qnaregdate;
	}

	public String getMaid() {
		return maid;
	}

	public void setMaid(String maid) {
		this.maid = maid;
	}

	public int getQnanum() {
		return qnanum;
	}

	public void setQnanum(int qnanum) {
		this.qnanum = qnanum;
	}

	public String getQnacontent() {
		return qnacontent;
	}

	public void setQnacontent(String qnacontent) {
		this.qnacontent = qnacontent;
	}

	public Date getQnaregdate() {
		return qnaregdate;
	}

	public void setQnaregdate(Date qnaregdate) {
		this.qnaregdate = qnaregdate;
	}
	
	
}
