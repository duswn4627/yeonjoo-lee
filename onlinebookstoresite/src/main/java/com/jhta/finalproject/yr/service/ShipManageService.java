package com.jhta.finalproject.yr.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.yr.dao.ShipManageDao;
import com.jhta.finalproject.yr.vo.PaymentAndBookListVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Service
public class ShipManageService {

	@Autowired
	private ShipManageDao dao;
	
	public List<HashMap<String, Object>> getShipCount(){
		return dao.getShipCount();
	}
	
	public int updateBstatus(HashMap<String,Object> map) {
		return dao.updateBstatus(map);
	}
	
}	
