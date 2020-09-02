package com.jhta.finalproject.hd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.hd.dao.OrderDao;
import com.jhta.finalproject.hd.vo.OrderCompleteListVo;
import com.jhta.finalproject.hd.vo.OrderCompleteResultVo;
import com.jhta.finalproject.hd.vo.OrderCompleteUsedListVo;
import com.jhta.finalproject.hd.vo.OrderListResultVo;
import com.jhta.finalproject.hd.vo.ShipmentInfoVo;
import com.jhta.finalproject.hd.vo.UsedOrderListVo;
import com.jhta.finalproject.hd.vo.VbankVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao dao;
	
	// 주문완료 트랜잭션 //
	@Transactional
	public HashMap<String, Object> ordercomplete(Map<String, Object>map){
		String [] bnum=(String [])map.get("bnum");
		String [] bcount=(String [])map.get("bcount");
		String [] point=(String [] )map.get("point");
		String method=(String)map.get("method");
		String separate=(String)map.get("separate");
		dao.bpayment(map);
		int bpayNum=dao.getbpayNum();
		HashMap<String, Object> map1=new HashMap<String, Object>();
		map.put("bpaynum", bpayNum);
		map1.put("bpaynum", bpayNum);
		map1.put("separate",separate);
		for(int i=0;i<bnum.length;i++) {
			map1.put("bnum", bnum[i]);
			map1.put("bcount",bcount[i]);
			if(separate.equals("new")) {
				int orgbcount=dao.books_bcount(map1); //현재 테이블에서 수량 구하기.
				int orderbcount=Integer.parseInt(bcount[i]);//주문한수량.
				int changebcount=orgbcount-orderbcount; 
				map1.put("changebcount",changebcount);
				map1.put("point",point[i]);
				dao.change_count(map1); //book테이블 수량변경 
			}else {
				map1.put("point",0);
			}
			dao.paymentbook(map1); // paymentbook 테이블에 데이터추가.	
		}
		if(separate.equals("used")) {
			dao.change_salestatus(map);
		}
		if((int)map.get("mnum")!=0) {
			int usedpoint=(int)map.get("usepoint")*(-1);
			map.put("usedpoint", usedpoint);
			dao.use_point(map); //포인트 사용내역 insert
			if(method.equals("card")&&separate.equals("new")) { //카드일떄만 바로 ..
				dao.point_plus(map); //적립포인트 +
			}
		}
		if(map.get("cartNum")!=null) { //카트번호 배열이 존재할경우..(장바구니에서부터 주문한경우)
			dao.delete_cart(map);	   //장바구니에서도 삭제해주어야함.
		}
		if(method.equals("vbank")) { //가상계좌방식의 경우.
			dao.vbank(map);
		}
		HashMap<String,Object> resultmap=new HashMap<String, Object>();
		resultmap.put("bpaynum",bpayNum);
		return resultmap;
	}
	// =====주문완료 트랜잭션 끝========= //
	
	public OrderCompleteResultVo complete_info(int bpaynum) {
		return dao.complete_info(bpaynum);
	}
	public String getName(int mnum) {
		return dao.getName(mnum);
	}
	public List<OrderCompleteListVo> getPaymentBook(int bpaynum){
		return dao.getPaymentBook(bpaynum);
	}
	public List<OrderCompleteUsedListVo> getUsedPaymentBook(int bpaynum){
		return dao.getUsedPaymentBook(bpaynum);
	}
	public VbankVo vbank_info(int bpaynum) {
		return dao.vbank_info(bpaynum);
	}
	
	//새상품 주문리스트
	public List<OrderListResultVo> inputorderlist(Map<String, Object>map){
		return dao.inputorderlist(map);
	}
	//바로구매클릭시 주문리스트
	public OrderListResultVo directorder(int bnum) {
		return dao.directOrder(bnum);
	}
	//배송주소 받아오기
	public ShipmentInfoVo getAddr(int mnum) {
		return dao.getAddr(mnum);
	}
	//사용가능한 주소
	public int getPoint(int mnum) {
		return dao.getPoint(mnum);
	}
	public List<UsedOrderListVo> usedorderlist(Map<String,Object>map){
		return dao.usedorderlist(map);
	}
	public UsedOrderListVo directusedorder(int obnum) {
		return dao.directUsedOrder(obnum);
	}
}
