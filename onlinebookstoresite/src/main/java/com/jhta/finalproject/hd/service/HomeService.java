package com.jhta.finalproject.hd.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.hd.dao.HomeDao;
import com.jhta.finalproject.hd.vo.HomeBestVo;



@Service
public class HomeService {
	@Autowired
	private HomeDao dao;
	
	//홈화면 베스트셀러 10개 리스트.
	public List<HomeBestVo> bestlist(HashMap<String, Object> map){
		return dao.bestlist(map);
	}
	public List<HomeBestVo> newlist(HashMap<String, Object> map){
		return dao.newlist(map);
	}
}
