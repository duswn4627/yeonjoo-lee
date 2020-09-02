package com.jhta.finalproject.jh.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jh.vo.SellerFeepayJoinVo;

@Repository
public class SellerSettlementDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.SellerSettlementMapper.jh";
	
	//정산관련 리스트 가져오기
	public List<SellerFeepayJoinVo> getSettlementList(HashMap<String, Object> map){
		List<SellerFeepayJoinVo> list= sqlSession.selectList(NAMESPACE+".getSettlementList", map);
		return list;
	}
	
	//정산관련 전체 행Count
	public int getTotRowCount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+".getTotRowCount", map);
	}
}
