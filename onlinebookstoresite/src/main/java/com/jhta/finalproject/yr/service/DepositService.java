package com.jhta.finalproject.yr.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.yr.dao.DepositDao;
import com.jhta.finalproject.yr.vo.SettlementJoinVo;

@Service
public class DepositService {
	@Autowired
	private DepositDao dao;
	
	public List<SettlementJoinVo> getSettlementList(HashMap<String, Object> map){
		return dao.getSettlementList(map);
	}
	
	//갯수세기
	public int getCount(HashMap<String, Object> map){
		return dao.getCount(map);
	}
}
