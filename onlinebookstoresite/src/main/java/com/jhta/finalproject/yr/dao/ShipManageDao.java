package com.jhta.finalproject.yr.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yr.vo.PaymentAndBookListVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Repository
public class ShipManageDao {
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE ="com.jhta.yr.mybatis.mapper.ShipMapper";
	
	//상단바 배송상태갯수리스트
	public List<HashMap<String, Object>> getShipCount(){
		return session.selectList(NAMESPACE+".shipCount");
	}
	
	//입금중 -> 배송 준비중 으로 상태 업데이트	
	public int updateBeforeToPreparing(List<Integer> list) {
		return session.update(NAMESPACE+".updateBeforeToPreparing",list);
	}
	
	//bstatus상태 바꾸기
	public int updateBstatus(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".updateBstatus",map);
	}
	
	//입금중 누를때 포인트 증가시키기(얼마나 증가시킬지 포인트 가져옴)
	public int getBookPoint(int bpaynum) {
		return session.selectOne(NAMESPACE+".getBookPoint",bpaynum);
	}
	
	//포인트 테이블에 가져온 포인트 만큼 적립시키기
	public int pointPlus(PointVo pointvo ) {
		return session.insert(NAMESPACE+".pointPlus", pointvo);
	}
	
	//회원번호 가져오기
	public int getMnum(int bpaynum) {
		return session.selectOne(NAMESPACE+".getMnum", bpaynum);
	}
	
	//책리스트 가져오기
	public List<HashMap<String, Integer>> getBookList(int bpaynum) {
		return session.selectList(NAMESPACE+".getBookList", bpaynum);
	}

	//중고책 status업데이트
	public int updateObsalestatus(int bpaynum) {
		return session.update(NAMESPACE+".updateObsalestatus", bpaynum);
	}
	
}
