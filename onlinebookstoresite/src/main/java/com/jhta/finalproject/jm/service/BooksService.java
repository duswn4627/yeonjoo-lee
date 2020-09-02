package com.jhta.finalproject.jm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.finalproject.jm.dao.BooksDao;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BigcateVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ListimgVo;

@Service
public class BooksService {
	@Autowired
	private BooksDao dao;

	public int count(HashMap<String, Object>map) {
		return dao.count(map);
	}
	public int count1(HashMap<String, Object>map) {
		return dao.count1(map);
	}
	public int breviewcount(int bnum) {
		return dao.breviewcount(bnum);
	}
	
	public int sbooklist1count(HashMap<String, Object> map) {
		return dao.sbooklist1count(map);
	}
	public int novelcount(HashMap<String, Object> map) {
		return dao.novelcount(map);
	}
	public int poetrycount(HashMap<String, Object> map) {
		return dao.poetrycount(map);
	}
	
	public int humancount(HashMap<String, Object> map) {
		return dao.humancount(map);
	}
	
	public int economycount(HashMap<String, Object> map) {
		return dao.economycount(map);
	}
	public int selfdevcount(HashMap<String, Object> map) {
		return dao.selfdevcount(map);
	}
	public int historycount(HashMap<String, Object> map) {
		return dao.historycount(map);
	}
	public int jobcount(HashMap<String, Object> map) {
		return dao.jobcount(map);
	}
	public int travelcount(HashMap<String, Object> map) {
		return dao.travelcount(map);
	}
	public int itcount(HashMap<String, Object> map) {
		return dao.itcount(map);
	}
	public int cartooncount(HashMap<String, Object> map) {
		return dao.cartooncount(map);
	}
	public int guitarcount(HashMap<String, Object> map) {
		return dao.guitarcount(map);
	}
	
	
	
	public List<BooksVo> list(HashMap<String, Object> map){
		return dao.list(map);
	}
	public List<AllListVo> bestlist(HashMap<String, Object> map){
		return dao.bestlist(map);
	}
	public List<BigcateVo> list2(){
		return dao.list2();
	}
	public BooksVo detail (int num) {
		return dao.detail(num);
	}

	public int addHit(int num) {
		return dao.addHit(num);
	}
	public int imginfo(int bnum) {
		return dao.imginfo(bnum);
	}
	
	
	public String getsCatename(int scatenum) {
		return dao.getsCatename(scatenum);
	}
	public String getbCatename(int bcatenum) {
		return dao.getbCatename(bcatenum);
	}
	
	
	
	public List<AllListVo> allbooklist(HashMap<String, Object> map){
		return dao.allbooklist(map);
	}
	
	public List<BooksVo> bbooklist(int num) {
		return dao.bbooklist(num);
	}
	public List<BooksVo> sbooklist(int num) {
		return dao.sbooklist(num);
	}
	public List<AllListVo> sbooklist1(HashMap<String,Object> map) {
		return dao.sbooklist1(map);
	}
	public List<AllListVo> newlist(HashMap<String, Object> map){
		return dao.newlist(map);
	}
	
	public List<AllListVo> catenovel(HashMap<String, Object> map){
		return dao.catenovel(map);
	}
	public List<AllListVo> catepoetry(HashMap<String, Object> map){
		return dao.catepoetry(map);
	}
	public List<AllListVo> catehuman(HashMap<String, Object> map){
		return dao.catehuman(map);
	}
	public List<AllListVo> cateeconomy(HashMap<String, Object> map){
		return dao.cateeconomy(map);
	}
	public List<AllListVo> cateselfdev(HashMap<String, Object> map){
		return dao.cateselfdev(map);
	}
	public List<AllListVo> catehistory(HashMap<String, Object> map){
		return dao.catehistory(map);
	}
	public List<AllListVo> catejob(HashMap<String, Object> map){
		return dao.catejob(map);
	}
	public List<AllListVo> catetravel(HashMap<String, Object> map){
		return dao.catetravel(map);
	}
	public List<AllListVo> cateit(HashMap<String, Object> map){
		return dao.cateit(map);
	}
	public List<AllListVo> catecartoon(HashMap<String, Object> map){
		return dao.catecartoon(map);
	}
	public List<AllListVo> categuitar(HashMap<String, Object> map){
		return dao.categuitar(map);
	}

}
