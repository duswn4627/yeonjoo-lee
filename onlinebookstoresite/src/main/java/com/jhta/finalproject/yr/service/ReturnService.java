package com.jhta.finalproject.yr.service;

import java.util.HashMap;
import java.util.List;

import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.PointVo;

public interface ReturnService {	
	int updateStatus(String status,List<Integer> paymentbookNum,
			PointVo pointvo, DepositVo depositvo,HashMap<String, Object> map);
	int getMnum(int paynum);
}
