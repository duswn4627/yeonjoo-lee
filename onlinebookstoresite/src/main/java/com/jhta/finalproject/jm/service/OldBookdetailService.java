package com.jhta.finalproject.jm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jh.vo.SellerQnaListJoinVo;
import com.jhta.finalproject.jm.dao.BookdetailDao;
import com.jhta.finalproject.jm.dao.OldBookdetailDao;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.BreviewVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ObQnaInsertVo;
import com.jhta.finalproject.jm.vo.OldAllListVo;
import com.jhta.finalproject.jm.vo.ReviewinsertVo;


@Service
public class OldBookdetailService {
	@Autowired
	private OldBookdetailDao dao;
	
	public List<OldAllListVo> bookdetail(int obnum){
		return dao.bookdetail(obnum);
	}
	public int addHit(int obnum) {
		return dao.addHit(obnum);
	}
	public List<BreviewVo> reviewlist(HashMap<String, Object> map){
		return dao.reviewlist(map);
	}
	public int breviewcount(int obnum) {
		return dao.breviewcount(obnum);
	}
	public ImgVo imginfo(int obnum) {
		return dao.imginfo(obnum);
	}
	
	public int obqnainsert(ObQnaInsertVo vo) {
		return dao.obqnainsert(vo);
	}
	public int obqnadelete(int obqnum) {
		return dao.obqnadelete(obqnum);
	}
	
	public List<SellerQnaListJoinVo> obqna (int obnum){
		return dao.obqna(obnum);
	}
	public int obqnacount(int snum) {
		return dao.obqnacount(snum);
	}
}
