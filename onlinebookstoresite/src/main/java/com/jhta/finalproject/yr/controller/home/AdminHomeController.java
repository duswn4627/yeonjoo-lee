package com.jhta.finalproject.yr.controller.home;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.finalproject.yj.service.QnaService;
import com.jhta.finalproject.yr.service.CSManageService;
import com.jhta.finalproject.yr.service.PaymentService;
import com.jhta.finalproject.yr.service.SalesService;
import com.jhta.finalproject.yr.vo.MethodPaymentInfoVo;

@Controller
public class AdminHomeController {

	@Autowired
	private CSManageService csservice;
	@Autowired
	private PaymentService pservice;
	@Autowired
	private SalesService sservice;
	@Autowired
	private QnaService qnaservice;

	@RequestMapping("/adminmain")
	public String goHome(Model model) {
		
		//오늘 들어온 CS주문 갯수 
		int cscount = csservice.getTodayCSCount();
		//오늘 들어온  주문 갯수 
		int ordercount = pservice.getTodayOrderCount();
		//오늘 들어온  결제 갯수 
		int paymentcount = pservice.getTodayPaymentCount();
		//오늘 들어온  미답변 갯수 
		int qnacount = qnaservice.unAnswerCount();
		List<MethodPaymentInfoVo> mivo = sservice.getThreeDayMethodpaymentInfo();
		List<String> days = getThreeDate();
		
		//3일 결제수단별 건수, 금액 결과 리스트에 담기
		List<HashMap<String, Object>> threedayResult = new ArrayList<HashMap<String, Object>>();

		
		//카드
		for (int j = 0; j < days.size(); j++) {
			
			String day = days.get(j);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("m"+day, new MethodPaymentInfoVo(null, 0, 0, 0));
			
			for (MethodPaymentInfoVo methodPaymentInfoVo : mivo) {
				if(methodPaymentInfoVo.getMethodpayment() == 0) {
					if (methodPaymentInfoVo.getBpayment().equals(day)) {
						map.put("m"+day, methodPaymentInfoVo);
					}				
				}
			}
			
			threedayResult.add(map);
		}

		//무통장
		for (int j = 0; j < days.size(); j++) {
			
			String day = days.get(j);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("c"+day, new MethodPaymentInfoVo(null, 0, 1, 0));
			
			for (MethodPaymentInfoVo methodPaymentInfoVo : mivo) {
				if(methodPaymentInfoVo.getMethodpayment() == 1) {
					if (methodPaymentInfoVo.getBpayment().equals(day)) {
						map.put("c"+day, methodPaymentInfoVo);
					}				
				}
			}
			
			threedayResult.add(map);
		}

		model.addAttribute("cscount", cscount);
		model.addAttribute("ordercount", ordercount);
		model.addAttribute("paymentcount", paymentcount);
		model.addAttribute("qnacount", qnacount);
		model.addAttribute("threedayResult", threedayResult);
		model.addAttribute("days", days);

		return ".adminmain";
	}
	
	//최근 3일 날짜
	public List<String> getThreeDate() {

		List<String> result = new ArrayList<String>();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		result.add(df.format(cal.getTime()));

		for (int i = 1; i <= 2; i++) {
			cal.add(Calendar.DATE, -1);
			result.add(df.format(cal.getTime()));
		}

		return result;
	}

}
