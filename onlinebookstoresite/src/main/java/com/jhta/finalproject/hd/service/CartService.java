package com.jhta.finalproject.hd.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.hd.dao.CartDao;
import com.jhta.finalproject.hd.vo.CartListVo;
import com.jhta.finalproject.hd.vo.UsedCartListVo;

@Service
public class CartService {
	
	@Autowired
	private CartDao dao;
	
	//장바구니 리스트 출력 service
	public List<CartListVo> cartlist(HashMap<String, Object> map){
		return dao.cartlist(map);
	}
	//장바구니 하나삭제 service
	public int deleteOne(int cartNum) {
		return dao.deleteOne(cartNum);
	}
	//장바구니 수량변경 service
	public int changeCount(HashMap<String, Object>map) {
		return dao.changeCount(map);
	}
	//장바구니 선택한거 삭제 service
	public int deleteSelected(HashMap<String, Object> map) {
		return dao.deleteSelected(map);
	}
	//중고 장바구니 리스트 출력 Service
	public List<UsedCartListVo> usedlist(int mnum) {
		return dao.usedlist(mnum);
	}
	//중고 장바구니 판매자구하기.
	public String getSid(int snum) {
		return dao.getSid(snum);
	}
	
	
}
