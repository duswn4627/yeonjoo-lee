package com.jhta.finalproject.yj.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.yj.vo.MembersVO;

@Repository
public class MembersDao {
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE = "com.jhta.yj.mybatis.mapper.MembersMapper";

	// 회원가입
	public int join(MembersVO vo) {
		return session.insert(NAMESPACE + ".join", vo);
	}

	public int idCheck(String mid) {
		return session.selectOne(NAMESPACE + ".idCheck", mid);
	}

	public int emailCheck(String email) {
		return session.selectOne(NAMESPACE + ".emailCheck", email);
	}

	public int memCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".memCount", map);
	}

	public List<MembersVO> memList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".memList", map);
	}

	public int ghostCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".ghostCount", map);
	}

	public List<MembersVO> ghostList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".ghostList", map);
	}

	public MembersVO memInfo(int mnum) {
		return session.selectOne(NAMESPACE + ".memInfo", mnum);
	}

	public MembersVO ghostInfo(int mnum) {
		return session.selectOne(NAMESPACE + ".ghostInfo", mnum);
	}

	// 엑셀 리스트
	public List<MembersVO> excelMemList() {
		return session.selectList(NAMESPACE + ".excelMemList");
	}

	public List<MembersVO> excelGhostList() {
		return session.selectList(NAMESPACE + ".excelGhostList");
	}
}
