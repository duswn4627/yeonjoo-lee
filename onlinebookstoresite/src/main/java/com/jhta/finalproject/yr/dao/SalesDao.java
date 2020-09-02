package com.jhta.finalproject.yr.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yr.vo.MethodPaymentInfoVo;

@Repository
public class SalesDao {
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE = "com.jhta.yr.mybatis.mapper.SalesMapper";
	
	public List<HashMap<String, String>> getThreeday(){
		return session.selectList(NAMESPACE+".getThreeday");
	}

	public List<HashMap<String, String>> getList(HashMap<String,Object> map){
		return session.selectList(NAMESPACE+".getList",map);
	}

	public List<HashMap<String, String>> mothList(HashMap<String,Object> map){
		return session.selectList(NAMESPACE+".mothList",map);
	}
	
	public List<HashMap<String, String>> weekList(HashMap<String,Object> map){
		return session.selectList(NAMESPACE+".weekList",map);
	}

	public List<HashMap<String, String>> usedbookgetList(HashMap<String,Object> map){
		return session.selectList(NAMESPACE+".usedbookgetList",map);
	}
		
	public List<HashMap<String, String>> usedbookmothList(HashMap<String,Object> map){
		return session.selectList(NAMESPACE+".usedbookmothList",map);
	}
	public List<HashMap<String, String>> usedbookweekList(HashMap<String,Object> map){
		return session.selectList(NAMESPACE+".usedbookweekList",map);
	}

//	결제수단별 주문현황	
	public List<MethodPaymentInfoVo> getThreeDayMethodpaymentInfo(){
		return session.selectList(NAMESPACE+".getThreeDayMethodpaymentInfo");
	}
	
	
	
	
}
