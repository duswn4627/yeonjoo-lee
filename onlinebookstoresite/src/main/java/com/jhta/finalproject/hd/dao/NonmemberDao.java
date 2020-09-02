package com.jhta.finalproject.hd.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NonmemberDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="mybatis.mapper.NonmemberMapper";
	
	public int confirmbpayment(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".confirmbpayment", map);
	}
	public HashMap<String, Object>nomenOrder(HashMap<String, Object>map){
		return sqlsession.selectOne(NAMESPACE+".nomenOrder",map);
	}
}
