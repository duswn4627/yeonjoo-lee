package com.jhta.finalproject.jh.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jh.dao.SellerBoardDao;
import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerObqanswerVo;
import com.jhta.finalproject.jh.vo.SellerQnaListJoinVo;
import com.jhta.finalproject.jh.vo.SellerReviewJoinVo;

@Service
public class SellerBoardService implements SellerBoard{
	@Autowired
	private SellerBoardDao dao;
	
	//중고판매자 Qna리스트 가져오기
	public List<SellerQnaListJoinVo> getSellerQnaList(HashMap<String, Object> map){
		List<SellerQnaListJoinVo> list=dao.getSellerQnaList(map);
		return list;
	}
	//중고판매자 Qna리스트 글갯수 가져오기
	public int getSellerQnaCount(HashMap<String, Object> map) {
		return dao.getSellerQnaCount(map);
	}
	//중고판매자 문의사항 리스트 가져오기(디테일)
	public SellerQnaListJoinVo getSellerQnaDetail(int obqnum){
		SellerQnaListJoinVo vo=dao.getSellerQnaDetail(obqnum);
		return vo;
	}
	//중고판매자 썸네일이미지 가져오기(디테일)
	public SellerImgVo getQnaDetailImg(int bnum) {
		SellerImgVo vo=dao.getQnaDetailImg(bnum);
		return vo;
	}
	//중고판매자 답변 리스트 가져오기(디테일)
	public SellerObqanswerVo getSellerAnswerList(int obqnum){
		SellerObqanswerVo vo=dao.getSellerAnswerList(obqnum);
		return vo;
	}
	//중고판매자 답변하기
	@Override
	public int sellerQnaInsert(HashMap<String, Object> map) {
		dao.updateQnastatus(map);
		dao.insertObqanswer(map);
		return 1;
	}
	//중고판매자 답글 수정하기
	public int updateObqanswer(HashMap<String, Object> map) {
		return dao.updateObqanswer(map);
	}
	//중고판매 리뷰 리스트
	public List<SellerReviewJoinVo> getObreviewList(HashMap<String, Object> map){
		List<SellerReviewJoinVo> list=dao.getObreviewList(map);
		return list;
	}
	//중고판매 평점 
	public double getReviewAvg(int snum) {
		return dao.getReviewAvg(snum);
	}
	//총 글의 갯수 구하기
	public int getObreviewCount(HashMap<String, Object> map) {
		return dao.getObreviewCount(map);
	}
		
}
