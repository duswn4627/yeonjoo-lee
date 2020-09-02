package com.jhta.finalproject.yj.vo;

import java.util.Date;

public class QnaAnswerVO {
	private String maid;
	private int qnanum;
	private String acontent; // 답변내용(qnacontent)
	private Date adate; // 답변일자(qnaregdate)

	// 조인 시 사용될
	private int mnum;
	private String mid; // 회원 아이디
	private String qnatitle; // 질문제목
	private String qcontent; // 질문내용(qnacontent)
	private int qnastatus; // 0: 미답변, 1: 답변
	private Date qdate; // 질문작성일자(qnadate)

	public QnaAnswerVO() {
	}

	public QnaAnswerVO(String maid, int qnanum, String acontent, Date adate) {
		super();
		this.maid = maid;
		this.qnanum = qnanum;
		this.acontent = acontent;
		this.adate = adate;
	}

	public QnaAnswerVO(String maid, int qnanum, String acontent, Date adate, int mnum, String mid, String qnatitle,
			String qcontent, int qnastatus, Date qdate) {
		super();
		this.maid = maid;
		this.qnanum = qnanum;
		this.acontent = acontent;
		this.adate = adate;
		this.mnum = mnum;
		this.mid = mid;
		this.qnatitle = qnatitle;
		this.qcontent = qcontent;
		this.qnastatus = qnastatus;
		this.qdate = qdate;
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

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getQnatitle() {
		return qnatitle;
	}

	public void setQnatitle(String qnatitle) {
		this.qnatitle = qnatitle;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public int getQnastatus() {
		return qnastatus;
	}

	public void setQnastatus(int qnastatus) {
		this.qnastatus = qnastatus;
	}

	public Date getQdate() {
		return qdate;
	}

	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}
}