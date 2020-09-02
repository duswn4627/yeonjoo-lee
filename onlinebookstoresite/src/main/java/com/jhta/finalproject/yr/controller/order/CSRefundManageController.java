package com.jhta.finalproject.yr.controller.order;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.yr.service.RefundService;
import com.jhta.finalproject.yr.service.ReturnService;

@Controller
public class CSRefundManageController {
	
	@Autowired
	private RefundService rfservcie;
	
	
	@RequestMapping("/cs/refundMoneyGoMembers")
	@ResponseBody
	public String refundMoneyGoMembers( @RequestParam(value="senum[]") List<Integer> senum,
			@RequestParam(value="mnum[]") List<Integer> mnum,
			@RequestParam(value="priceArr[]") List<Integer> priceArr) {
			
		//settlement, Deposit 상태 바꾸기(상태, 정산 완료날짜)
		int n = 0;
		try {
			n = rfservcie.updateSestausAndUpdateDeposit(senum, mnum, priceArr);			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		JSONObject json = new JSONObject();
		if(n > 0) {
			json.put("code", "success");
		}else {
			json.put("code", "error");			
		}

		return json.toString();
	}
}