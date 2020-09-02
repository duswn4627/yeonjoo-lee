package com.jhta.finalproject.hd.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.hd.dao.OrderHistoryDao;
import com.jhta.finalproject.hd.vo.HistoryDetailBookListVo;
import com.jhta.finalproject.hd.vo.HistoryDetailInfoVo;
import com.jhta.finalproject.hd.vo.HistoryListVo;
import com.jhta.finalproject.hd.vo.VbankVo;

@Service
public class OrderHistoryService {
	@Autowired
	private OrderHistoryDao dao;
	
	public List<HistoryListVo> orderhistory(HashMap<String, Object>map){
		return dao.orderhistory(map);
	}
	public HashMap<String,Object> confirmtype(int bpaynum) {
		return dao.confirmtype(bpaynum);
	}
	public int countPaymentBook(int bpaynum) {
		return dao.countPaymentBook(bpaynum);
	}
	
	public String newBtitle(int bnum) {
		return dao.newBtitle(bnum);
	}
	
	public HashMap<String, Object> usedBtitle(int bnum){
		return dao.usedBtilte(bnum);
	}
	public int countHistory(HashMap<String, Object>map) {
		return dao.countHistory(map);
	}
	//주문상세페이지에서 주문한책 리스트 가져옴 
	public List<HistoryDetailBookListVo> orderbooklist(int bpaynum){
		return dao.orderbooklist(bpaynum);
	}
	//주문상세페이지에서 주문한책 리스트 가져옴 
		public List<HistoryDetailBookListVo> usedorderbooklist(int bpaynum){
			return dao.usedorderbooklist(bpaynum);
		}
	public HistoryDetailInfoVo orderinfo(int bpaynum) {
		return dao.orderinfo(bpaynum);
	}
	public VbankVo vbank_info(int bpaynum) {
		return dao.vbank_info(bpaynum);
	}
}
