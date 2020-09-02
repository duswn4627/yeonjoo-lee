package com.jhta.finalproject.jh.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jh.dao.SellerMainBoardDao;

@Service
public class SellerMainBoardService {
	@Autowired
	private SellerMainBoardDao dao;
	
	//중고판매자 인증완료되면 판매자번호 부여
	public int sellerInsert(int mnum) {
		return dao.sellerInsert(mnum);
	}
	//인증완료된 중고판매자 회원번호 가져오기getSnum
	public int getSnum(int mnum) {
		return dao.getSnum(mnum);
	}
	
	//상황판 판매현황
	//상황판(최근 한달간 등록한 상품)
	public int getOldbookCount(int snum) {
		return dao.getOldbookCount(snum);
	}
	//상황판 최근 한달간 판매현황(0:주문/입금대기중,	1:결제완료,2:배송중,3:수령완료(구매확정),4:환불) 
	public int getOldbookSalestatusCount(HashMap<String, Object> map) {
		return dao.getOldbookSalestatusCount(map);
	}
	//상황판 최근 한달간 정산현황(0:정산전,1:정산완료) 
	public int getObcompleteCount(HashMap<String, Object> map) {
		return dao.getObcompleteCount(map);
	}
	//최근 한달 Qna 미답변
	public int getMainQnaCount(int snum) {
		return dao.getMainQnaCount(snum);
	}
	//최근한달 리뷰갯수
	public int getSellerReviewCount(int snum) {
		return dao.getSellerReviewCount(snum);
	}
}
