package com.jhta.finalproject.jm.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BigcateVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ListimgVo;

@Repository
public class BooksDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="com.jhta.mybatis.mapper.BooksMapper";
	
	public int count(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".count",map);
	}
	public int count1(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".count1",map);
	}
	public int breviewcount(int bnum) {
		return sqlSession.selectOne(NAMESPACE + ".breviewcount",bnum);
	}
	
	public int sbooklist1count(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".sbooklist1count",map);
	}
	public int novelcount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".novelcount",map);
	}
	public int poetrycount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".poetrycount",map);
	}
	public int humancount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".humancount",map);
	}
	public int economycount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".economycount",map);
	}
	public int selfdevcount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".selfdevcount",map);
	}
	public int historycount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".historycount",map);
	}
	public int jobcount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".jobcount",map);
	}
	public int travelcount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".travelcount",map);
	}
	public int itcount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".itcount",map);
	}
	public int cartooncount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".cartooncount",map);
	}
	public int guitarcount(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".guitarcount",map);
	}
	
	
	public List<BooksVo> list(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".list",map);
	}
	public List<AllListVo> bestlist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".bestlist",map);
	}
	public List<BigcateVo> list2(){
		return sqlSession.selectList(NAMESPACE + ".bcatelist");
	}
	
	
	public BooksVo detail(int num) {
		return sqlSession.selectOne(NAMESPACE + ".detail",num);
	}
	public int addHit(int num) {
		return sqlSession.update(NAMESPACE + ".hit",num);
	}
	public int imginfo(int bnum) {
		return sqlSession.selectOne(NAMESPACE + ".imginfo",bnum);
	}
	
	
	public String getsCatename(int scatenum) {
		return sqlSession.selectOne(NAMESPACE + ".getsCatename",scatenum);
	}
	public String getbCatename(int bcatenum) {
		return sqlSession.selectOne(NAMESPACE + ".getbCatename",bcatenum);
	}
	
	
	
	public List<AllListVo> allbooklist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".allbooklist",map);
	}
	
	public List<BooksVo> bbooklist(int num) {
		return sqlSession.selectList(NAMESPACE + ".bbooklist",num);
	}
	public List<BooksVo> sbooklist(int num) {
		return sqlSession.selectList(NAMESPACE + ".sbooklist",num);
	}
	public List<AllListVo> sbooklist1(HashMap<String,Object> map) {
		return sqlSession.selectList(NAMESPACE + ".sbooklist1",map);
	}
	
	public List<AllListVo> newlist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".newlist",map);
	}
	
	public List<AllListVo> catenovel(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".catenovel",map);
	}
	public List<AllListVo> catepoetry(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".catepoetry",map);
	}
	public List<AllListVo> catehuman(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".catehuman",map);
	}
	public List<AllListVo> cateeconomy(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".cateeconomy",map);
	}
	public List<AllListVo> cateselfdev(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".cateselfdev",map);
	}
	public List<AllListVo> catehistory(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".catehistory",map);
	}
	public List<AllListVo> catejob(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".catejob",map);
	}
	public List<AllListVo> catetravel(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".catetravel",map);
	}
	public List<AllListVo> cateit(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".cateit",map);
	}
	public List<AllListVo> catecartoon(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".catecartoon",map);
	}
	public List<AllListVo> categuitar(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE + ".categuitar",map);
	}
}
