package com.jhta.finalproject.hd.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.hd.vo.HomeBestVo;


@Repository
public class HomeDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="mybatis.mapper.HomeMapper";
	
	//홈화면 베스트셀러 10개 리스트. 
	public List<HomeBestVo> bestlist(HashMap<String, Object>map){
		List<HomeBestVo>list=sqlSession.selectList(NAMESPACE+".bestlist",map);
		return list;
	}
	public List<HomeBestVo> newlist(HashMap<String, Object>map){
		List<HomeBestVo>list=sqlSession.selectList(NAMESPACE+".newlist",map);
		return list;
	}
}
