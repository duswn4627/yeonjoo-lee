package com.jhta.finalproject.yr.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yr.vo.SettlementJoinVo;

@Repository
public class DepositDao {
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE = "com.jhta.yr.mybatis.mapper.DepositMapper";
	
	public List<SettlementJoinVo> getSettlementList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".settlementList",map);
	}
	
	public int updateSestatus(int senum) {
		return session.update(NAMESPACE+".updateSestatus", senum);
	}
	
	//seatatus의 dnum에 상태 업데이트하기
	public int updateDeposit(int dnum) {
		return session.update(NAMESPACE+".updateDeposit", dnum);
	}
	
	//dnum가져오기
	public int getDnum(int senum) {
		return session.selectOne(NAMESPACE+".getDnum", senum);
	}

	
	//갯수세기
	public int getCount(HashMap<String, Object> map){
		return session.selectOne(NAMESPACE+".getCount",map);
	}
	
}
