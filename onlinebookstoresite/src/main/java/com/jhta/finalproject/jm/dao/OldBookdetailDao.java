package com.jhta.finalproject.jm.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jh.vo.SellerQnaListJoinVo;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.BreviewVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ObQnaInsertVo;
import com.jhta.finalproject.jm.vo.OldAllListVo;
import com.jhta.finalproject.jm.vo.ReviewinsertVo;


@Repository
public class OldBookdetailDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.OldBooksMapper";
	
	public List<OldAllListVo> bookdetail(int obnum){
		return sqlSession.selectList(NAMESPACE + ".bookdetail",obnum);
	}
	public int addHit(int obnum) {
		return sqlSession.update(NAMESPACE + ".hit",obnum);
	}
	public List<BreviewVo> reviewlist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".reviewlist",map);
	}
	public int breviewcount(int obnum) {
		return sqlSession.selectOne(NAMESPACE + ".breviewcount",obnum);
	}
	public ImgVo imginfo(int obnum) {
		return sqlSession.selectOne(NAMESPACE + ".imginfo",obnum);
	}
	
	public int obqnainsert(ObQnaInsertVo vo) {
		return sqlSession.insert(NAMESPACE + ".obqnainsert",vo);
	}
	public int obqnadelete(int obqnum) {
		return sqlSession.delete(NAMESPACE + ".obqnadelete",obqnum);
	}
	
	public List<SellerQnaListJoinVo> obqna(int obnum){
		return sqlSession.selectList(NAMESPACE + ".getSellerQnaList",obnum);
	}
	public int obqnacount(int snum) {
		return sqlSession.selectOne(NAMESPACE + ".getSellerQnaCount",snum);
	}
}
