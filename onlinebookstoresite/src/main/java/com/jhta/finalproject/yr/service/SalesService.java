package com.jhta.finalproject.yr.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.yr.dao.SalesDao;
import com.jhta.finalproject.yr.vo.MethodPaymentInfoVo;

@Service
public class SalesService {
	@Autowired
	private SalesDao dao;
	
	//3일동안 결과 가져오기
	public List<HashMap<String, String>> getThreeday(){
		return dao.getThreeday();

	}
	
	//일별 리스트 가져오기
	public List<HashMap<String, String>> getList(HashMap<String,Object> map){
		return dao.getList(map);
	}
	
	//월별 리스트 가져오기
	public List<HashMap<String, String>> mothList(HashMap<String,Object> map){
		return dao.mothList(map);
	}
	
	//주별 리스트 가져오기
	public List<HashMap<String, String>> weekList(HashMap<String,Object> map){
		return dao.weekList(map);
	}
	
	//중고책 일별 리스트 가져오기
	public List<HashMap<String, String>> usedbookgetList(HashMap<String,Object> map){
		return dao.usedbookgetList(map);
	}
	
	//중고책 월별 리스트 가져오기
	public List<HashMap<String, String>> usedbookmothList(HashMap<String,Object> map){
		return dao.usedbookmothList(map);
	}

	//중고책 주별 리스트 가져오기
	public List<HashMap<String, String>> usedbookweekList(HashMap<String,Object> map){
		return dao.usedbookweekList(map);
	}
	
	//	결제수단별 주문현황	
	public List<MethodPaymentInfoVo> getThreeDayMethodpaymentInfo(){
		return dao.getThreeDayMethodpaymentInfo();
	}
}
