package com.jhta.finalproject.jm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jm.dao.SmallcateDao;
import com.jhta.finalproject.jm.vo.SmallcateVo;

@Service
public class SmallcateService {
	@Autowired
	private SmallcateDao dao;
	
	public List<SmallcateVo> list(int bcatenum){
		return dao.list(bcatenum);
	}
}
