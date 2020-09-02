package com.jhta.finalproject.jm.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jm.vo.CartVo;
import com.jhta.finalproject.jm.vo.OldCartVo;

@Repository
public class jmCartDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="com.jhta.mybatis.mapper.BooksMapper";
	
	public int cartinsert(CartVo vo) {
		return session.insert(NAMESPACE+".cartinsert",vo);
	}
	public int cartselect(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".cartselect",map);
	}
}
