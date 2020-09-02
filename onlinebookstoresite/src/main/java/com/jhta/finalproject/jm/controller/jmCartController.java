package com.jhta.finalproject.jm.controller;

import java.util.HashMap;

import javax.naming.PartialResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.jm.service.jmCartService;
import com.jhta.finalproject.jm.vo.CartVo;

@Controller
public class jmCartController {
	@Autowired private jmCartService cart_service;
	@RequestMapping("/cart/insert")
	@ResponseBody
	public String insertCart(HttpSession session, int bnum, int bcount) {
		String smnum=(String)session.getAttribute("mnum");
		if(smnum == null) {
			smnum = "0";
		}
		CartVo vo=new CartVo();
		vo.setBnum(bnum);
		vo.setBcount(bcount);
		int mnum=Integer.parseInt(smnum);
		if (mnum == 0) {
			return "fail";
		}
		vo.setMnum(mnum);
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		System.out.println("======"+bnum);
		System.out.println("======"+mnum);
		map.put("bnum", bnum);
		map.put("btype", 1); //1이 새책
		map.put("mnum", mnum);
		int nvl = cart_service.cartselect(map);

		if(nvl == 1) {
			return "already";
		}
		
		int n=cart_service.cartinsert(vo);
		if(n>0) {
			return "success";
		}else {
			return "fail";
		}
	}

}
