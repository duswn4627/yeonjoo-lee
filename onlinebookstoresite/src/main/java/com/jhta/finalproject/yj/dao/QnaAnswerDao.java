package com.jhta.finalproject.yj.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yj.vo.QnaAnswerVO;

@Repository
public class QnaAnswerDao {
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE = "com.jhta.yj.mybatis.mapper.QnaAnswerMapper";

	public int qnaAnswerInsert(QnaAnswerVO vo) {
		return session.insert(NAMESPACE + ".qnaAnswerInsert", vo);
	}

	public QnaAnswerVO answerInfo(int qnanum) {
		return session.selectOne(NAMESPACE + ".answerInfo", qnanum);
	}

	public int answerUpdate(QnaAnswerVO vo) {
		return session.update(NAMESPACE + ".answerUpdate", vo);
	}

	public int answerDelete(int qnanum) {
		return session.delete(NAMESPACE + ".answerDelete", qnanum);
	}
}
