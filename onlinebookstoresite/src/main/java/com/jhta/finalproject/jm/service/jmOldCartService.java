package com.jhta.finalproject.jm.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jm.dao.jmCartDao;
import com.jhta.finalproject.jm.dao.jmOldCartDao;
import com.jhta.finalproject.jm.vo.CartVo;
import com.jhta.finalproject.jm.vo.OldCartVo;

@Service
public class jmOldCartService {
	@Autowired private jmOldCartDao dao;
	
	public int oldcartinsert(OldCartVo vo) {
		return dao.oldcartinsert(vo);
	}
	public int oldcartselect(HashMap<String, Object> map) {
		return dao.oldcartselect(map);
	}
}
