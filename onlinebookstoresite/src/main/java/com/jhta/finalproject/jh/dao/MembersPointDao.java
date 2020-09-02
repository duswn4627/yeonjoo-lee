package com.jhta.finalproject.jh.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jh.vo.MembersPointVo;

@Repository
public class MembersPointDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.PointMapper.jh";
	
	//현재 회원의 포인트 가져오기
	public int getTotPoint(int mnum) {
		return sqlSession.selectOne(NAMESPACE+".getTotPoint", mnum);
	}
	
	//현재 회원 등급 가져오기
	public String getGrade(int mnum) {
		return sqlSession.selectOne(NAMESPACE+".getGrade", mnum);
	}
	
	//회원포인트리스트 가져오기
	public List<MembersPointVo> getPointList(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".getPointList", map);
	}
	
	//회원 포인트 총 갯수 가져오기
	public int getRowPointCount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getRowPointCount", map);
	}
}
