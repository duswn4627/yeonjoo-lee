package com.jhta.finalproject.jm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jm.dao.BookdetailDao;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.BreviewVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ReviewinsertVo;

@Service
public class BookdetailService {
	@Autowired
	private BookdetailDao dao;
	
	public List<AllListVo> bookdetail(int bnum){
		return dao.bookdetail(bnum);
	}
	public int addHit(int bnum) {
		return dao.addHit(bnum);
	}
	public List<BreviewVo> reviewlist(HashMap<String, Object> map){
		return dao.reviewlist(map);
	}
	public int breviewcount(int bnum) {
		return dao.breviewcount(bnum);
	}
	public ImgVo imginfo(int bnum) {
		return dao.imginfo(bnum);
	}
	
	public int breviewinsert(ReviewinsertVo vo) {
		return dao.breviewinsert(vo);
	}
}
