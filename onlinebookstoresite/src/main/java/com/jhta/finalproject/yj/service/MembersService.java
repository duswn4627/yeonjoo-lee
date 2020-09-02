package com.jhta.finalproject.yj.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.yj.dao.MembersDao;
import com.jhta.finalproject.yj.vo.MembersVO;

@Service
public class MembersService {
	@Autowired
	private MembersDao dao;

	public int join(MembersVO vo) {
		return dao.join(vo);
	}

	public int idCheck(String mid) {
		return dao.idCheck(mid);
	}

	public int emailCheck(String email) {
		return dao.emailCheck(email);
	}

	public int memCount(HashMap<String, Object> map) {
		return dao.memCount(map);
	}

	public List<MembersVO> memList(HashMap<String, Object> map) {
		return dao.memList(map);
	}

	public int ghostCount(HashMap<String, Object> map) {
		return dao.ghostCount(map);
	}

	public List<MembersVO> ghostList(HashMap<String, Object> map) {
		return dao.ghostList(map);
	}

	public MembersVO memInfo(int mnum) {
		return dao.memInfo(mnum);
	}

	public MembersVO ghostInfo(int mnum) {
		return dao.ghostInfo(mnum);
	}

	// 엑셀
	public List<MembersVO> excelMemList() {
		return dao.excelMemList();
	}

	public List<MembersVO> excelGhostList() {
		return dao.excelGhostList();
	}
}
