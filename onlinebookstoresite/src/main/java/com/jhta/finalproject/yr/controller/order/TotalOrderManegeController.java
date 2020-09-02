package com.jhta.finalproject.yr.controller.order;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.finalproject.yj.vo.PageUtil;
import com.jhta.finalproject.yr.service.PaymentService;
import com.jhta.finalproject.yr.vo.PaymentAndBookListVo;

@Controller
public class TotalOrderManegeController {
	
	@Autowired
	private PaymentService service;
	
	
	@RequestMapping("/totalOrder")
	public String ordersearch(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String pfield, String  pkeyword,
			String tfield, String startDate, String endDate ,String  bfield, String bkeyword, String bstatus, String type, String payType,String mType ) {
		
//		주문번호, 주문자명		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pfield",pfield);
		map.put("pkeyword",pkeyword);
		
//		주문일, 결제일
		
		map.put("tfield",tfield);
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		
//		책제목, 책번호

		map.put("bfield",bfield);
		map.put("bkeyword",bkeyword);

//		주문상태
		String[] bstatusArray = null;
		if(bstatus != null && bstatus != "") {
			bstatusArray = stringToArray(bstatus);
			map.put("bstatus",bstatusArray);			
		}
		
//		cs주문상태
//		refundhistory --- 0 : 없음, 1 :취소, 2: 반품, 3: 교환
		String[] typeArray = null;
		if(type != null && type != "") {
			typeArray = stringToArray(type);
			map.put("type",typeArray);			
		}
		

//		입금상태
		map.put("payType",payType);
		
//		회원타입(mname)
		map.put("mType",mType);
		
//		페이징
		int totalRowCnt = service.getTotalCount(map); // 전체글의 개수
		PageUtil pu = new PageUtil(pageNum, totalRowCnt, 5, 5);

		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		
		//리스트 가져오기
		List<PaymentAndBookListVo> list = service.paymentList(map);
		
		
		model.addAttribute("pu", pu);
		model.addAttribute("list", list);
		model.addAttribute("pfield",pfield);
		model.addAttribute("pkeyword",pkeyword);
		model.addAttribute("tfield",tfield);
		model.addAttribute("startDate",startDate);
		model.addAttribute("endDate",endDate);
		model.addAttribute("bfield",bfield);
		model.addAttribute("bkeyword",bkeyword);
		model.addAttribute("bstatus",bstatusArray);
		model.addAttribute("type",typeArray);
		model.addAttribute("payType",payType);
		model.addAttribute("mType",mType);		
		
		return ".totalOrder";
	}
	
	
//	배열담는 메소드
	public String[] stringToArray(String str) {
		
		String[] array_word; 

		array_word = str.split(","); 
		
		return array_word;
	}
	
}
