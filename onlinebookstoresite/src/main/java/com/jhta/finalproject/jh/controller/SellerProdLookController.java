package com.jhta.finalproject.jh.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.finalproject.jh.service.SellerProdLookService;
import com.jhta.finalproject.jh.vo.SellerOldbooksVo;
import com.jhta.page.util.PageUtil;

@Controller
public class SellerProdLookController {
	@Autowired 
	private SellerProdLookService service;
	
	//========================중고상품 조회/수정페이지로 이동========================
	@RequestMapping("/seller/prodLook")
	public String sellerProdLook(Model model,HttpServletRequest req,HttpSession session,
			@RequestParam(value="pageNum",defaultValue = "1")int pageNum, //페이지번호
			@RequestParam(value="obsalestatus",defaultValue = "4")int obsalestatus, //판매상태
			String field,
			String keyword,
			String startDay, //시작일
			String endDay, //종료일
			@RequestParam(value="regdate",defaultValue = "0")int regdate) {
		int snum=(Integer)session.getAttribute("snum");//중고판매자번호
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("snum", snum);//판매자번호
		map.put("obsalestatus",obsalestatus);
		map.put("regdate", regdate);
		map.put("startDay",startDay);
		map.put("endDay",endDay);
		map.put("field",field);
		map.put("keyword",keyword);
		int totalRowCount=service.oldbookPageCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5,3);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		List<SellerOldbooksVo> list=service.allList(map);
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		model.addAttribute("map", map);
		
		return ".seller.prodLook";
	}
}
