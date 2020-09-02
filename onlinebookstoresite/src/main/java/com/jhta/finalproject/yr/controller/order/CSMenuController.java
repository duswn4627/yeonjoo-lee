package com.jhta.finalproject.yr.controller.order;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.finalproject.yj.vo.PageUtil;
import com.jhta.finalproject.yr.service.CSManageService;
import com.jhta.finalproject.yr.service.DepositService;
import com.jhta.finalproject.yr.vo.PaymentAndCSBookListVo;
import com.jhta.finalproject.yr.vo.SettlementJoinVo;

@Controller
public class CSMenuController {
	
	@Autowired	
	private CSManageService service;
	@Autowired
	private DepositService dservice;

	
	
	@RequestMapping("/cs/menu")
	public String goCSMenu(Model model, String PageName,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, 
			String pfield, String  pkeyword,String tfield, String startDate, String endDate ,String  bfield, String bkeyword,
			String status,String mType ) {
		
		
		//상단 cs 갯수 상황판
		List<HashMap<String, Object>> CSCount = service.getCSCount();
		
		//검색
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		String CSStatus = PageName; 
		
		map.put("CSStatus", CSStatus);
		
//		주문번호, 주문자명
		map.put("pfield",pfield);
		map.put("pkeyword",pkeyword);
		
//		신청일, 주문일
		
		map.put("tfield",tfield);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		
		
//		책제목, 책번호

		map.put("bfield",bfield);
		map.put("bkeyword",bkeyword);
		
//		주문상태
		if(status != null && status != "") {
			String[] statusArray = stringToArray(status);
			map.put("bstatus",statusArray);			
		}
		
		
//		회원타입(mname)
		map.put("mType",mType);
		
		PageUtil pu = new PageUtil();
		
		
		if(!PageName.equals("4") && !PageName.equals("5") && !PageName.equals("6")) {
			
			int totalRowCnt = service.getTotalCount(map); // 전체글의 개수
			
//			System.out.println("tr : " + totalRowCnt);
			
			pu = new PageUtil(pageNum, totalRowCnt, 5, 5);

			map.put("startRow", pu.getStartRow());
			map.put("endRow", pu.getEndRow());
			
			
			List<PaymentAndCSBookListVo> list = service.paymentList(map);
			model.addAttribute("list", list);
			
		}else {
						
			if(PageName.equals("5")) {
				int sestatus = 0;
				map.put("sestatus",sestatus);

			}else if(PageName.equals("6")) {
				int sestatus = 1;				
				map.put("sestatus",sestatus);
			}
			
			int totalRowCnt = dservice.getCount(map); // 전체글의 개수
			
//			System.out.println("dtr : " + totalRowCnt);
			
			pu = new PageUtil(pageNum, totalRowCnt, 5, 5);

			map.put("startRow", pu.getStartRow());
			map.put("endRow", pu.getEndRow());
			
			List<SettlementJoinVo> list= dservice.getSettlementList(map);
			
			model.addAttribute("list", list);	
		}
		
		
		model.addAttribute("pu", pu);		
		model.addAttribute("countList", CSCount);		
		model.addAttribute("pfield",pfield);
		model.addAttribute("pkeyword",pkeyword);
		model.addAttribute("tfield",tfield);
		model.addAttribute("startDate",startDate);
		model.addAttribute("endDate",endDate);
		model.addAttribute("bfield",bfield);
		model.addAttribute("bkeyword",bkeyword);
		model.addAttribute("status",status);
		model.addAttribute("mType",mType);	
		model.addAttribute("PageName",PageName);	
		
		if(PageName.equals("1")) { //취소
			model.addAttribute("checked","tab1");
			model.addAttribute("path",1);		
			return ".cs.cancel";
		}else if(PageName.equals("2")) { //반품
			model.addAttribute("path",2);		
			return ".cs.return";
		}else if(PageName.equals("3")) { //교환
			model.addAttribute("path",3);		
			return ".cs.exchange";		
		}else if(PageName.equals("4")) { //환불
			model.addAttribute("checked","tab1");
			model.addAttribute("path",4);		
			return ".cs.refund";		
		}else if(PageName.equals("5")) { //환불
			model.addAttribute("checked","tab2");
			model.addAttribute("path",5);		
			return ".cs.refund";		
		}else if(PageName.equals("6")) { //환불
			model.addAttribute("checked","tab3");
			model.addAttribute("path",6);		
			return ".cs.refund";		
		}
		
		return "/admin/error";
	}
	
//	배열담는 메소드
	public String[] stringToArray(String str) {
		
		String[] array_word; 

		array_word = str.split(","); 

		return array_word;
	}
	
}
