package com.jhta.finalproject.yj.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yj.vo.QnaVO;

@Repository
public class QnaDao {
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE = "com.jhta.yj.mybatis.mapper.QnaMapper";

	// 미답변
	public int unAnswerCount() {
		return session.selectOne(NAMESPACE + ".unAnswerCount");
	}

	public List<QnaVO> unAnswerList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".unAnswerList", map);
	}

	public QnaVO unAnswerInfo(int qnanum) {
		return session.selectOne(NAMESPACE + ".unAnswerInfo", qnanum);
	}

	// 답변완료
	public int answerCount() {
		return session.selectOne(NAMESPACE + ".answerCount");
	}

	public List<QnaVO> answerList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".answerList", map);
	}

	// 답변완료됐을 때 상태 수정
	public int qnastatusInsertUpdate(QnaVO vo) {
		return session.update(NAMESPACE + ".qnastatusInsertUpdate", vo);
	}

	// 답변 삭제됐을 때 상태 수정
	public int qnastatusDeleteUpdate(QnaVO vo) {
		return session.update(NAMESPACE + ".qnastatusDeleteUpdate", vo);
	}
}
