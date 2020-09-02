package com.jhta.finalproject.jh.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jh.dao.MembersPointDao;
import com.jhta.finalproject.jh.vo.MembersPointVo;

@Service
public class MembersPointService {
	@Autowired
	private MembersPointDao dao;
	//현재 회원의 포인트 가져오기
	public int getTotPoint(int mnum) {
		return dao.getTotPoint(mnum);
	}
	//현재 회원 등급 가져오기
	public String getGrade(int mnum) {
		return dao.getGrade(mnum);
	}
	
	//회원포인트리스트 가져오기
	public List<MembersPointVo> getPointList(HashMap<String, Object> map){
		return dao.getPointList(map);
	}
	
	//회원 포인트 총 갯수 가져오기
	public int getRowPointCount(HashMap<String, Object> map) {
		return dao.getRowPointCount(map); 
	}
}
