package com.jhta.finalproject.yr.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.finalproject.yj.vo.PageUtil;
import com.jhta.finalproject.yr.service.PaymentService;
import com.jhta.finalproject.yr.service.ShipManageService;
import com.jhta.finalproject.yr.vo.PaymentAndBookListVo;

@Controller
public class ShipMenuController {
	
	@Autowired
	private PaymentService payService;
	@Autowired
	private ShipManageService service;
	
	@RequestMapping("/ship/menu")
	public String goMenu(Model model ,String PageName,String type, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, 
			String pfield, String pkeyword, String tfield, String startDate, String endDate, String bfield, String bkeyword, String mType) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
//		배송 상태 갯수 가져오기
		List<HashMap<String, Object>> countlist = service.getShipCount();
		
		
//		검색하기
		map.put("pfield", pfield);
		map.put("pkeyword", pkeyword);
		map.put("tfield", tfield);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("bfield", bfield);
		map.put("bkeyword", bkeyword);
		map.put("mType", mType);
		
		
		
//		입금전 리스트 가져오기
		map.put("shipStatus", PageName);			

		List<PaymentAndBookListVo> list = new ArrayList<PaymentAndBookListVo>();

		PageUtil pu = new PageUtil();
//		중고책인지 새책인지
		if(type.equals("1")) {
//			페이징
			int totalRowCnt = payService.getTotalCount(map); // 전체글의 개수

			pu = new PageUtil(pageNum, totalRowCnt, 5, 5);

			map.put("startRow", pu.getStartRow());
			map.put("endRow", pu.getEndRow());
			list = payService.paymentList(map);
		}else if(type.equals("2")) {

			int totalRowCnt = payService.getusedBookTotalCount(map); // 전체글의 개수
			pu = new PageUtil(pageNum, totalRowCnt, 5, 5);
			System.out.println("otr : " + totalRowCnt);

			
			map.put("startRow", pu.getStartRow());
			map.put("endRow", pu.getEndRow());
			
			list = payService.usedBookPaymentListt(map);
		}
		
		model.addAttribute("type", type);
		model.addAttribute("countList", countlist);
		model.addAttribute("list", list);
		model.addAttribute("PageName", PageName);
		model.addAttribute("pu", pu);	
		model.addAttribute("list", list);
		model.addAttribute("pfield",pfield);
		model.addAttribute("pkeyword",pkeyword);
		model.addAttribute("tfield",tfield);
		model.addAttribute("startDate",startDate);
		model.addAttribute("endDate",endDate);
		model.addAttribute("bfield",bfield);
		model.addAttribute("bkeyword",bkeyword);
		model.addAttribute("mType",mType);		
		
		
		if(PageName.equals("0")) {
			model.addAttribute("path",0);		
			model.addAttribute("jsp","beforeDepositTables");			
			return ".ship.beforeDeposit";
		}else if(PageName.equals("1")) {
			model.addAttribute("path",1);
			model.addAttribute("jsp","preparingShipTables");			
			return ".ship.preparingShip";
		}else if(PageName.equals("2")) {
			model.addAttribute("path",2);		
			model.addAttribute("jsp","shipInfoTables");			
			return ".ship.shipInfo";
		}else if(PageName.equals("3")) {
			model.addAttribute("jsp","shipInfoTables");			
			model.addAttribute("path",3);		
			return ".ship.shipInfo";		
		}
		
		return "/admin/error";
	}
}
