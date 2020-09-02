package com.jhta.finalproject.yr.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yr.vo.PaymentAndBookListVo;
import com.jhta.finalproject.yr.vo.PaymentVo;

@Repository
public class PaymentDao {
	
	@Autowired
	public SqlSessionTemplate session;
	private final String NAMESPACE = "com.jhta.yr.mybatis.mapper.PaymentMapper";
	
//	public List<PaymentVo> allList(HashMap<String, Object> map){
//		return session.selectList(NAMESPACE+".allList",map);
//	}
	
	//새책 전체리스트보이도록
	public List<PaymentAndBookListVo> paymentList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".paymentList",map);
	}
	
	//중고책 전체리스트보이도록

	public List<PaymentAndBookListVo> usedBookPaymentList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".usedBookPaymentList",map);
	}
	
	//새책 전체 글 갯수
	public int getTotalCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".getTotalCount",map);		
	}

	//중고책 전체 글 갯수
	public int getusedBookTotalCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".getusedBookTotalCount",map);		
	}

	// 오늘 결제갯수
	public int getTodayPaymentCount() {
		return session.selectOne(NAMESPACE+".getTodayPaymentCount");		
	}
	
	// 오늘 주문 갯수
	public int getTodayOrderCount() {
		return session.selectOne(NAMESPACE+".getTodayOrderCount");		
	}
}
