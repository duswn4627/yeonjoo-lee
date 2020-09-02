package com.jhta.finalproject.jm.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jm.vo.BigcateVo;
import com.jhta.finalproject.jm.vo.OldAllListVo;

@Repository
public class OldBooksDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.OldBooksMapper";
	
	public int oldallcount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".oldallcount",map);
	}
	public List<OldAllListVo> oldalllist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".oldalllist",map);
	}
	
	
	public String getosCatename(int scatenum) {
		return sqlSession.selectOne(NAMESPACE + ".getosCatename",scatenum);
	}
	public String getobCatename(int bcatenum) {
		return sqlSession.selectOne(NAMESPACE + ".getobCatename",bcatenum);
	}
	
	
	
	public int addHit(int num) {
		return sqlSession.update(NAMESPACE + ".hit",num);
	}
	public int imginfo(int bnum) {
		return sqlSession.selectOne(NAMESPACE + ".imginfo",bnum);
	}
	public List<BigcateVo> bigcate(){
		return sqlSession.selectList(NAMESPACE + ".bcatelist");
	}
	public List<OldAllListVo> oldsclist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".oldsclist",map);
	}
	public int oldsccount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".oldsccount",map);
	}
}
