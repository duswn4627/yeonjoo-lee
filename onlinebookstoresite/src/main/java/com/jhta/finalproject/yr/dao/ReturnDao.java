package com.jhta.finalproject.yr.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Repository
public class ReturnDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private final String NAMESPACE = "com.jhta.yr.mybatis.mapper.CSMapper";
	
	
	public int getMnum(int bpaynum) {
		return session.selectOne(NAMESPACE+".getMnum",bpaynum);
	}
	
	public int pointReturn(PointVo pointVo) {
		return session.insert(NAMESPACE+".pointReturn", pointVo);
	}

	public int giveDeposit(DepositVo depositVo) {
		return session.insert(NAMESPACE+".giveDeposit", depositVo);
	}
	
	public int updatePayment(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".updatePayment", map);
	}
	
}
