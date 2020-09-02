package com.jhta.finalproject.jh.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerOldbooksVo;

@Repository
public class SellerProdLookDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.SellerProdLookMapper.jh";
	
	//전체 등록한 상품 조회
	public List<SellerOldbooksVo> allList(HashMap<String, Object> map){
		List<SellerOldbooksVo> list=sqlSession.selectList(NAMESPACE+".prodAllSelect", map);
		return list;
	}
	
	//상품 수정을 위한 조회
	public List<SellerOldbooksVo> prodUpdateSelect(int obnum){
		List<SellerOldbooksVo> list=sqlSession.selectList(NAMESPACE+".prodUpdateSelect", obnum);
		return list;
	}
	
	//상품수정을 위한 큰 카테고리 넘버 가져오기
	public int getBiccatenum(int obnum){
		return sqlSession.selectOne(NAMESPACE+".updateGetBigcatenum", obnum);
	}
	
	//상품수정을 위한 이미지 리스트 가져오기
	public List<SellerImgVo> getProdImgList(int obnum){
		List<SellerImgVo> list=sqlSession.selectList(NAMESPACE+".getProdImg", obnum);
		return list;
	}
	
	//상품수정 메소드
	public int updateOldBooks(SellerOldbooksVo vo) {
		return sqlSession.update(NAMESPACE+".updateProdinfo", vo);
	}
	
	//이미지삭제 메소드
	public int delimg(int imgnum) {
		return sqlSession.delete(NAMESPACE+".deleteImg", imgnum);
	}
	
	//삭제할 이미지 정보 가져오기
	public SellerImgVo getdelImginfo(int imgnum) {
		SellerImgVo vo=sqlSession.selectOne(NAMESPACE+".getImginfo", imgnum);
		return vo;
	}
	
	//중고책 수정이미지 등록
	public int updateImg(SellerImgVo vo) {
		return sqlSession.insert(NAMESPACE+".updateImg", vo);
	}
	//---------------------중고책 삭제관련------------------
	//중고책 상품 삭제하기
	public int oldbookDel(int obnum) {
		return sqlSession.delete(NAMESPACE+".oldbookDel", obnum);
	}
	//중고책 상품 이미지 삭제
	public int oldbookImgDel(int obnum) {
		return sqlSession.delete(NAMESPACE+".oldbookImgDel", obnum);
	}
	//삭제할 중고책 이미지 가져오기
	public List<SellerImgVo> delImglist(int obnum){
		List<SellerImgVo> list=sqlSession.selectList(NAMESPACE+".delImgInfo", obnum);
		return list;
	}
	//중고상품 문의글 삭제
	public int obqanswerdel(int obnum) {
		return sqlSession.delete(NAMESPACE+".obqanswerdel", obnum);
	}
	//중고상품 문의글 답변 삭제
	public int obqnadel(int obnum) {
		return sqlSession.delete(NAMESPACE+".obqnadel", obnum);
	}
	
	//-----------------------------페이징----------------------------------
	//글갯수 구하기
	public int oldbookPageCount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".oldbookPageCount", map);
	}
		
}
