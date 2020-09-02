package com.jhta.finalproject.hd.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.hd.vo.CartListVo;
import com.jhta.finalproject.hd.vo.UsedCartListVo;

@Repository
public class CartDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="mybatis.mapper.CartMapper";
	
	//장바구니 리스트 출력 dao
	public List<CartListVo> cartlist(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".cartlist", map);
	}
	//장바구니 하나삭제 dao
	public int deleteOne(int cartNum) {
		return sqlsession.delete(NAMESPACE+".deleteOne", cartNum);
	}
	//장바구니 수량변경 dao
	public int changeCount(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".changeCount", map);
	}
	//장바구니 선택한거 삭제 dao
	public int deleteSelected(HashMap<String,Object>map) {
		return sqlsession.delete(NAMESPACE+".deleteSelected", map);
	}
	//중고상품 장바구니 리스트 출력 dao
	public List<UsedCartListVo> usedlist(int mnum){
		return sqlsession.selectList(NAMESPACE+".usedlist",mnum);
	}
	//중고상품 판매자 아이디 dao
	public String getSid(int snum) {
		return sqlsession.selectOne(NAMESPACE+".getSid", snum);
	}
}
