package com.jhta.finalproject.yj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.yj.dao.QnaAnswerDao;
import com.jhta.finalproject.yj.dao.QnaDao;
import com.jhta.finalproject.yj.vo.QnaAnswerVO;
import com.jhta.finalproject.yj.vo.QnaVO;

@Service
public class QnaAnswerTranImpl implements QnaAnswerTranService {
	@Autowired
	private QnaAnswerDao adao;
	@Autowired
	private QnaDao qdao;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int qnastatusInsertUpdate(QnaAnswerVO avo, QnaVO qvo) throws Exception {
		int n1 = adao.qnaAnswerInsert(avo);
		int n2 = qdao.qnastatusInsertUpdate(qvo);
		if (n2 <= 0) {
			throw new Exception();
		}
		return 1;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int qnastatusDeleteUpdate(int qnanum, QnaVO qvo) throws Exception {
		int n1 = adao.answerDelete(qnanum);
		int n2 = qdao.qnastatusDeleteUpdate(qvo);
		if (n2 <= 0) {
			throw new Exception();
		}
		return 1;
	}
}
