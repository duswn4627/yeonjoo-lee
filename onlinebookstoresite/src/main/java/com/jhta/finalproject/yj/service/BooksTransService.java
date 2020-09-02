package com.jhta.finalproject.yj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhta.finalproject.yj.vo.BooksVO;
import com.jhta.finalproject.yj.vo.ImgVO;

@Service
public interface BooksTransService {
	int insert(BooksVO bvo, ImgVO ivo);

	int insertList(BooksVO bvo, List<ImgVO> list);

	int update(ImgVO ivo1, ImgVO ivo2);

	int delete(int bnum);
}
