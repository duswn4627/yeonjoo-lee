package com.jhta.finalproject.jm.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.BreviewVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ReviewinsertVo;

@Repository
public class BookdetailDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.BooksMapper";
	
	public List<AllListVo> bookdetail(int bnum){
		return sqlSession.selectList(NAMESPACE + ".bookdetail",bnum);
	}
	public int addHit(int bnum) {
		return sqlSession.update(NAMESPACE + ".hit",bnum);
	}
	public List<BreviewVo> reviewlist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".reviewlist",map);
	}
	public int breviewcount(int bnum) {
		return sqlSession.selectOne(NAMESPACE + ".breviewcount",bnum);
	}
	public ImgVo imginfo(int bnum) {
		return sqlSession.selectOne(NAMESPACE + ".imginfo",bnum);
	}
	
	public int breviewinsert(ReviewinsertVo vo) {
		return sqlSession.insert(NAMESPACE + ".breviewinsert",vo);
	}
	
}
