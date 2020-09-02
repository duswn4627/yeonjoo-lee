package com.jhta.finalproject.yj.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yj.vo.ImgVO;

@Repository
public class ImgDao {
	@Autowired
	private SqlSessionTemplate sqlsession;
	private final String NAMESPACE = "com.jhta.yj.mybatis.mapper.BooksMapper";

	public void setSqlsession(SqlSessionTemplate sqlsession) {
		this.sqlsession = sqlsession;
	}

	public int imgInsert(ImgVO vo) {
		return sqlsession.insert(NAMESPACE + ".imgInsert", vo);
	}

	public List<ImgVO> getImgInfo(int bnum) {
		return sqlsession.selectList(NAMESPACE + ".getImgInfo", bnum);
	}

	public int imgDelete(int bnum) {
		return sqlsession.delete(NAMESPACE + ".imgDelete", bnum);
	}

	public int imgUpdate(ImgVO ivo) {
		return sqlsession.update(NAMESPACE + ".imgUpdate", ivo);
	}

	public int imgUpdateDelete(int imgnum) {
		return sqlsession.delete(NAMESPACE + ".imgUpdateDelete", imgnum);
	}
}
