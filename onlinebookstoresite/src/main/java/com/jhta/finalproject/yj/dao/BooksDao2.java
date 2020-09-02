package com.jhta.finalproject.yj.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yj.vo.BigCategoryVO;
import com.jhta.finalproject.yj.vo.BooksVO;
import com.jhta.finalproject.yj.vo.SmallCategoryVO;

@Repository
public class BooksDao2 {
	@Autowired
	private SqlSessionTemplate sqlsession;
	private final String NAMESPACE = "com.jhta.yj.mybatis.mapper.BooksMapper";

	public void setSqlsession(SqlSessionTemplate sqlsession) {
		this.sqlsession = sqlsession;
	}

	public int booksInsert(BooksVO vo) {
		return sqlsession.insert(NAMESPACE + ".booksInsert", vo);
	}

	public int booksDelete(int bnum) {
		return sqlsession.delete(NAMESPACE + ".booksDelete", bnum);
	}

	// 리뷰 달린 글 삭제할 때
	public int bookReviewDelect(int bnum) {
		return sqlsession.delete(NAMESPACE + ".bookReviewDelect", bnum);
	}

	public List<BigCategoryVO> getBigctg() {
		return sqlsession.selectList(NAMESPACE + ".bctg");
	}

	public List<SmallCategoryVO> getSmallctg(int bcatenum) {
		return sqlsession.selectList(NAMESPACE + ".smctg", bcatenum);
	}

	public int count(HashMap<String, Object> map) {
		return sqlsession.selectOne(NAMESPACE + ".count", map);
	}

	public List<BooksVO> list(HashMap<String, Object> map) {
		return sqlsession.selectList(NAMESPACE + ".list", map);
	}

	public BooksVO getBooksInfo(int bnum) {
		return sqlsession.selectOne(NAMESPACE + ".getBooksInfo", bnum);
	}

	public int updateBigCtg(int bnum) {
		return sqlsession.selectOne(NAMESPACE + ".updateBigCtg", bnum);
	}

	public int booksUpdate(BooksVO vo) {
		return sqlsession.update(NAMESPACE + ".booksUpdate", vo);
	}

	// 엑셀 리스트
	public List<BooksVO> excelList() {
		return sqlsession.selectList(NAMESPACE + ".excelList");
	}
}
