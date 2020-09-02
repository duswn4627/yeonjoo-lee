package com.jhta.finalproject.jh.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jh.dao.SellerSettlementDao;
import com.jhta.finalproject.jh.vo.SellerFeepayJoinVo;

@Service
public class SellerSettlmentService {
	@Autowired
	private SellerSettlementDao dao;
	
	//정산관련 리스트 가져오기
	public List<SellerFeepayJoinVo> getSettlementList(HashMap<String, Object> map){
		List<SellerFeepayJoinVo> list=dao.getSettlementList(map);
		return list;
	}
	//정산관련 전체 행Count
	public int getTotRowCount(HashMap<String, Object> map) {
		return dao.getTotRowCount(map);
	}
}
