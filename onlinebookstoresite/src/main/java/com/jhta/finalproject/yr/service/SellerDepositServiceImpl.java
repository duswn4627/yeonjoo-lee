package com.jhta.finalproject.yr.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.yr.dao.SellerDepositDao;
import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.UsedOldBookSellerInfoVo;

@Service
public class SellerDepositServiceImpl implements SellerDepositService{
	
	@Autowired private SellerDepositDao dao;

	@Override
	public List<UsedOldBookSellerInfoVo> getList(HashMap<String, Object> map) {
		return dao.getList(map);
	}
	
	@Transactional
	@Override
	public int updateSellerDepositStatus(List<Integer> paymentBookNum,List<Integer> bpaynumList, List<Integer> sellernum, List<Integer> price) {
		for (int i = 0; i < bpaynumList.size(); i++) {
			int n = dao.updateObcomplete(paymentBookNum.get(i));
			DepositVo vo = new DepositVo(0, sellernum.get(i), bpaynumList.get(i), price.get(i), null, 0); 
			int n2 = dao.insertDeposit(vo);
		}
		return 1;
	}
	
	@Override
	public int getCount(HashMap<String, Object> map){
		return dao.getCount(map);
	}
}
