package com.jhta.finalproject.jm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jm.vo.BigcateVo;
import com.jhta.finalproject.jm.vo.SmallcateVo;

@Repository
public class SmallcateDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.BooksMapper";
	
	public List<SmallcateVo> list(int bcatenum){
		return sqlSession.selectList(NAMESPACE + ".scatelist",bcatenum);
	}
}
