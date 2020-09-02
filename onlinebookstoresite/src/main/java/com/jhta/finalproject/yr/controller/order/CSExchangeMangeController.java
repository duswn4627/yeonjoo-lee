package com.jhta.finalproject.yr.controller.order;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.yr.service.CSManageService;
import com.jhta.finalproject.yr.vo.PaymentAndCSBookListVo;

@Controller
public class CSExchangeMangeController {

	@Autowired
	private CSManageService service;
	
	
	//교환 처리 모달창 열기
	@RequestMapping("/cs/exchangeModal")
	public String openModal(Model model, String bpaynum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bpaynum", bpaynum);
		
		List<PaymentAndCSBookListVo> list = service.paymentList(map);
		
		model.addAttribute("List", list);
		
		return "/admin/yr/cs/exchangeModal";
	}
	
	@RequestMapping("cs/doExchange")
	@ResponseBody
	public String changeExchangeStatus(@RequestParam(value="paymentbookNum[]") List<Integer> paymentbookNum, String level) {

//		System.out.println(paymentbookNum + " : " + level);
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("status", level);
		map.put("paymentbook_num", paymentbookNum);
		
		int n = service.updateStatus(map);
		
		JSONObject json = new JSONObject();
		if(n > 0) {
			json.put("code", "success");			
		}else {
			json.put("code", "error");						
		}
		
		return json.toString();
	}
	

}