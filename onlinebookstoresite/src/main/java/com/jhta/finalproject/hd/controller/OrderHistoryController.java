package com.jhta.finalproject.hd.controller;

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

import com.jhta.finalproject.hd.service.OrderHistoryService;
import com.jhta.finalproject.hd.vo.HistoryDetailBookListVo;
import com.jhta.finalproject.hd.vo.HistoryDetailInfoVo;
import com.jhta.finalproject.hd.vo.HistoryListVo;
import com.jhta.finalproject.hd.vo.VbankVo;

@Controller
public class OrderHistoryController {
	@Autowired
	private OrderHistoryService service;

	
	//주문내역페이지로 이동
	@RequestMapping("/mypage/orderhistory")
	public String pageorderhistory() {
		return ".orderhistory";
	}
	//새상품 주문내역 보기.
	@RequestMapping(value="/orderhistroy/newview",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String vieworderhistroy(HttpSession session,@RequestParam(required=false)String startDay,String value,
											@RequestParam(required = false)String endDay,@RequestParam(defaultValue = "1")int pageNum) {
		String smnum=(String)session.getAttribute("mnum");
		int mnum=Integer.parseInt(smnum);
		HashMap<String,Object>datemap=new HashMap<String, Object>();
		datemap.put("startDay", startDay);
		datemap.put("endDay",endDay);
		datemap.put("mnum",mnum);
		datemap.put("value",value);
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
			if(bstatus==0) {
				status="주문";
			}else if(bstatus==1) {
				status="결제완료";
			}else if(bstatus==2) {
				status="배송중";
			}else if(bstatus==3) {
				status="구매확정";
			}else if(bstatus==4) {
				status="반품신청";
			}else if(bstatus==5) {
				status="반품완료";
			}
			
			json.put("bstatus", bstatus);
			json.put("status", status);
			json.put("ordermoney", vo1.getOrdermoney());
			json.put("mname", vo1.getMname());
			json.put("receiver", vo1.getReceiver());
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
	//중고제품 주문내역
	@RequestMapping(value="/orderhistroy/usedview",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
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
			if(bstatus==0) {
				status="주문";
			}else if(bstatus==1) {
				status="결제완료";
			}else if(bstatus==2) {
				status="배송중";
			}else if(bstatus==3) {
				status="수령완료(구매확정)";
			}else if(bstatus==4) {
				status="반품신청";
			}else if(bstatus==5) {
				status="반품완료";
			}
			
			json.put("bstatus", bstatus);
			json.put("status", status);
			json.put("ordermoney", vo1.getOrdermoney());
			json.put("mname", vo1.getMname());
			json.put("receiver", vo1.getReceiver());
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
	
	//새상품 주문상세정보 페이지.
	@RequestMapping(value="/orderhistory/detailview")
	public String detailvew(int bpaynum,Model model) {
		int totalprice=0;
		int totalpoint=0;
		//책리스트
		List<HistoryDetailBookListVo>blist=service.orderbooklist(bpaynum);
		for(HistoryDetailBookListVo bvo:blist) {
			int bcount=bvo.getBcount();
			int bprice=bvo.getBprice();
			int totalvalue=bcount*bprice;
			totalprice+=totalvalue;
			bvo.setTotalvalue(totalvalue);
			int point=bvo.getPoint();
			totalpoint+=point;
		}
		HistoryDetailInfoVo ivo=service.orderinfo(bpaynum);
	
		String addr=ivo.getBaddr();
		String [] addrGroup=addr.split("\\|");
		String addr1=addrGroup[0]; //우편번호
		String addr2=addrGroup[1]; // 도로명주소
		String addr3=addrGroup[2]; // 지번주소
		String addr4=addrGroup[3]; // 상세주소
		String addr5=addrGroup[4]; // 참고주소
		String jibunaddr="("+addr1+") "+addr3+" "+addr5+" "+addr4;
		String roadaddr="("+addr1+") "+addr2+" "+addr5+" "+addr4;
		
		int method=ivo.getMethodpayment();
		if(method==1) {
			VbankVo vbvo=service.vbank_info(bpaynum);
			model.addAttribute("vbvo",vbvo);
		}
		model.addAttribute("jibunaddr", jibunaddr);
		model.addAttribute("roadaddr", roadaddr);
		model.addAttribute("blist",blist);
		model.addAttribute("ivo",ivo);
		model.addAttribute("totalprice",totalprice);
		model.addAttribute("totalpoint", totalpoint);
		return ".orderdetail";
	}
	//중고상품 주문상세정보 페이지.
		@RequestMapping(value="/orderhistory/useddetailview")
		public String useddetailvew(int bpaynum,Model model) {
			int totalprice=0;
			int totalpoint=0;
			//책리스트
			List<HistoryDetailBookListVo>blist=service.usedorderbooklist(bpaynum);
			for(HistoryDetailBookListVo bvo:blist) {
				int bcount=bvo.getBcount();
				int bprice=bvo.getBprice();
				int totalvalue=bcount*bprice;
				totalprice+=totalvalue;
				bvo.setTotalvalue(totalvalue);
				int status=bvo.getObstatus();
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
				bvo.setStatusString(statusString);
			}
			HistoryDetailInfoVo ivo=service.orderinfo(bpaynum);
		
			String addr=ivo.getBaddr();
			String [] addrGroup=addr.split("\\|");
			String addr1=addrGroup[0]; //우편번호
			String addr2=addrGroup[1]; // 도로명주소
			String addr3=addrGroup[2]; // 지번주소
			String addr4=addrGroup[3]; // 상세주소
			String addr5=addrGroup[4]; // 참고주소
			String jibunaddr="("+addr1+") "+addr3+" "+addr5+" "+addr4;
			String roadaddr="("+addr1+") "+addr2+" "+addr5+" "+addr4;
			
			int method=ivo.getMethodpayment();
			if(method==1) {
				VbankVo vbvo=service.vbank_info(bpaynum);
				model.addAttribute("vbvo",vbvo);
			}
			model.addAttribute("jibunaddr", jibunaddr);
			model.addAttribute("roadaddr", roadaddr);
			model.addAttribute("blist",blist);
			model.addAttribute("ivo",ivo);
			model.addAttribute("totalprice",totalprice);
			model.addAttribute("totalpoint", totalpoint);
			return ".usedorderdetail";
		}
}
