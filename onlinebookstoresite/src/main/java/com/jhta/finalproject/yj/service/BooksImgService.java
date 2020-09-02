package com.jhta.finalproject.yj.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.yj.dao.BooksDao2;
import com.jhta.finalproject.yj.dao.ImgDao;
import com.jhta.finalproject.yj.vo.BigCategoryVO;
import com.jhta.finalproject.yj.vo.BooksVO;
import com.jhta.finalproject.yj.vo.ImgVO;
import com.jhta.finalproject.yj.vo.SmallCategoryVO;

@Service
public class BooksImgService {
	@Autowired
	private BooksDao2 bdao;
	@Autowired
	private ImgDao idao;

	public List<BigCategoryVO> getBigctg() {
		return bdao.getBigctg();
	}

	public List<SmallCategoryVO> getSmallctg(int bcatenum) {
		return bdao.getSmallctg(bcatenum);
	}

	public int count(HashMap<String, Object> map) {
		return bdao.count(map);
	}

	public List<BooksVO> list(HashMap<String, Object> map) {
		return bdao.list(map);
	}

	public BooksVO getBooksInfo(int bnum) {
		return bdao.getBooksInfo(bnum);
	}

	public List<ImgVO> getImgInfo(int bnum) {
		return idao.getImgInfo(bnum);
	}

	public int updateBigCtg(int bnum) {
		return bdao.updateBigCtg(bnum);
	}

	public int booksUpdate(BooksVO vo) {
		return bdao.booksUpdate(vo);
	}

	public int imgUpdateDelete(int imgnum) {
		return idao.imgUpdateDelete(imgnum);
	}

	public List<BooksVO> excelList() {
		return bdao.excelList();
	}
}
