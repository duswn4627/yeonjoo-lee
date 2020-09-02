package com.jhta.finalproject.yr.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.yr.service.CSManageService;
import com.jhta.finalproject.yr.service.CancelService;
import com.jhta.finalproject.yr.vo.CSAndPaymentBookVo;
import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.PaymentAndCSBookListVo;
import com.jhta.finalproject.yr.vo.PaymentBooksVo;
import com.jhta.finalproject.yr.vo.PaymentVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Controller
public class CSCancelMangeController {
	
	@Autowired
	private CSManageService service;
	@Autowired
	private CancelService cservice;

	@RequestMapping("/cs/cancelModal")
	public String openCancelModal(Model model, String bpaynum) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bpaynum", bpaynum);
		
		List<PaymentAndCSBookListVo> list = service.getOnePayment(map);
		int point = 0;
		int deposit = 0;
		
		for (PaymentAndCSBookListVo paymentAndCSBookListVo : list) {
			System.out.println(paymentAndCSBookListVo);			
		}
		
		for (PaymentAndCSBookListVo vo : list) {
			
			//책리스트 가져오기
			List<CSAndPaymentBookVo> bookList = vo.getCSAndPaymentBook();
			
			for (CSAndPaymentBookVo blist : bookList) {				
				if(blist.getType() == 1) { //취소한 책일 경우
//					System.out.println("책이름  " + blist.getBtitle());
//					System.out.println("bcount : "+blist.getBcount()); 
					if(blist.getBcount() - blist.getCount() > 0) { //주문한 책 갯수 - 취소한 책 갯수 
						point += blist.getPoint()/blist.getBcount() * (blist.getBcount() - blist.getCount());
						deposit += blist.getBprice();
//						System.out.println("deposit 1 : " + deposit);
					}else{
						point += blist.getPoint(); //포인트 총 구하기
						deposit += blist.getBprice() * blist.getCount(); //줘야할 예치금
//						System.out.println("count : " + blist.getCount());
//						System.out.println("deposit 2 : " + deposit);
					}					
				}
			}
		}
		
//		System.out.println("deposit : " + deposit);
		
		model.addAttribute("List",list);
		model.addAttribute("cancelPoint",point);
		model.addAttribute("cancelPrice",deposit);
		
		return "/admin/yr/cs/cancelModal";
	}
	
	
	@RequestMapping("/cs/cancelapproval")
	@ResponseBody
	public String cancelApproval(String mnum, String bpaynum, String cancelPrice,String cancelPoint) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bpaynum", bpaynum);
		
//		System.out.println("bpaynum : " + bpaynum);
		
		List<PaymentAndCSBookListVo> list = service.paymentList(map);
		
		int imnum = Integer.parseInt(mnum);
		int ibpaynum = Integer.parseInt(bpaynum);
		int icancelPoint = Integer.parseInt(cancelPoint);
		int icancelPrice = Integer.parseInt(cancelPrice);
		
		//list안에 환불한 책 갯수세기(새로운 주문 만들기)
		//책정보
		PaymentVo cancelPayment = new PaymentVo();
		List<PaymentBooksVo> paymentbookList = new ArrayList<PaymentBooksVo>(); //
		List<Integer> paymentbookNumList = new ArrayList<Integer>(); //주문한 책 리스트
		
		for (PaymentAndCSBookListVo vo : list) {
			
			//배송료 계산
			int delfee = 2500;
			if(vo.getOrdermoney()-icancelPrice > 50000) {
				delfee = 0;
			}
			
			cancelPayment = new PaymentVo(0,vo.getBaddr(),vo.getBphone(),0,vo.getBorderdate(),
					null,0,vo.getOrdermoney()-icancelPrice, 0,vo.getMethodpayment(),vo.getReceiver(), delfee, vo.getMnum());
			
			//책리스트 가져오기
			List<CSAndPaymentBookVo> bookList = vo.getCSAndPaymentBook();
			
			for (CSAndPaymentBookVo blist : bookList) {				
				
				paymentbookNumList.add(blist.getPaymentbook_num());

				if(blist.getBcount() - blist.getCount() > 0) { //주문한 책 갯수 - 취소한 책 갯수 
					paymentbookList.add(new PaymentBooksVo(0, 0, 1, blist.getBnum(), blist.getBcount() - blist.getCount(),blist.getPoint()/blist.getBcount() ));				
				}else if(blist.getType() != 1) { //취소하지 않은 책
					paymentbookList.add(new PaymentBooksVo(0, 0, 1, blist.getBnum(), blist.getBcount(), blist.getPoint()));
				}
			}
		}

//		System.out.println(" 예치금 : " + cancelPrice + " ,포인트  : "+ cancelPoint );
		
		PointVo pointVo = new PointVo(imnum, ibpaynum, icancelPoint*-1, null);
		DepositVo dvo = new DepositVo(0, imnum, ibpaynum, icancelPrice, null, 1);
		JSONObject json = new JSONObject();
		
		try {
			if(!paymentbookList.isEmpty() && cancelPayment != null) {
				//새로운 주문 insert
				int n = cservice.makeCancelPayment(cancelPayment, paymentbookList);
			}
			
			//refundhistory랑 원래 주문 상태 update
			int n = cservice.updateStatus(Integer.parseInt(bpaynum), paymentbookNumList, dvo , pointVo);
			
			if(n > 0) {
				json.put("code", "success");			
			}else {
				json.put("code", "error");						
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			json.put("code", "error");						
			return json.toString();
		}

		return json.toString();
	}
}
