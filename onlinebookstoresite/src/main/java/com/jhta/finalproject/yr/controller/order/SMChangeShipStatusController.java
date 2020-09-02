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

import com.jhta.finalproject.yr.service.PaymentService;
import com.jhta.finalproject.yr.service.ShipManageService;
import com.jhta.finalproject.yr.vo.PaymentAndBookListVo;

@Controller
public class SMChangeShipStatusController {
	@Autowired
	private ShipManageService service;
	
	//배송 상태 바꾸기
	@RequestMapping(value="/ship/changeToShipping")
	@ResponseBody
	public String changeToShipping(@RequestParam(value="bpaynum[]") List<Integer> bpaynum, int bstatus) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bpaynum", bpaynum);
		map.put("bstatus", bstatus);
		int n = service.updateBstatus(map);
		
		JSONObject json = new JSONObject();
		if(n>0) {
			json.put("code","success");			
		}else {
			json.put("code","error");						
		}
		return json.toString();
	}
	
}
