package com.jhta.finalproject.jh.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerObqanswerVo;
import com.jhta.finalproject.jh.vo.SellerQnaListJoinVo;
import com.jhta.finalproject.jh.vo.SellerReviewJoinVo;

@Repository
public class SellerBoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.SellerBoardMapper.jh";
	//========================Qna관련=======================//
	
	//중고판매자 Qna리스트 가져오기
	public List<SellerQnaListJoinVo> getSellerQnaList(HashMap<String, Object> map){
		List<SellerQnaListJoinVo> list= sqlSession.selectList(NAMESPACE+".getSellerQnaList", map);
		return list;
	}
	//중고판매자 Qna리스트 글갯수 가져오기
	public int getSellerQnaCount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getSellerQnaCount", map);
	}
	
	//중고판매자 문의사항 리스트 가져오기(디테일)
	public SellerQnaListJoinVo getSellerQnaDetail(int obqnum){
		SellerQnaListJoinVo vo=sqlSession.selectOne(NAMESPACE+".getSellerQnaDetail", obqnum);
		return vo;
	}
	//중고판매자 썸네일이미지 가져오기(디테일)
	public SellerImgVo getQnaDetailImg(int bnum) {
		SellerImgVo vo=sqlSession.selectOne(NAMESPACE+".getQnaDetailImg", bnum);
		return vo;
	}
	
	//중고판매자 답변 리스트 가져오기(디테일)
	public SellerObqanswerVo getSellerAnswerList(int obqnum){
		SellerObqanswerVo vo=sqlSession.selectOne(NAMESPACE+".getSellerAnswerList", obqnum);
		return vo;
	}
	//중고판매자 Qna상태 업데이트
	public int updateQnastatus(HashMap<String, Object> map) {
		return sqlSession.update(NAMESPACE+".updateQnastatus", map);
	}
	//중고판매자 답글달기
	public int insertObqanswer(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".insertObqanswer", map);
	}
	//중고판매자 답글 수정하기
	public int updateObqanswer(HashMap<String, Object> map) {
		return sqlSession.update(NAMESPACE+".updateObqanswer", map);
	}
	
	
	//========================리뷰관련=======================//
	//중고판매 리뷰 리스트
	public List<SellerReviewJoinVo> getObreviewList(HashMap<String, Object> map){
		List<SellerReviewJoinVo> list=sqlSession.selectList(NAMESPACE+".getObreviewList", map);
		return list;
	}
	//중고판매 평점 
	public double getReviewAvg(int snum) {
		return sqlSession.selectOne(NAMESPACE+".getReviewAvg", snum);
	}
	//총 글의 갯수 구하기
	public int getObreviewCount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getObreviewCount", map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
