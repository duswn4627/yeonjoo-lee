package com.jhta.finalproject.yr.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.yr.dao.CSManageDao;
import com.jhta.finalproject.yr.dao.ReturnDao;
import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Service
public class ReturnServiceImpl implements ReturnService{

	@Autowired
	private CSManageDao dao;
	
	@Autowired
	private ReturnDao rdao;
	
	@Transactional
	@Override
	public int updateStatus(String status,List<Integer> paymentbookNum,PointVo pointvo, DepositVo depositvo, HashMap<String, Object> map) {
		int n1 = 0;
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("status", status);
		hmap.put("paymentbook_num", paymentbookNum);
		
		n1 = dao.updateStatus(hmap);
		int n2 = rdao.pointReturn(pointvo);
		int n3 = rdao.giveDeposit(depositvo);
		int n4 = rdao.updatePayment(map);
		return 1;
	}
	
	
	@Override
	public int getMnum(int bpaynum) {
		return rdao.getMnum(bpaynum);
	}
}
