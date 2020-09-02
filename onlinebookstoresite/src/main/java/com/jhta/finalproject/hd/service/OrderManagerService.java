package com.jhta.finalproject.hd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.hd.dao.OrderManagerDao;
import com.jhta.finalproject.hd.vo.ConfirmOldBookVo;
import com.jhta.finalproject.hd.vo.refundBookVo;

@Service
public class OrderManagerService {
	@Autowired
	private OrderManagerDao dao;
	
	//주문상태인거 주문취소.
	@Transactional
	public int orderCancel(HashMap<String,Object>map) {
		dao.orderCancel(map);
		List<refundBookVo>list=dao.getpaymentbook(map);
		for(refundBookVo vo:list) {
			HashMap<String, Object> bmap=new HashMap<String, Object>();
			bmap.put("bnum", vo.getBnum());
			int commBcount=dao.commonCount(bmap);
			int bcount=commBcount+vo.getBcount();
			bmap.put("bcount", bcount);
			dao.returnBookCount(bmap);
		}
		int usedpoint=dao.getUsedpoint(map);
		if(usedpoint>0) {
			map.put("point", usedpoint);
			dao.returnPoint(map);
		}
		return 1;
	}
	
	//그외상태에서 반품신청/교환신청
	@Transactional
	public int orderapply(HashMap<String, Object>map) throws Exception{
		dao.orderCancel(map);
		String [] bnum=(String[])map.get("bnum");
		for(int i=0;i<bnum.length;i++) {
			map.put("bnum", bnum[i]);
			int bcount=dao.getbcount(map);
			int paymentbook_num=dao.getpaymentbooknum(map);
			map.put("paymentbooknum",paymentbook_num);
			map.put("bcount", bcount);
			dao.inputrefund(map);
		}
		return 1;
	}
	//중고상품 구매확정 트랜잭션
	@Transactional
	public int confirmorder(HashMap<String, Object>map) throws Exception{
		dao.confirmold(map);
		dao.confirmBpayment(map);
		int bpaynum=(int)map.get("bpaynum");
		double fee=dao.getfee();
		map.put("feeper", fee);
		List<ConfirmOldBookVo>list=dao.getoldbooks(bpaynum);
		for(ConfirmOldBookVo vo:list) {
			int fprice=vo.getObsaleprice();
			double feePer=fee/100;
			int feepay=Integer.parseInt(String.valueOf(Math.round(fprice*feePer)));
			int settlement=fprice-feepay;
			map.put("fprice", fprice);
			map.put("feepay", feepay);
			map.put("settlement", settlement);
			map.put("paymentbook_num", vo.getPaymentbook_num());
			dao.insertComple(map);
		}
		return 1;
	}
	//중고상품 취소
	@Transactional
	public int cancelUsedorder(HashMap<String, Object>map) throws Exception {
		dao.orderCancel(map);
		dao.cancelmold(map);
		int usedpoint=dao.getUsedpoint(map);
		if(usedpoint>0) {
			map.put("point", usedpoint);
			dao.returnPoint(map);
		}
		return 1;
	}
	
	public List<refundBookVo> getpaymentbook(HashMap<String, Object> map) {
		return dao.getpaymentbook(map);
	}
	public int getfee() {
		return dao.getfee();
	}
}
