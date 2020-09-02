package com.jhta.finalproject.jh.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jh.dao.SellerProdLookDao;
import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerOldbooksVo;

@Service
public class SellerProdLookService implements SellerProdUpdate{
	@Autowired
	private SellerProdLookDao dao;
	
	//등록한 중고책상품 전체조회
	public List<SellerOldbooksVo> allList(HashMap<String, Object> map){
		List<SellerOldbooksVo> list=dao.allList(map);
		return list;
	}
	//글갯수 구하기
	public int oldbookPageCount(HashMap<String, Object> map) {
		return dao.oldbookPageCount(map);
	}
	
	
	//--------------중고책 수정-------------------------------//
	
	//상품 수정을 위한 조회
	public List<SellerOldbooksVo> prodUpdateSelect(int obnum){
		List<SellerOldbooksVo> list=dao.prodUpdateSelect(obnum);
		return list;
	}
	
	//상품수정을 위한 큰 카테고리 넘버 가져오기
	public int getBiccatenum(int obnum){
		return dao.getBiccatenum(obnum);
	}
	
	//상품수정을 위한 이미지 리스트 가져오기
	public List<SellerImgVo> getProdImgList(int obnum){
		List<SellerImgVo> list=dao.getProdImgList(obnum);
		return list;
	}
	
	//상품 수정을 위한 메소드
	@Override
	public int oldbookUpdate(SellerOldbooksVo vo) {
		return dao.updateOldBooks(vo);
	}
	
	//상품+이미지수정을 위한 메소드
	@Override
	public int oldbookAndImgUpdate(SellerOldbooksVo vo, List<SellerImgVo> list) {
		dao.updateOldBooks(vo);
		for(int n=0;n<list.size();n++) {
			dao.updateImg(list.get(n));
		}
		return 1;
	}
	
	//이미지삭제 메소드
	public int delimg(int imgnum) {
		return dao.delimg(imgnum);
	}
	
	//삭제할 이미지 정보 가져오기
	public SellerImgVo getdelImginfo(int imgnum) {
		SellerImgVo vo=dao.getdelImginfo(imgnum);
		return vo;
	}

	//------------중고 등록상품 삭제------------------//
	
	//상품삭제하는 메소드
	@Override
	public int oldbookDel(int obnum) {
		dao.obqanswerdel(obnum); //중고책 답변 삭제
		dao.obqnadel(obnum);  //중고책 문의 삭제
		dao.oldbookDel(obnum);  //중고책 상품삭제
		dao.oldbookImgDel(obnum);  //중고책 이미지 삭제
		return 1;
	}
	
	//삭제할 중고책 이미지 가져오기
	public List<SellerImgVo> delImglist(int obnum){
		List<SellerImgVo> list=dao.delImglist(obnum);
		return list;
	}
	
}
