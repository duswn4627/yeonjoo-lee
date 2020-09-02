package com.jhta.finalproject.jm.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.jm.service.SmallcateService;
import com.jhta.finalproject.jm.vo.SmallcateVo;

@Controller
public class SmallcateController {
	@Autowired
	private SmallcateService service;
	
	
	
	@RequestMapping(value="sclist",produces="application/json;charset=utf-8")
	@ResponseBody
	public String list(int bcatenum) {
		
		System.out.println(bcatenum);
//		
//		List<SmallcateVo> vo=service.list(bcatenum);
//		System.out.println(vo.get(0).getScataname());
//		mv.addObject("vo",vo);
//		mv.setViewName("slist");
		
		List<SmallcateVo> list=service.list(bcatenum);
		
		JSONArray arr=new JSONArray();
		
		for(SmallcateVo vo: list) {
			JSONObject json=new JSONObject();
			json.put("scatenum", vo.getScatenum());
			json.put("bcatenum", vo.getBcatenum());
			json.put("scataname", vo.getScataname());
			arr.put(json);
		}
		
		return arr.toString();
	}
}
