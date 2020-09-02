package com.jhta.finalproject.yj.vo;

public class PageUtil {
	private int pageNum; // 페이지번호
	private int startRow; // 시작행
	private int endRow; // 마지막행
	private int totalPageCnt; // 전체 페이지 개수
	private int startPageNum; // 시작페이지
	private int endPageNum; // 마지막페이지
	private int rowBlockCnt; // 한 페이지에 보여질 글 개수
	private int pageBlockCnt; // 한 페이지에 보여질 페이지 개수
	private int totalRowCnt; // 전체글개수

	public PageUtil() {
	}

	public PageUtil(int pageNum, int totalRowCnt, int rowBlockCnt, int pageBlockCnt) {
		this.pageNum = pageNum;
		this.totalRowCnt = totalRowCnt; // 전체글개수
		this.rowBlockCnt = rowBlockCnt; // 한 페이지에 보여질 글 개수
		this.pageBlockCnt = pageBlockCnt; // 한 페이지에 보여질 페이지 수

		// 시작행
		startRow = (pageNum - 1) * rowBlockCnt + 1;
		// 마지막행
		endRow = startRow + rowBlockCnt - 1;
		// 전체 페이지 개수
		totalPageCnt = (int) Math.ceil(totalRowCnt / (double) rowBlockCnt);
		// 시작페이지
		startPageNum = (pageNum - 1) / pageBlockCnt * pageBlockCnt + 1;
		// 마지막페이지
		endPageNum = startPageNum + pageBlockCnt - 1;

		if (totalPageCnt < endPageNum) {
			endPageNum = totalPageCnt;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotalPageCnt() {
		return totalPageCnt;
	}

	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	public int getRowBlockCnt() {
		return rowBlockCnt;
	}

	public void setRowBlockCnt(int rowBlockCnt) {
		this.rowBlockCnt = rowBlockCnt;
	}

	public int getPageBlockCnt() {
		return pageBlockCnt;
	}

	public void setPageBlockCnt(int pageBlockCnt) {
		this.pageBlockCnt = pageBlockCnt;
	}

	public int getTotalRowCnt() {
		return totalRowCnt;
	}

	public void setTotalRowCnt(int totalRowCnt) {
		this.totalRowCnt = totalRowCnt;
	}
}