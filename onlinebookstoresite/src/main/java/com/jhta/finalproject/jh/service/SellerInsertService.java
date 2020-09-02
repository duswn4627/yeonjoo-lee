package com.jhta.finalproject.jh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.jh.dao.SellerInsertDao;
import com.jhta.finalproject.jh.vo.SellerBigcategoryVo;
import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerOldbooksVo;
import com.jhta.finalproject.jh.vo.SellerSmallcategoryVo;

@Service
public class SellerInsertService {
	@Autowired
	private SellerInsertDao dao;
	
	//대분류 카테고리 가져오기
	public List<SellerBigcategoryVo> getBigcate(){
		List<SellerBigcategoryVo> list=dao.getBigcate();
		return list;
	}
	//소분류 카테고리 가져오기
	public List<SellerSmallcategoryVo> getSmallcate(int bcatenum){
		List<SellerSmallcategoryVo> list=dao.getSmallcate(bcatenum);
		return list;
	}
	
	//중고책등록(트랜잭션처리)-썸네일이미지 1개만 있을 경우
	@Transactional
	public int insertProd(SellerOldbooksVo vo,SellerImgVo img1vo) {
		dao.insertProd(vo);
		int obnum=dao.getObnum();
		img1vo.setBnum(obnum);//등록한 중고책 번호 저장
		dao.insertObimgThum(img1vo);
		return 1;
	}
	
	//중고책등록(트랜잭션처리)-썸네일이미지+선택이미지여러개
	@Transactional
	public int insertProd(SellerOldbooksVo vo,SellerImgVo img1vo,List<SellerImgVo> list) {
		dao.insertProd(vo);
		int obnum=dao.getObnum();
		img1vo.setBnum(obnum);//등록한 중고책 번호 저장
		dao.insertObimgThum(img1vo); //썸네일 이미지저장
		//선택이미지 저장
		for(SellerImgVo imgsVo:list) {
			imgsVo.setBnum(obnum);
			dao.insertObimg(imgsVo); //선택 이미지 저장
		}
		return 1;
	}
}
