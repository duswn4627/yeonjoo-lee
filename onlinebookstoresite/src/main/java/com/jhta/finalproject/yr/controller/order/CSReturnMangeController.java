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
import com.jhta.finalproject.yr.service.ReturnService;
import com.jhta.finalproject.yr.vo.CSAndPaymentBookVo;
import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.PaymentAndCSBookListVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Controller
public class CSReturnMangeController {

	@Autowired
	private CSManageService service;	
	@Autowired
	private ReturnService rservice;
	
	//반품 처리 모달창 열기
	@RequestMapping("/cs/returnModal")
	public String openModal(Model model, String bpaynum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bpaynum", bpaynum);
		
		List<PaymentAndCSBookListVo> list = service.paymentList(map);
		int point = 0;
		int count = 0; // 반품처리할 책
		
		for (PaymentAndCSBookListVo vo : list) {
			
			List<CSAndPaymentBookVo> csbook = vo.getCSAndPaymentBook();
			for (CSAndPaymentBookVo csvo : csbook) {
				
				if(csvo.getType() == 2) {
					if(csvo.getBcount() - csvo.getCount() > 0) {
						point += csvo.getPoint()/csvo.getBcount() * (csvo.getBcount() - csvo.getCount());
					}else{
						point += csvo.getPoint();
					}
					count++ ;
				}
			}
		}
		
//		System.out.println("returncount : " + count);
		
		model.addAttribute("count", count);
		model.addAttribute("List", list);
		model.addAttribute("Point", point);
		
		return "/admin/yr/cs/returnModal";
	}
	
	
	//수거완료 눌렸을때
	@RequestMapping("/cs/returnPickup")
	@ResponseBody
	public String changeStatus(@RequestParam(value="paymentbookNum[]") List<Integer> paymentbookNum) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("status",2);
		map.put("paymentbook_num", paymentbookNum);
		
		int n = service.updateStatus(map);
		
		JSONObject json = new JSONObject();
		
		if(n>0) {
			json.put("code", "success");
		}else {
			json.put("code", "error");
		}
		
		return json.toString();
	}
	
	
	//예치금 전달 클릭시
	@RequestMapping("cs/doReturn")
	@ResponseBody
	public String doReturnFuction(String bpaynum, @RequestParam(value="paymentbookNum[]") List<Integer> paymentbookNum, String returnPrice, 
			String point) {
		
		int ibpaynum = Integer.parseInt(bpaynum);
		
		//회원 번호 가져오기
		int mnum = rservice.getMnum(ibpaynum);
		
		
		//포인트 차감, 예치금 증감 시키기, 상태 변화시키기
		PointVo pointVo = new PointVo(mnum, ibpaynum, Integer.parseInt(point)*-1 , null);
		DepositVo depositVo = new DepositVo(0, mnum, ibpaynum, Integer.parseInt(returnPrice), null, 2);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("returnPrice", Integer.parseInt(returnPrice));
		map.put("bpaynum", ibpaynum);
		
		JSONObject json = new JSONObject();
		try {
			int n1 = rservice.updateStatus("3", paymentbookNum,pointVo, depositVo, map);
			
//			System.out.println("결과 : " + n1);
			
			
			if(n1 > 0) {
				json.put("code", "success");			
			}else {
				json.put("code", "error");						
			}
						
		}catch (Exception e) {
			System.out.println(e.getMessage());
			json.put("code", "error");						
			return json.toString();
		}
		
		return json.toString();
	}
	
//	배열담는 메소드
	public String[] stringToArray(String str) {
		
		String[] array_word; 

		array_word = str.split(","); 
				
//		for(int i=0;i<array_word.length;i++) { //출력
//		    System.out.println("배열로  : " + array_word[i]);
//		}
		
		return array_word;
	}
	
	
}