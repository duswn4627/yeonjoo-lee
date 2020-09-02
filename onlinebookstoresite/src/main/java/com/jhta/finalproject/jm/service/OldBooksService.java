package com.jhta.finalproject.jm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jm.dao.OldBooksDao;
import com.jhta.finalproject.jm.vo.BigcateVo;
import com.jhta.finalproject.jm.vo.OldAllListVo;
@Service
public class OldBooksService {
	@Autowired
	private OldBooksDao dao;
	
	public int oldallcount(HashMap<String, Object>map) {
		return dao.oldallcount(map);
	}
	public List<OldAllListVo> oldalllist(HashMap<String, Object> map){
		return dao.oldalllist(map);
	}
	public List<BigcateVo> bcatelist(){
		return dao.bigcate();
	}
	public List<OldAllListVo> oldsclist(HashMap<String, Object> map){
		return dao.oldsclist(map);
	}
	public int oldsccount(HashMap<String, Object> map) {
		return dao.oldsccount(map);
	}
	
	
	public String getosCatename(int scatenum) {
		return dao.getosCatename(scatenum);
	}
	public String getobCatename(int bcatenum) {
		return dao.getobCatename(bcatenum);
	}
	
}
