package com.jhta.finalproject.hd.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.hd.dao.NonmemberDao;

@Service
public class NonmemberService {
	@Autowired
	private NonmemberDao dao;
	
	public int confirmbpayment(HashMap<String, Object>map) {
		return dao.confirmbpayment(map);
	}
	
	public HashMap<String, Object>nomenOrder(HashMap<String, Object>map){
		return dao.nomenOrder(map);
	}
	
}
