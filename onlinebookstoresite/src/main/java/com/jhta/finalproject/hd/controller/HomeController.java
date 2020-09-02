package com.jhta.finalproject.hd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 홈에서 보내줘야하는것.
 * 베스트셀러 리스트 / 신간 리스트/ 회원아이디 / 장바구니 리스트.
 */
@Controller
public class HomeController { 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session,HttpServletRequest req) {		
		session.setAttribute("cp", req.getContextPath());
		return ".main";
	}
	
}
