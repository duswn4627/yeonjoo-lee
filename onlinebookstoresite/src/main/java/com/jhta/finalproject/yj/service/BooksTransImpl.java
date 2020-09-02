package com.jhta.finalproject.yj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.yj.dao.BooksDao2;
import com.jhta.finalproject.yj.dao.ImgDao;
import com.jhta.finalproject.yj.vo.BooksVO;
import com.jhta.finalproject.yj.vo.ImgVO;

@Service
public class BooksTransImpl implements BooksTransService {
	@Autowired
	private BooksDao2 bdao;
	@Autowired
	private ImgDao idao;

	public void setBdao(BooksDao2 bdao) {
		this.bdao = bdao;
	}

	public void setIdao(ImgDao idao) {
		this.idao = idao;
	}

	// 등록
	@Transactional
	@Override
	public int insert(BooksVO bvo, ImgVO ivo) {
		bdao.booksInsert(bvo);
		idao.imgInsert(ivo);
		return 1;
	}

	@Transactional
	@Override
	public int insertList(BooksVO bvo, List<ImgVO> list) {
		bdao.booksInsert(bvo);
		// idao.imgInsert(ivo);
		for (ImgVO ivo : list) {
			idao.imgInsert(ivo);
		}
		return 1;
	}

	// 수정
	@Transactional
	@Override
	public int update(ImgVO ivo1, ImgVO ivo2) {
		// bdao.booksUpdate(bvo);
		if (ivo2 == null) {
			idao.imgUpdate(ivo1);
		} else {
			idao.imgUpdate(ivo1);
			idao.imgUpdate(ivo2);
		}
		return 1;
	}

	// 삭제
	@Transactional
	@Override
	public int delete(int bnum) {
		int n1 = bdao.bookReviewDelect(bnum);
		if (n1 <= 0) {
			idao.imgDelete(bnum);
			bdao.booksDelete(bnum);
		} else {
			bdao.bookReviewDelect(bnum);
			idao.imgDelete(bnum);
			bdao.booksDelete(bnum);
		}
		return 1;
	}
}
