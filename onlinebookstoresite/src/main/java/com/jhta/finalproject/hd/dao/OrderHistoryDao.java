package com.jhta.finalproject.hd.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.hd.vo.HistoryDetailBookListVo;
import com.jhta.finalproject.hd.vo.HistoryDetailInfoVo;
import com.jhta.finalproject.hd.vo.HistoryListVo;
import com.jhta.finalproject.hd.vo.VbankVo;

@Repository
public class OrderHistoryDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="mybatis.mapper.OrderHistoryMapper";
	
	
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
	//주문 상세페이지에서 주문한책리스트.
	public List<HistoryDetailBookListVo> orderbooklist(int bpaynum){
		return sqlsession.selectList(NAMESPACE+".orderbooklist",bpaynum);
	}
	//주문 상세페이지에서 주문한중고책리스트.
	public List<HistoryDetailBookListVo> usedorderbooklist(int bpaynum){
		return sqlsession.selectList(NAMESPACE+".orderusedlist",bpaynum);
	}
	public HistoryDetailInfoVo orderinfo(int bpaynum) {
		return sqlsession.selectOne(NAMESPACE+".orderinfo",bpaynum);
	}
	public VbankVo vbank_info(int bpaynum) {
		return sqlsession.selectOne(NAMESPACE+".vbank_info",bpaynum);
	}
	
	
}
