package com.jhta.finalproject.yr.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.yr.dao.PaymentDao;
import com.jhta.finalproject.yr.vo.PaymentAndBookListVo;
import com.jhta.finalproject.yr.vo.PaymentVo;

@Service
public class PaymentService {
	
	@Autowired
	public PaymentDao dao;
	
	//새책전체리스트보이도록
	public List<PaymentAndBookListVo> paymentList(HashMap<String, Object> map){
		return dao.paymentList(map);
	}
	//중고책 전체리스트
	public List<PaymentAndBookListVo> usedBookPaymentListt(HashMap<String, Object> map){
		return dao.usedBookPaymentList(map);
	}
	
	//책 전체 갯수
	public int getTotalCount(HashMap<String, Object> map) {
		return dao.getTotalCount(map);		
	}
	//중고책 전체 갯수
	public int getusedBookTotalCount(HashMap<String, Object> map) {
		return dao.getTotalCount(map);		
	}
	
	// 오늘 결제갯수
	public int getTodayPaymentCount() {
		return dao.getTodayPaymentCount();		
	}
	
	// 오늘 주문 갯수
	public int getTodayOrderCount() {
		return dao.getTodayOrderCount();		
	}
}
