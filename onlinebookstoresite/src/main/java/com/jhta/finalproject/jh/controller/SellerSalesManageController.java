package com.jhta.finalproject.jh.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.TotalDigitsFacet;
import com.jhta.finalproject.jh.service.SellerSalesManagementService;
import com.jhta.finalproject.jh.vo.SellerFeepayJoinVo;
import com.jhta.finalproject.jh.vo.SellerSalesJoinVo;
import com.jhta.page.util.PageUtil;

@Controller
public class SellerSalesManageController {
	@Autowired
	private SellerSalesManagementService service;
	/*
bpayment bstatus
0:주문
1:결제완료
2:배송중
3:수령완료(구매확정)
4:환불
	 * */
	//판매관리 메소드(입금대기중)
	@RequestMapping("/seller/salesManagement")
	public String salesManage(
			Model model,HttpSession session,
			@RequestParam(value="tabType",defaultValue = "1")int tabType,
			@RequestParam(value="borderdate1",defaultValue = "1")int borderdate1,
			String keyword1,
			String startDay,
			String endDay,
			String field1,
			@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		int snum=(Integer)session.getAttribute("snum");//중고판매자번호
		int bstatus=tabType-1; //주문,입금전
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("snum", snum);
		map.put("bstatus",bstatus);
		map.put("borderdate1",borderdate1);
		map.put("startDay",startDay);
		map.put("endDay",endDay);
		map.put("field1",field1);
		map.put("keyword1", keyword1);
		int totRowCount=service.getTotRowCount(map);//전체 행의 갯수
		PageUtil pu=new PageUtil(pageNum, totRowCount, 5, 3);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		List<SellerSalesJoinVo> list1=service.getSalesList(map);
		model.addAttribute("list1", list1);
		model.addAttribute("tabType", tabType);
		model.addAttribute("pu", pu);
		model.addAttribute("map", map);
		return ".seller.salesManagement";
	}
	
	
	//판매관리 메소드(입금완료)
	@RequestMapping("/seller/salesManagement2")
	public String salesManage2(
			Model model,HttpSession session,
			@RequestParam(value="tabType",defaultValue = "2")int tabType,
			@RequestParam(value="bpaydate2",defaultValue = "1")int bpaydate2,
			String keyword2,
			String startDay2,
			String endDay2,
			String field2,
			@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		int snum=(Integer)session.getAttribute("snum"); //중고판매자번호
		int bstatus=tabType-1; //결제완료
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("snum", snum);
		map.put("bstatus",bstatus);
		map.put("bpaydate2",bpaydate2);
		map.put("startDay2",startDay2);
		map.put("endDay2",endDay2);
		map.put("field2",field2);
		map.put("keyword2", keyword2);
		int totRowCount=service.getTotRowCount(map);
		PageUtil pu=new PageUtil(pageNum, totRowCount, 5, 3);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		List<SellerSalesJoinVo> list2=service.getSalesList(map);
		model.addAttribute("list2", list2);
		model.addAttribute("tabType", tabType);
		model.addAttribute("pu", pu);
		model.addAttribute("map", map);
		return ".seller.salesManagement";
	}
	
	//출고처리 메소드
	@RequestMapping("/seller/salesManagement2/shipping")
	public String sellerShipping(int bpaynum,Model model) {
		service.goShipping(bpaynum);
		model.addAttribute("tabType", 2);
		return "redirect:/seller/salesManagement2";
	}
	
	//판매관리 메소드(배송중/구매확정전)
	@RequestMapping("/seller/salesManagement3")
	public String salesManage3(
			Model model,HttpSession session,
			@RequestParam(value="tabType",defaultValue = "3")int tabType,
			@RequestParam(value="bpaydate3",defaultValue = "1")int bpaydate3,
			String keyword3,
			String startDay3,
			String endDay3,
			String field3,
			@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		int snum=(Integer)session.getAttribute("snum"); //중고판매자번호
		int bstatus=tabType-1; //결제완료
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("snum", snum);
		map.put("bstatus",bstatus);
		map.put("bpaydate3",bpaydate3);
		map.put("startDay3",startDay3);
		map.put("endDay3",endDay3);
		map.put("field3",field3);
		map.put("keyword3", keyword3);
		int totRowCount=service.getTotRowCount(map);
		PageUtil pu=new PageUtil(pageNum, totRowCount, 5, 3);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		List<SellerSalesJoinVo> list3=service.getSalesList(map);
		model.addAttribute("list3", list3);
		model.addAttribute("tabType", tabType);
		model.addAttribute("pu", pu);
		model.addAttribute("map", map);
		return ".seller.salesManagement";
	}
	//판매관리 메소드(구매확정완료/정산처리전)
	@RequestMapping("/seller/salesManagement4")
	public String salesManage4(
			Model model,HttpSession session,
			@RequestParam(value="tabType",defaultValue = "4")int tabType,
			@RequestParam(value="bpaydate4",defaultValue = "1")int bpaydate4,
			String keyword4,
			String startDay4,
			String endDay4,
			String field4,
			@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		int snum=(Integer)session.getAttribute("snum"); //중고판매자번호
		int bstatus=tabType-1; //결제완료
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("snum", snum);
		map.put("bstatus",bstatus);
		map.put("bpaydate4",bpaydate4);
		map.put("startDay4",startDay4);
		map.put("endDay4",endDay4);
		map.put("field4",field4);
		map.put("keyword4", keyword4);
		int totRowCount=service.getFeeTotRowCount(map);//전체 행의 갯수 구하기
		PageUtil pu=new PageUtil(pageNum, totRowCount, 5, 3);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		List<SellerFeepayJoinVo> list4=service.getfeeList(map);
		model.addAttribute("list4", list4);
		model.addAttribute("tabType", tabType);
		model.addAttribute("pu", pu);
		model.addAttribute("map", map);
		return ".seller.salesManagement";
	}
}
