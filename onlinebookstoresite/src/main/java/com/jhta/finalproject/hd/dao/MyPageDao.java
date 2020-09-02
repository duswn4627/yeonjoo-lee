package com.jhta.finalproject.hd.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.hd.vo.AccountHistoryVo;
import com.jhta.finalproject.hd.vo.AccountVo;
import com.jhta.finalproject.hd.vo.DepositHistoryVo;
import com.jhta.finalproject.hd.vo.HistoryListVo;
import com.jhta.finalproject.hd.vo.QnaAnswerVo;
import com.jhta.finalproject.hd.vo.QnaHistoryVo;

@Repository
public class MyPageDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="mybatis.mapper.MyPageMapper";
	
	public List<HistoryListVo> orderhistory(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".orderhistory",map);
	}
	public HashMap<String, Object> confirmtype(int bpaynum) {
		return sqlsession.selectOne(NAMESPACE+".confirmtype",bpaynum);
	}
	
	public int countPaymentBook(int bpaynum) {
		return sqlsession.selectOne(NAMESPACE+".countPaymentBook",bpaynum);
	}
	public int getbcount(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".getbcount", map);
	}
	
	public String newBtitle(int bnum) {
		return sqlsession.selectOne(NAMESPACE+".newBtitle", bnum);
	}
	public HashMap<String, Object> usedBtilte(int bnum){
		return sqlsession.selectOne(NAMESPACE+".usedTitle",bnum);
	}
	public int countHistory(HashMap<String, Object> map) {
		return sqlsession.selectOne(NAMESPACE+".countHistory",map);
	}
	public QnaHistoryVo qnadetail(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".qnadetail",map);
	}
	public QnaAnswerVo qnaAnswer(int qnanum) {
		return sqlsession.selectOne(NAMESPACE+".qnaAnswer", qnanum);
	}
	public int countcart(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".countcart",mnum);
	}
	
	public int countDeposithistory(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".countDeposithistory", map);
	}
	public List<DepositHistoryVo> deposithistory(HashMap<String, Object>map){
		return sqlsession.selectList(NAMESPACE+".deposithistory",map);
	}
	
	public int confirmacount(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".confirmacount",mnum);
	}
	public int insertAccount(HashMap<String, Object>map) {
		return sqlsession.insert(NAMESPACE+".insertAccount",map);
	}
	public AccountVo selectAccount(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".selectAccount", mnum);
	}
	public int applydeposit(HashMap<String, Object>map) {
		return sqlsession.insert(NAMESPACE+".applydeposit", map);
	}
	public int applydeposit_depositTable(HashMap<String, Object>map) {
		return sqlsession.insert(NAMESPACE+".applydeposit_depositTable", map);
	}
	
	public int getdeposit_num() {
		return sqlsession.selectOne(NAMESPACE+".getdeposit_num");
	}
	//문의내역 행수 
	public int countQnaHistory(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".countQnaHistory",map);
	}
	//문의내역리스트
	public List<QnaHistoryVo> qnahistory(HashMap<String, Object>map){
		return sqlsession.selectList(NAMESPACE+".qnaHistory",map);
	}
	public int qnawrite(HashMap<String, Object>map) {
		return sqlsession.insert(NAMESPACE+".qnawrite", map);
	}
	
	//마이페이지 최근리스트들
	public List<HistoryListVo> recentorder(int mnum){
		return sqlsession.selectList(NAMESPACE+".recentorder", mnum);
	}
	
	public List<HistoryListVo> recentcancel(int mnum){
		return sqlsession.selectList(NAMESPACE+".recentcancel", mnum);
	}
	
	public List<QnaHistoryVo> recentqna(int mnum){
		return sqlsession.selectList(NAMESPACE+".recentqna",mnum);
	}
	
	public int countAccount(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".countAccount",map);
	}
	
	public List<AccountHistoryVo> accounthistory(HashMap<String, Object>map){
		return sqlsession.selectList(NAMESPACE+".accounthistory",map);
	}
	public int updateAccount(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".updateAccount", map);
	}
}
