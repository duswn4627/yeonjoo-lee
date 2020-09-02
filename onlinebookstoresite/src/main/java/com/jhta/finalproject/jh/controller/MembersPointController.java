package com.jhta.finalproject.jh.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.jh.service.MembersPointService;
import com.jhta.finalproject.jh.vo.MembersPointVo;
import com.jhta.page.util.PageUtil;

@Controller
public class MembersPointController {
	@Autowired
	private MembersPointService service;
	
	//포인트내역조회
	@RequestMapping("/members/pointList")
	public String showPointList() {
		return ".point";
	}
	
	//포인트내역조회
	@RequestMapping(value="/members/point",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String membersPoint(HttpSession session,Model model,
			@RequestParam(required=false)String startDay,
			@RequestParam(required = false)String endDay,
			@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		int mnum=Integer.parseInt((String)session.getAttribute("mnum"));//회원번호
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("startDay",startDay);
		map.put("endDay",endDay);
		map.put("mnum",mnum);
		int totalRowCount=service.getRowPointCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 3);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<MembersPointVo> list=service.getPointList(map);
		JSONArray jarr=new JSONArray();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		for(MembersPointVo vo: list) {
			JSONObject json=new JSONObject();
			json.put("no",vo.getBpaynum());
			json.put("mnum", vo.getMnum());
			json.put("bpaynum", vo.getBpaynum());
			if(vo.getTranpoint()>0) {
				json.put("pointContent", "포인트(+)");
				json.put("leftTranpoint", "");
				json.put("rightTranpoint", vo.getTranpoint()+"원");
			}else if(vo.getTranpoint()<0) {
				json.put("pointContent", "포인트(-)");
				json.put("leftTranpoint", vo.getTranpoint()+"원");
				json.put("rightTranpoint", "");
			}
			json.put("pregdate", format.format(vo.getPregdate()));
			jarr.put(json);
		}
		JSONObject json=new JSONObject();
		json.put("startDay", startDay);
		json.put("endDay", endDay);
		json.put("pageNum", pu.getPageNum());
		json.put("totalRowCount", pu.getTotalRowCount());
		json.put("totalPageCount", pu.getTotalPageCount());
		json.put("startPageNum", pu.getStartPageNum());
		if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
			pu.setEndPageNum(pu.getTotalPageCount());
		}
		json.put("endPageNum", pu.getEndPageNum());
		jarr.put(json);
		return jarr.toString();
	}
}
