package com.jhta.finalproject.hd.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.hd.dao.MyPageDao;
import com.jhta.finalproject.hd.vo.AccountHistoryVo;
import com.jhta.finalproject.hd.vo.AccountVo;
import com.jhta.finalproject.hd.vo.DepositHistoryVo;
import com.jhta.finalproject.hd.vo.HistoryListVo;
import com.jhta.finalproject.hd.vo.QnaAnswerVo;
import com.jhta.finalproject.hd.vo.QnaHistoryVo;

@Service
public class MyPageService {
	@Autowired
	private MyPageDao dao;
	
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
	public int countQnaHistory(HashMap<String,Object>map) {
		return dao.countQnaHistory(map);
	}
	public List<QnaHistoryVo> qnahistory(HashMap<String, Object>map){
		return dao.qnahistory(map);
	}
	public int qnawrite(HashMap<String, Object>map) {
		return dao.qnawrite(map);
	}
	public QnaHistoryVo qnadetail(HashMap<String, Object>map) {
		return dao.qnadetail(map);
	}
	public QnaAnswerVo qnaAnswer(int qnanum) {
		return dao.qnaAnswer(qnanum);
	}
	public int countcart(int mnum) {
		return dao.countcart(mnum);
	}
	public int countDeposithistory(HashMap<String, Object>map) {
		return dao.countDeposithistory(map);
	}
	public List<DepositHistoryVo> deposithistory(HashMap<String, Object>map){
		return dao.deposithistory(map);
	}
	public int confirmacount(int mnum) {
		return dao.confirmacount(mnum);
	}
	public int insertAccount(HashMap<String, Object>map) {
		return dao.insertAccount(map);
	}
	public AccountVo selectAccount(int mnum) {
		return dao.selectAccount(mnum);
	}
	@Transactional
	public int applydeposit(HashMap<String, Object>map) throws Exception{
			int reqmoney=(int)map.get("reqmoney");
			int applymoney=(-1)*reqmoney;
			map.put("applymoney", applymoney);
			dao.applydeposit_depositTable(map);
			int dnum=dao.getdeposit_num();
			map.put("dnum", dnum);
			dao.applydeposit(map);
			
			return 1;
	}
	
	
	//마이페이지 최근리스트 관련 서비스
	public List<HistoryListVo> recentorder(int mnum){
		return dao.recentorder(mnum);
	}
	public List<HistoryListVo> recentcancel(int mnum){
		return dao.recentcancel(mnum);
	}
	public List<QnaHistoryVo> recentQna(int mnum){
		return dao.recentqna(mnum);
	}
	
	public int countAccount(HashMap<String, Object>map) {
		return dao.countAccount(map);
	}
	
	public List<AccountHistoryVo> accounthistory(HashMap<String, Object>map){
		return dao.accounthistory(map);
	}
	public int updateAccount(HashMap<String, Object>map) {
		return dao.updateAccount(map);
	}
}
