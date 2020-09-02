package com.jhta.finalproject.yj.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.yj.dao.QnaAnswerDao;
import com.jhta.finalproject.yj.dao.QnaDao;
import com.jhta.finalproject.yj.vo.QnaAnswerVO;
import com.jhta.finalproject.yj.vo.QnaVO;

@Service
public class QnaService {
	@Autowired
	private QnaDao qdao;

	// 미답변
	public int unAnswerCount() {
		return qdao.unAnswerCount();
	}

	public List<QnaVO> unAnswerList(HashMap<String, Object> map) {
		return qdao.unAnswerList(map);
	}

	public QnaVO unAnswerInfo(int qnanum) {
		return qdao.unAnswerInfo(qnanum);
	}

	// 답변완료
	public int answerCount() {
		return qdao.answerCount();
	}

	public List<QnaVO> answerList(HashMap<String, Object> map) {
		return qdao.answerList(map);
	}

	// QnaAnswerService (QnaAnswer 테이블, 매퍼, dao)
	@Autowired
	private QnaAnswerDao adao;

	public QnaAnswerVO answerInfo(int qnanum) {
		return adao.answerInfo(qnanum);
	}
	
	public int answerUpdate(QnaAnswerVO vo) {
		return adao.answerUpdate(vo);
	}
}
