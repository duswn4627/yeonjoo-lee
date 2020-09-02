package com.jhta.finalproject.hd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.hd.vo.OrderCompleteListVo;
import com.jhta.finalproject.hd.vo.OrderCompleteResultVo;
import com.jhta.finalproject.hd.vo.OrderCompleteUsedListVo;
import com.jhta.finalproject.hd.vo.OrderListResultVo;
import com.jhta.finalproject.hd.vo.ShipmentInfoVo;
import com.jhta.finalproject.hd.vo.UsedOrderListVo;
import com.jhta.finalproject.hd.vo.VbankVo;

@Repository
public class OrderDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="mybatis.mapper.OrderMapper";
	//=========== 주문완료 트랜잭션 관련 dao 시작 ===================//
	
	//주문결제테이블에 데이터추가 ( 카드결제 )
	public int bpayment(Map<String, Object>map) {
		return sqlsession.insert(NAMESPACE+".bpayment",map);
	}
	//주문결제테이블에 추가한데이터 주문번호 가져오기.
	public int getbpayNum() {
		return sqlsession.selectOne(NAMESPACE+".getbpayNum");
	}
	//주문한책테이블에 데이터추가 
	public int paymentbook(HashMap<String, Object> map) {
		return sqlsession.insert(NAMESPACE+".paymentbook",map);
	}
	//새첵테이블에서 원래수량구하기.
	public int books_bcount(HashMap<String,Object>map) {
		return sqlsession.selectOne(NAMESPACE+".books_bcount",map);
	}
	//새책테이블 수량변경
	public int change_count(HashMap<String,Object>map) {
		return sqlsession.update(NAMESPACE+".change_count", map);
	}
	//포인트사용
	public int use_point(Map<String,Object>map) {
		return sqlsession.insert(NAMESPACE+".use_point",map);
	}
	//포인트적립
	public int point_plus(Map<String,Object>map) {
		return sqlsession.insert(NAMESPACE+".point_plus", map);
	}
	//주문/결제 할때 장바구니번호 있을경우 장바구니에서 삭제함.
	public int delete_cart(Map<String,Object>map) {
		return sqlsession.delete(NAMESPACE+".delete_cart", map);
	}
	// 가상계좌 주문/결제시 가상계좌 테이블에 데이터추가.
	public int vbank(Map<String,Object>map) {
		return sqlsession.insert(NAMESPACE+".vbank",map);
	}
	public int change_salestatus(Map<String,Object>map) {
		return sqlsession.update(NAMESPACE+".change_salestatus",map);
	}
	
	//=========== 주문완료 트랜잭션 관련 dao 끝 ===================//
	
	public OrderCompleteResultVo complete_info(int bpaynum) {
		return sqlsession.selectOne(NAMESPACE+".complete_info", bpaynum);
	}
	
	public String getName(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".getName",mnum);
	}
	
	public List<OrderCompleteListVo> getPaymentBook(int bpaynum){
		return sqlsession.selectList(NAMESPACE+".getPaymentBook",bpaynum);
	}
	public List<OrderCompleteUsedListVo> getUsedPaymentBook(int bpaynum){
		return sqlsession.selectList(NAMESPACE+".getUsedPaymentBook", bpaynum);
	}
	
	public VbankVo vbank_info(int bpaynum) {
		return sqlsession.selectOne(NAMESPACE+".vbank_info",bpaynum);
	}
	
	// ============ 새상품 관련 dao 시작 ==========================//
	//주문리스트 출력
	public List<OrderListResultVo> inputorderlist(Map<String, Object>map){
		return sqlsession.selectList(NAMESPACE+".orderlist", map);
	}
	//구매하기버튼 바로클릭시 ( 장바구니 안들림 )
	public OrderListResultVo directOrder(int bnum){
		return sqlsession.selectOne(NAMESPACE+".directorder",bnum);
	}
	//회원번호로 회원 배송지 정보 가져옴.
	public ShipmentInfoVo getAddr(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".getAddr",mnum);
	}
	//회원번호로 사용가능한 포인트가져옴.
	public int getPoint(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".usablepoint",mnum);
	}
	// ============ 새상품 관련 dao 끝 ==========================//
	
	
	// ============ 중고상품 관련 dao 시작 ==========================//
	public List<UsedOrderListVo> usedorderlist(Map<String,Object>map){
		return sqlsession.selectList(NAMESPACE+".usedorderlist",map);
	}
	public UsedOrderListVo directUsedOrder(int obnum) {
		return sqlsession.selectOne(NAMESPACE+".directusedorder",obnum);
	}
	
	// ============ 중고상품 관련 dao 끝 ==========================//

}
