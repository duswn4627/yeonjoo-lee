package com.jhta.finalproject.yj.service;

import org.springframework.stereotype.Service;

import com.jhta.finalproject.yj.vo.QnaAnswerVO;
import com.jhta.finalproject.yj.vo.QnaVO;

@Service
public interface QnaAnswerTranService {
	int qnastatusInsertUpdate(QnaAnswerVO avo, QnaVO qvo) throws Exception;

	int qnastatusDeleteUpdate(int qnanum, QnaVO qvo) throws Exception;
}
