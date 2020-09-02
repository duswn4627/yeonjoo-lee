package com.jhta.finalproject.hd.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.hd.vo.ConfirmOldBookVo;
import com.jhta.finalproject.hd.vo.refundBookVo;

@Repository
public class OrderManagerDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="mybatis.mapper.OrderManagerMapper";
	
	public int orderCancel(HashMap<String,Object>map) {
		return sqlsession.update(NAMESPACE+".orderCancel", map);
	}
	//전체취소 책수량복구를 위해 현재 책수량을 가져옴
	public int commonCount(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".commonCount", map);
	}
	//수량복구
	public int returnBookCount(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".returnBookCount", map);
	}
	//사용한 포인트 가져옴
	public int getUsedpoint(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".getUsedpoint",map);
	}
	//사용한포인트있을때 포인트 복구함
	public int returnPoint(HashMap<String, Object>map) {
		return sqlsession.insert(NAMESPACE+".returnPoint", map);
	}
	//주문에 속하는 책가져오기 ( 책번호 / 책수량 )
	public List<refundBookVo> getpaymentbook(HashMap<String, Object> map) {
		return sqlsession.selectList(NAMESPACE+".getpaymentbook",map);
	}
	public int getbcount(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".getbcount", map);
	}
	public int getpaymentbooknum(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".getpaymentbooknum",map);
	}
	// refund 테이블에 반품/교환/취소 책들 insert 함
	public int inputrefund(HashMap<String,Object>map) {
		return sqlsession.insert(NAMESPACE+".inputrefund", map);
	}
	public int confirmBpayment(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".confirmBpayment", map);
	}
	// 중고책 상태 판매완료로 변경
	public int confirmold(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".confirmold", map);
	}
	public List<ConfirmOldBookVo>getoldbooks(int bpaynum){
		return sqlsession.selectList(NAMESPACE+".getoldbooks", bpaynum);
	}
	// 중고책 상태 다시 판매중으로 변경
	public int cancelmold(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".cancelmold", map);
	}
	// 현재 수수료 구하기
	public int getfee() {
		return sqlsession.selectOne(NAMESPACE+".getfee");
	}
	public int insertComple(HashMap<String, Object>map) {
		return sqlsession.insert(NAMESPACE+".insertComple", map);
	}
}
