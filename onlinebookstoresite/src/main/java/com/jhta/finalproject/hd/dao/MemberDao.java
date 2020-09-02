package com.jhta.finalproject.hd.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.hd.vo.LoginCheckVo;
import com.jhta.finalproject.hd.vo.MemberinfoVo;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE="mybatis.mapper.MemberMapper";
	
	public LoginCheckVo membercheck(HashMap<String, Object>map) {
		return sqlsession.selectOne(NAMESPACE+".memberCheck", map);
	}
	
	// 탈퇴시 조건체크 dao 
	public int ordercheck(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".ordercheck", mnum);
	}
	public int depositapplycheck(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".depositapplycheck",mnum);
	}
	public List<Integer> depositcheck(int mnum){
		return sqlsession.selectList(NAMESPACE+".depositcheck",mnum);
	}
	public int obsellercheck(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".obsellercheck",mnum);
	}
	public int obcheck(int snum) {
		return sqlsession.selectOne(NAMESPACE+".obcheck", snum);
	}
	
	//탈퇴처리 dao
	public int leavemember(int mnum) {
		return sqlsession.update(NAMESPACE+".leavemember",mnum);
	}
	//회원정보
	public MemberinfoVo memberinfo(int mnum) {
		return sqlsession.selectOne(NAMESPACE+".memberinfo", mnum);
	}
	
	public int updatephone(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".changephone", map);
	}
	public int updatepwd(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".changepwd", map);
	}
	public int updateEmail(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".changeEmail", map);
	}
	public int updateaddr(HashMap<String, Object>map) {
		return sqlsession.update(NAMESPACE+".changeaddr", map);
	}
	
}
