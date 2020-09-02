package com.jhta.finalproject.yr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.yr.dao.DepositDao;

@Service
public class RefundServiceImpl implements RefundService{

	@Autowired
	private DepositDao dao;
	
	@Transactional
	@Override
	public int updateSestausAndUpdateDeposit(List<Integer> senum, 
			List<Integer> mnum, List<Integer> priceArr) {
		
		for (Integer sn : senum) {
			dao.updateSestatus(sn);
			int dnum = dao.getDnum(sn);
			int n = dao.updateDeposit(dnum);
		}
		
		return 1;
	}
	
}
