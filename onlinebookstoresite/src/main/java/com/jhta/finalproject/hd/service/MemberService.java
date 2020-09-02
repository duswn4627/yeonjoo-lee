package com.jhta.finalproject.hd.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.hd.dao.MemberDao;
import com.jhta.finalproject.hd.vo.LoginCheckVo;
import com.jhta.finalproject.hd.vo.MemberinfoVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	public LoginCheckVo membercheck(HashMap<String, Object>map) {
		return dao.membercheck(map);
	}
	
	//탈퇴시 체크 service
	
	public int ordercheck(int mnum) {
		return dao.ordercheck(mnum);
	}
	public int depositapplycheck(int mnum) {
		return dao.depositapplycheck(mnum);
	}
	public List<Integer> depositcheck(int mnum){
		return dao.depositcheck(mnum);
	}
	public int obsellercheck(int mnum) {
		return dao.obsellercheck(mnum);
	}
	public int obcheck(int snum) {
		return dao.obcheck(snum);
	}
	//탈퇴처리 
	public int leavemember(int mnum) {
		return dao.leavemember(mnum);
	}
	//회원정보조회
	public MemberinfoVo memberinfo(int mnum) {
		return dao.memberinfo(mnum);
	}
	
	public int updatephone(HashMap<String, Object>map) {
		return dao.updatephone(map);
	}
	public int updatepwd(HashMap<String, Object>map) {
		return dao.updatepwd(map);
	}
	public int updateEmail(HashMap<String, Object>map) {
		return dao.updateEmail(map);
	}
	public int updateaddr(HashMap<String, Object>map) {
		return dao.updateaddr(map);
	}
}
