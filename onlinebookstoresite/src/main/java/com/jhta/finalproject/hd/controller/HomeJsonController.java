package com.jhta.finalproject.hd.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.hd.service.HomeService;
import com.jhta.finalproject.hd.vo.HomeBestVo;
import com.jhta.page.util.PageUtil;


@Controller
public class HomeJsonController {
	@Autowired
	private HomeService service;
	
	/*
	 해당책상세페이지 갈때
	 /bdetail 로 bnum만 던져주면됨
	 */
	
	//홈화면   베스트셀러
	@RequestMapping(value="/home/bestlist",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String bestlist(HttpSession session,@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		PageUtil pu=new PageUtil(pageNum, 10, 5, 5);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		String path=session.getAttribute("cp")+"/resources/imgUpload";
		List<HomeBestVo> list=service.bestlist(map);
		JSONArray jarr=new JSONArray();
		for(HomeBestVo vo:list) {
			JSONObject json=new JSONObject();
			json.put("bnum", vo.getBnum());
			json.put("btitle", vo.getBtitle());
			String title=vo.getBtitle();
			String viewtitle="";
			if(title.length()>=9) {
				viewtitle=title.substring(0, 9);
				viewtitle+="..";
			}else {
				viewtitle=title;
			}
			json.put("viewtitle", viewtitle);
			json.put("bwriter", vo.getBwriter());
			String writer=vo.getBwriter();
			String viewWriter="";
			if(writer.length()>=10) {
				viewWriter=title.substring(0, 10);
				viewWriter+="..";
			}else {
				viewWriter=writer;
			}
			json.put("viewWriter", viewWriter);
			json.put("bpublisher", vo.getBpublisher());
			json.put("bprice", vo.getBprice());
			String imgpath=path+"\\"+vo.getImgsavefilename();
			json.put("imgsrc",imgpath );

			jarr.put(json);
		}
		return jarr.toString();
	}
	//홈화면 신간
	@RequestMapping(value="/home/newlist",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String newtlist(HttpSession session,@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		PageUtil pu=new PageUtil(pageNum, 10, 5, 5);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		String path=session.getAttribute("cp")+"/resources/imgUpload";
		List<HomeBestVo> list=service.newlist(map);
		JSONArray jarr=new JSONArray();
		for(HomeBestVo vo:list) {
			JSONObject json=new JSONObject();
			json.put("bnum", vo.getBnum());
			json.put("btitle", vo.getBtitle());
			String title=vo.getBtitle();
			String viewtitle="";
			if(title.length()>=8) {
				viewtitle=title.substring(0, 8);
				viewtitle+="..";
			}else {
				viewtitle=title;
			}
			json.put("viewtitle", viewtitle);
			json.put("bwriter", vo.getBwriter());
			String writer=vo.getBwriter();
			String viewWriter="";
			if(writer.length()>=10) {
				viewWriter=title.substring(0, 10);
				viewWriter+="..";
			}else {
				viewWriter=writer;
			}
			json.put("viewWriter", viewWriter);
			json.put("bpublisher", vo.getBpublisher());
			json.put("bprice", vo.getBprice());
			String imgpath=path+"\\"+vo.getImgsavefilename();
			json.put("imgsrc",imgpath );
			jarr.put(json);
		}
		return jarr.toString();
	}
	
	
}
