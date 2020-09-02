package com.jhta.finalproject.hd.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.hd.service.MyPageService;
import com.jhta.finalproject.hd.service.OrderHistoryService;
import com.jhta.finalproject.hd.vo.AccountHistoryVo;
import com.jhta.finalproject.hd.vo.AccountVo;
import com.jhta.finalproject.hd.vo.DepositHistoryVo;
import com.jhta.finalproject.hd.vo.HistoryListVo;
import com.jhta.finalproject.hd.vo.QnaAnswerVo;
import com.jhta.finalproject.hd.vo.QnaHistoryVo;

@Controller
public class MyPageController {
	@Autowired
	private MyPageService service;
	@Autowired
	private OrderHistoryService orderservice;
	
	//메인페이지 상단 장바구니에 들어있는 상품갯수 구할때
	@RequestMapping("/mypage/countcart")
	@ResponseBody
	public String countcart(HttpSession session) {
		String smnum=(String)session.getAttribute("mnum");
		int mnum=0;
		JSONObject json=new JSONObject();
		boolean result=false;
		if(smnum!=null) {
			mnum=Integer.parseInt(smnum);
		}else {
			json.put("result", result);
			return json.toString();
		}
		int n=service.countcart(mnum);
		
		result=true;
		json.put("count", n);
		json.put("result", result);
		return json.toString();
	}
	@RequestMapping("/mypage/accountpage")
	public String accountPage() {
		return ".accountPage";
	}
	
	
	//마이페이지 메인갈때 사용..
	@RequestMapping("/mypage/main")
	public String conMyPage(HttpSession session,Model model) {
		String smnum=(String)session.getAttribute("mnum");
		int mnum=Integer.parseInt(smnum);
		//최근주문리스트 
		List<HistoryListVo>list=service.recentorder(mnum);
		for(HistoryListVo vo:list) {
			String statusStr="";
			int bstatus=vo.getBstatus();
			if(bstatus==0) {
				statusStr="주문";
			}else if(bstatus==1) {
				statusStr="결제완료";
			}else if(bstatus==2) {
				statusStr="배송중";
			}else if(bstatus==3) {
				statusStr="구매확정";
			}
			vo.setStatusStr(statusStr);
			int bpaynum=vo.getOrdernum();
			int btype=vo.getBtype(); 		
			if(btype==1) {
				HashMap<String,Object>map=orderservice.confirmtype(bpaynum);		
				int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));	
				int count=orderservice.countPaymentBook(bpaynum);
				String btitle=orderservice.newBtitle(bnum);
				String ordername=btitle;
				if(count>1) {
					ordername+=" 외 "+(count-1)+"종";
				}
				vo.setOrdername(ordername);			
			}else {
				HashMap<String,Object>map=orderservice.confirmtype(bpaynum);		
				int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));
				int count=service.countPaymentBook(bpaynum);
				HashMap<String,Object> usedmap=service.usedBtitle(bnum);
				String btitle=(String)usedmap.get("OBNAME");
				int status=Integer.parseInt(String.valueOf(usedmap.get("OBSTATUS")));
				String statusString="";
				if(status==1) {
					statusString="[중고-최상]";
				}else if(status==2) {
					statusString="[중고-상]";
				}else if(status==3) {
					statusString="[중고-중]";
				}else if(status==4) {
					statusString="[중고-하]";
				}
				String ordername=statusString+" "+btitle;
				if(count>1) {
					ordername+=" 외 "+(count-1)+"종";
				}
				vo.setOrdername(ordername);
			}
		}
		model.addAttribute("orderlist",list);
		
		//최근취소내역
		List<HistoryListVo>cancellist=service.recentcancel(mnum);
		for(HistoryListVo vo:cancellist) {
			String statusStr="";
			int bstatus=vo.getBstatus();
			if(bstatus==6) {
				statusStr="취소";
			}
			vo.setStatusStr(statusStr);
			int bpaynum=vo.getOrdernum();
			int btype=vo.getBtype(); 
			if(btype==1) {
				HashMap<String,Object>map=orderservice.confirmtype(bpaynum);		
				int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));	
				int count=orderservice.countPaymentBook(bpaynum);
				String btitle=orderservice.newBtitle(bnum);
				String ordername=btitle;
				if(count>1) {
					ordername+=" 외 "+(count-1)+"종";
				}
				vo.setOrdername(ordername);			
			}else {
				HashMap<String,Object>map=orderservice.confirmtype(bpaynum);		
				int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));
				int count=service.countPaymentBook(bpaynum);
				HashMap<String,Object> usedmap=service.usedBtitle(bnum);
				String btitle=(String)usedmap.get("OBNAME");
				int status=Integer.parseInt(String.valueOf(usedmap.get("OBSTATUS")));
				String statusString="";
				if(status==1) {
					statusString="[중고-최상]";
				}else if(status==2) {
					statusString="[중고-상]";
				}else if(status==3) {
					statusString="[중고-중]";
				}else if(status==4) {
					statusString="[중고-하]";
				}
				String ordername=statusString+" "+btitle;
				if(count>1) {
					ordername+=" 외 "+(count-1)+"종";
				}
				vo.setOrdername(ordername);
			}
		}
		model.addAttribute("cancellist",cancellist);
		
		//최근문의내역.
		List<QnaHistoryVo> qnalist=service.recentQna(mnum);
		for(QnaHistoryVo vo:qnalist) {
			String status="";
			int qnastatus=vo.getQnastatus();
			if(qnastatus==0) {
				status="처리중";
			}else {
				status="완료";
			}
			vo.setStatusStr(status);
		}
		model.addAttribute("qnalist", qnalist);
		
		
		
		
		return ".mypage";
	}
	@RequestMapping("/mypage/cancelhistorypage")
	public String cancelHistorypage() {
		return ".cancelhistory";
	}
	@RequestMapping("/mypage/qnapage")
	public String qnapage() {
		return ".qnahistory";
	}
	@RequestMapping("/mypage/returnpage")
	public String returnPage() {
		return ".returnhistory";
	}
	
	@RequestMapping("/mypage/qnadetail")
	public String qnadetail(int qnanum,HttpSession session,Model model) {
		String smnum=(String)session.getAttribute("mnum");
		int mnum=Integer.parseInt(smnum);
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("mnum", mnum);
		map.put("qnanum", qnanum);
		QnaHistoryVo vo=service.qnadetail(map);
		int qnastatus=vo.getQnastatus();
		String status="";
		if(qnastatus==0) {
			status="처리중";
		}else {
			status="완료";
		}			
		vo.setStatusStr(status);
		if(vo.getQnastatus()==1) { //답변있을경우.
			QnaAnswerVo avo=service.qnaAnswer(qnanum);
			model.addAttribute("avo",avo);
		}
		model.addAttribute("qvo",vo);
		return ".qnadetail";
	}
	
	//새상품 취소내역.
	@RequestMapping(value="/mypage/cancelhistory",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String cancelhistory(HttpSession session,@RequestParam(required=false)String startDay,String value,
			@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
		String smnum=(String)session.getAttribute("mnum");
		int mnum=Integer.parseInt(smnum);
		HashMap<String,Object>datemap=new HashMap<String, Object>();
		datemap.put("startDay", startDay);
		datemap.put("endDay",endDay);
		datemap.put("mnum",mnum);
		datemap.put("separate", "new");
		int totalcount=service.countHistory(datemap);
		PageUtil pu=new PageUtil(pageNum, totalcount, 8, 5);
		datemap.put("startRow", pu.getStartRow());
		datemap.put("endRow", pu.getEndRow());
		List<HistoryListVo> list=service.orderhistory(datemap);
		for(HistoryListVo vo:list) {
			int bpaynum=vo.getOrdernum();
			HashMap<String,Object>map=service.confirmtype(bpaynum);		
			int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));		
			int bfinalmoney=vo.getBfinalmoney();
			int delfee=vo.getDelfee();
			vo.setOrdermoney(bfinalmoney+delfee);
			int count=service.countPaymentBook(bpaynum);
			String btitle=service.newBtitle(bnum);
			String ordername=btitle;
			if(count>1) {
				ordername+=" 외 "+(count-1)+"종";
			}
			vo.setOrdername(ordername);			
		}
		JSONArray jarr=new JSONArray();
		for(HistoryListVo vo1:list) {
			JSONObject json=new JSONObject();
			json.put("ordernum", vo1.getOrdernum());
			json.put("borderdate", vo1.getBorderdate());
			String status="";
			int bstatus=vo1.getBstatus();
			if(bstatus==6) {
				status="취소";
			}else if(bstatus==4) {
				status="반품신청";
			}else if(bstatus==5) {
				status="반품완료";
			}
			
			json.put("bstatus", bstatus);
			json.put("status", status);
			json.put("ordermoney", vo1.getOrdermoney());
			json.put("ordername", vo1.getOrdername());
			jarr.put(json);
		}
		JSONObject json=new JSONObject();
		json.put("value", value);
		json.put("startDay", startDay);
		json.put("endDay", endDay);
		json.put("pageNum", pu.getPageNum());
		json.put("totalPageCount", pu.getTotalPageCount());
		json.put("startPageNum", pu.getStartPageNum());
		if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
			pu.setEndPageNum(pu.getTotalPageCount());
		}
		json.put("endPageNum", pu.getEndPageNum());
		
		jarr.put(json);
		return jarr.toString();
	}
	//중고상품 취소내역
		@RequestMapping(value="/mypage/usedcancelhistory",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String viewusedorderhistroy(HttpSession session,@RequestParam(required=false)String startDay,String value,
				@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String,Object>datemap=new HashMap<String, Object>();
			datemap.put("startDay", startDay);
			datemap.put("endDay",endDay);
			datemap.put("mnum",mnum);
			datemap.put("value",value);
			datemap.put("separate","used");
			int totalcount=service.countHistory(datemap);
			PageUtil pu=new PageUtil(pageNum, totalcount, 8, 5);
			datemap.put("startRow", pu.getStartRow());
			datemap.put("endRow", pu.getEndRow());
			List<HistoryListVo> list=service.orderhistory(datemap);
			for(HistoryListVo vo:list) {
				int bpaynum=vo.getOrdernum();
				HashMap<String,Object>map=service.confirmtype(bpaynum);		
				int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));
				int bfinalmoney=vo.getBfinalmoney();
				int delfee=vo.getDelfee();
				vo.setOrdermoney(bfinalmoney+delfee);
				int count=service.countPaymentBook(bpaynum);
				HashMap<String,Object> usedmap=service.usedBtitle(bnum);
				String btitle=(String)usedmap.get("OBNAME");
				int status=Integer.parseInt(String.valueOf(usedmap.get("OBSTATUS")));
				String statusString="";
				if(status==1) {
					statusString="[중고-최상]";
				}else if(status==2) {
					statusString="[중고-상]";
				}else if(status==3) {
					statusString="[중고-중]";
				}else if(status==4) {
					statusString="[중고-하]";
				}
				String ordername=statusString+" "+btitle;
				if(count>1) {
					ordername+=" 외 "+(count-1)+"종";
				}
				vo.setOrdername(ordername);
							
			}
			JSONArray jarr=new JSONArray();
			for(HistoryListVo vo1:list) {
				JSONObject json=new JSONObject();
				json.put("ordernum", vo1.getOrdernum());
				json.put("borderdate", vo1.getBorderdate());
				String status="";
				int bstatus=vo1.getBstatus();
				if(bstatus==6) {
					status="취소";
				}else if(bstatus==4) {
					status="반품신청";
				}else if(bstatus==5) {
					status="반품완료";
				}
				
				json.put("bstatus", bstatus);
				json.put("status", status);
				json.put("ordermoney", vo1.getOrdermoney());
				json.put("ordername", vo1.getOrdername());
				jarr.put(json);
			}
			JSONObject json=new JSONObject();
			json.put("value", value);
			json.put("startDay", startDay);
			json.put("endDay", endDay);
			json.put("pageNum", pu.getPageNum());
			json.put("totalPageCount", pu.getTotalPageCount());
			json.put("startPageNum", pu.getStartPageNum());
			if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
				pu.setEndPageNum(pu.getTotalPageCount());
			}
			json.put("endPageNum", pu.getEndPageNum());
			
			jarr.put(json);
			return jarr.toString();
		}
		//문의사항
		@RequestMapping(value="/mypage/qnahistory",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String viewQnaList(HttpSession session,@RequestParam(required=false)String startDay,String value,
				@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String,Object>datemap=new HashMap<String, Object>();
			datemap.put("startDay", startDay);
			datemap.put("endDay",endDay);
			datemap.put("mnum",mnum);
			datemap.put("value",value);
			int totalcount=service.countQnaHistory(datemap);
			PageUtil pu=new PageUtil(pageNum, totalcount, 8, 5);
			datemap.put("startRow", pu.getStartRow());
			datemap.put("endRow", pu.getEndRow());
			List<QnaHistoryVo> list=service.qnahistory(datemap);
			JSONArray jarr=new JSONArray();
			for(QnaHistoryVo vo:list) {
				JSONObject json=new JSONObject();
				json.put("qnanum", vo.getQnanum());
				json.put("qnadate", vo.getQnadate());
				String status="";
				int qnastatus=vo.getQnastatus();
				if(qnastatus==0) {
					status="처리중";
				}else {
					status="완료";
				}				
				json.put("qnastatus", qnastatus);
				json.put("status", status);
				json.put("qnatitle", vo.getQnatitle());
				json.put("qnacontent", vo.getQnacontent());
				jarr.put(json);
			}
			JSONObject json=new JSONObject();
			json.put("value", value);
			json.put("startDay", startDay);
			json.put("endDay", endDay);
			json.put("pageNum", pu.getPageNum());
			json.put("totalPageCount", pu.getTotalPageCount());
			json.put("startPageNum", pu.getStartPageNum());
			if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
				pu.setEndPageNum(pu.getTotalPageCount());
			}
			json.put("endPageNum", pu.getEndPageNum());
			
			jarr.put(json);
			return jarr.toString();
		}
		//반품/취소내역
		@RequestMapping(value="/mypage/newReturnhistory",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String viewNewReturnhistroy(HttpSession session,@RequestParam(required=false)String startDay,String value,
				@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String,Object>datemap=new HashMap<String, Object>();
			datemap.put("startDay", startDay);
			datemap.put("endDay",endDay);
			datemap.put("mnum",mnum);
			datemap.put("separate", "new");
			datemap.put("value",value);
			int totalcount=service.countHistory(datemap);
			PageUtil pu=new PageUtil(pageNum, totalcount, 8, 5);
			datemap.put("startRow", pu.getStartRow());
			datemap.put("endRow", pu.getEndRow());
			List<HistoryListVo> list=service.orderhistory(datemap);
			for(HistoryListVo vo:list) {
				int bpaynum=vo.getOrdernum();
				HashMap<String,Object>map=service.confirmtype(bpaynum);		
				int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));		
				int bfinalmoney=vo.getBfinalmoney();
				int delfee=vo.getDelfee();
				vo.setOrdermoney(bfinalmoney+delfee);
				int count=service.countPaymentBook(bpaynum);
				String btitle=service.newBtitle(bnum);
				String ordername=btitle;
				if(count>1) {
					ordername+=" 외 "+(count-1)+"종";
				}
				vo.setOrdername(ordername);			
			}
			JSONArray jarr=new JSONArray();
			for(HistoryListVo vo1:list) {
				JSONObject json=new JSONObject();
				json.put("ordernum", vo1.getOrdernum());
				json.put("borderdate", vo1.getBorderdate());
				String status="";
				int bstatus=vo1.getBstatus();
				if(bstatus==6) {
					status="취소";
				}else if(bstatus==4) {
					status="반품/교환신청";
				}else if(bstatus==5) {
					status="처리완료";
				}
				
				json.put("bstatus", bstatus);
				json.put("status", status);
				json.put("ordermoney", vo1.getOrdermoney());
				json.put("ordername", vo1.getOrdername());
				jarr.put(json);
			}
			JSONObject json=new JSONObject();
			json.put("value", value);
			json.put("startDay", startDay);
			json.put("endDay", endDay);
			json.put("pageNum", pu.getPageNum());
			json.put("totalPageCount", pu.getTotalPageCount());
			json.put("startPageNum", pu.getStartPageNum());
			if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
				pu.setEndPageNum(pu.getTotalPageCount());
			}
			json.put("endPageNum", pu.getEndPageNum());
			
			jarr.put(json);
			return jarr.toString();
		}
		//반품내역
		@RequestMapping(value="/mypage/usedReturnhistory",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String viewUsedReturnhistroy(HttpSession session,@RequestParam(required=false)String startDay,String value,
				@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String,Object>datemap=new HashMap<String, Object>();
			datemap.put("startDay", startDay);
			datemap.put("endDay",endDay);
			datemap.put("mnum",mnum);
			datemap.put("separate", "new");
			datemap.put("value",value);
			int totalcount=service.countHistory(datemap);
			PageUtil pu=new PageUtil(pageNum, totalcount, 8, 5);
			datemap.put("startRow", pu.getStartRow());
			datemap.put("endRow", pu.getEndRow());
			List<HistoryListVo> list=service.orderhistory(datemap);
			for(HistoryListVo vo:list) {
				int bpaynum=vo.getOrdernum();
				HashMap<String,Object>map=service.confirmtype(bpaynum);		
				int bnum=Integer.parseInt(String.valueOf(map.get("BNUM")));		
				int bfinalmoney=vo.getBfinalmoney();
				int delfee=vo.getDelfee();
				vo.setOrdermoney(bfinalmoney+delfee);
				int count=service.countPaymentBook(bpaynum);
				String btitle=service.newBtitle(bnum);
				String ordername=btitle;
				if(count>1) {
					ordername+=" 외 "+(count-1)+"종";
				}
				vo.setOrdername(ordername);			
			}
			JSONArray jarr=new JSONArray();
			for(HistoryListVo vo1:list) {
				JSONObject json=new JSONObject();
				json.put("ordernum", vo1.getOrdernum());
				json.put("borderdate", vo1.getBorderdate());
				String status="";
				int bstatus=vo1.getBstatus();
				if(bstatus==6) {
					status="취소";
				}else if(bstatus==4) {
					status="반품/교환신청";
				}else if(bstatus==5) {
					status="처리완료";
				}
				
				json.put("bstatus", bstatus);
				json.put("status", status);
				json.put("ordermoney", vo1.getOrdermoney());
				json.put("ordername", vo1.getOrdername());
				jarr.put(json);
			}
			JSONObject json=new JSONObject();
			json.put("value", value);
			json.put("startDay", startDay);
			json.put("endDay", endDay);
			json.put("pageNum", pu.getPageNum());
			json.put("totalPageCount", pu.getTotalPageCount());
			json.put("startPageNum", pu.getStartPageNum());
			if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
				pu.setEndPageNum(pu.getTotalPageCount());
			}
			json.put("endPageNum", pu.getEndPageNum());
			
			jarr.put(json);
			return jarr.toString();
		}
		
		//문의사항 작성 컨트롤러
		@RequestMapping(value="/mypage/writeqna",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String writeqna(String qnatitle,String qnacontent,HttpSession session) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("qnatitle", qnatitle);
			map.put("mnum", mnum);
			map.put("qnacontent", qnacontent);
			int n=service.qnawrite(map);
			boolean result=false;
			if(n>0) {
				result=true;
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();
		}
		
		//예치금내역페이지.
		@RequestMapping(value="/mypage/depositpage")
		public String depositpage() {
			return ".depositpage";
		}
		@RequestMapping(value="/mypage/deposithistory",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String deposithistory(HttpSession session,@RequestParam(required=false)String startDay,String value,
				@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String,Object>datemap=new HashMap<String, Object>();
			datemap.put("startDay", startDay);
			datemap.put("endDay",endDay);
			datemap.put("mnum",mnum);
			datemap.put("value",value);
			//value-> all : 전체  , sellmoney -> 판매대금 (0) 주문취소(1) 반품/환불처리(2) 계좌인출(3)
			int totalcount=service.countDeposithistory(datemap);
			PageUtil pu=new PageUtil(pageNum, totalcount, 8, 5);
			datemap.put("startRow", pu.getStartRow());
			datemap.put("endRow", pu.getEndRow());
			List<DepositHistoryVo> list=service.deposithistory(datemap);
			JSONArray jarr=new JSONArray();
			int total_deposit=0;
			for(DepositHistoryVo vo:list) {
				total_deposit+=vo.getDtran();
				JSONObject json=new JSONObject();
				json.put("dnum", vo.getDnum());
				json.put("mnum", vo.getMnum());
				json.put("dtran", vo.getDtran());
				json.put("trandate", vo.getTrandate());
				int status=vo.getDereason();
				String statusStr="";
				if(status==0) {
					statusStr="판매대금";
				}else if(status==1) {
					statusStr="주문취소";
				}else if(status==2) {
					statusStr="반품/환불";
				}else if(status==3) {
					statusStr="인출완료";
				}else if(status==4) {
					statusStr="인출신청";
				}
				json.put("status", statusStr);
				jarr.put(json);
			}
			JSONObject json=new JSONObject();
			json.put("total_deposit", total_deposit);
			json.put("value", value);
			json.put("startDay", startDay);
			json.put("endDay", endDay);
			json.put("pageNum", pu.getPageNum());
			json.put("totalPageCount", pu.getTotalPageCount());
			json.put("startPageNum", pu.getStartPageNum());
			if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
				pu.setEndPageNum(pu.getTotalPageCount());
			}
			json.put("endPageNum", pu.getEndPageNum());
			jarr.put(json);
			return jarr.toString();
		}
		@RequestMapping(value="/mypage/confirmaccount",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String confirmaccount(HttpSession session) {
			JSONObject json=new JSONObject();
			int mnum=0;
			String smnum=(String)session.getAttribute("mnum");
			if(smnum!=null) {
				mnum=Integer.parseInt(smnum);
			}
			String result="";
			if(mnum==0) {
				result="loginerr";
				json.put("result", result);
				return json.toString();
			}
			int n=service.confirmacount(mnum);
			if(n>0) {
				result="confirm";
				AccountVo vo=service.selectAccount(mnum);
				json.put("bank", vo.getBank());
				json.put("banknum", vo.getAccount());
				
			}else {
				result="accounterr";
			}
			json.put("result", result);
			return json.toString();	
		}
		@RequestMapping(value="/mypage/insertAccount",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String insertAccount(HttpSession session,String bank,int banknum) {
			JSONObject json=new JSONObject();
			String smnum=(String)session.getAttribute("mnum");
			boolean result=false;
			if(smnum==null) {
				json.put("result", result);
				return json.toString();
			}
			int mnum=Integer.parseInt(smnum);
			HashMap<String, Object>datamap=new HashMap<String, Object>();
			datamap.put("mnum", mnum);
			datamap.put("bank", bank);
			datamap.put("banknum", banknum);
			int n=service.insertAccount(datamap);
			if(n>0) {
				result=true;
			}
			json.put("result", result);
			return json.toString();
		}
		@RequestMapping(value="/mypage/applydeposit",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String applydeposit(HttpSession session,int deposit) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			AccountVo vo=service.selectAccount(mnum);
			int anum=vo.getAnum();
			HashMap<String, Object>datamap=new HashMap<String, Object>();
			datamap.put("mnum", mnum);
			datamap.put("anum", anum);
			datamap.put("reqmoney", deposit);
			int n=0;
			try {
				n=service.applydeposit(datamap);
				boolean result=false;
				if(n>0) {
					result=true;
				}
				JSONObject json=new JSONObject();
				json.put("result", result);
				return json.toString();
			}catch(Exception e) {
				JSONObject json=new JSONObject();
				json.put("result", false);
				return json.toString();
			}
			
		}
		// 계좌인출내역페이지 계좌정보출력 
		@RequestMapping(value="/mypage/myaccount",method=RequestMethod.POST,produces="application/json;charset=utf-8")
		@ResponseBody
		public String myaccount(HttpSession session) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			AccountVo vo=service.selectAccount(mnum);
			JSONObject json=new JSONObject();
			json.put("anum", vo.getAnum());
			json.put("bank", vo.getBank());
			json.put("account",vo.getAccount());
			return json.toString();
		}
		
		// 계좌인출내역페이지 리스트출력
		@RequestMapping(value="/mypage/accounthistory",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String accounthistory(HttpSession session,@RequestParam(required=false)String startDay,String value,
				@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
			String smnum=(String)session.getAttribute("mnum");
			
			int mnum=Integer.parseInt(smnum);
			AccountVo vo1=service.selectAccount(mnum);
			int anum=vo1.getAnum();
			HashMap<String,Object>datamap=new HashMap<String, Object>();
			datamap.put("startDay", startDay);
			datamap.put("endDay",endDay);
			datamap.put("mnum",mnum);
			datamap.put("value",value); 
			datamap.put("anum",anum);
			//apply -> 0 처리중  confirm-> 1 처리완료
			int totalcount=service.countAccount(datamap);
			PageUtil pu=new PageUtil(pageNum, totalcount, 8, 5);
			datamap.put("startRow", pu.getStartRow());
			datamap.put("endRow", pu.getEndRow());
			List<AccountHistoryVo> list=service.accounthistory(datamap);
			JSONArray jarr=new JSONArray();
			for(AccountHistoryVo vo:list) {
				JSONObject json=new JSONObject();
				int status=vo.getSestatus();
				String statusStr="";
				int senum=vo.getSenum();
				int reqmoney=vo.getReqmoney();
				Date appdate=vo.getAppdate();
				Date comdate=vo.getComdate();
				json.put("comdate", comdate);
				if(comdate==null) {
					json.put("comdate", "");
				}
				json.put("senum", senum);
				json.put("reqmoney", reqmoney);
				json.put("appdate", appdate);
				
				if(status==0) {
					statusStr="처리신청";
				}else if(status==1) {
					statusStr="처리완료";
				}
				json.put("status", statusStr);
				jarr.put(json);
			}
			JSONObject json=new JSONObject();
			json.put("value", value);
			json.put("startDay", startDay);
			json.put("endDay", endDay);
			json.put("pageNum", pu.getPageNum());
			json.put("totalPageCount", pu.getTotalPageCount());
			json.put("startPageNum", pu.getStartPageNum());
			if(pu.getEndPageNum()>=pu.getTotalPageCount()) {
				pu.setEndPageNum(pu.getTotalPageCount());
			}
			json.put("endPageNum", pu.getEndPageNum());
			jarr.put(json);
			return jarr.toString();
		}
		//등록된 계좌 바꾸는 ajax 컨트롤러
		@RequestMapping(value="/mypage/updateAccount",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String updateAccount(HttpSession session,String bank,int banknum,int anum) {
			JSONObject json=new JSONObject();
			String smnum=(String)session.getAttribute("mnum");
			boolean result=false;
			if(smnum==null) {
				json.put("result", result);
				return json.toString();
			}
			int mnum=Integer.parseInt(smnum);
			HashMap<String, Object>datamap=new HashMap<String, Object>();
			datamap.put("mnum", mnum);
			datamap.put("bank", bank);
			datamap.put("anum", anum);
			datamap.put("banknum", banknum);
			int n=service.updateAccount(datamap);
			if(n>0) {
				result=true;
			}
			json.put("result", result);
			return json.toString();
		}
		
		
		
}
