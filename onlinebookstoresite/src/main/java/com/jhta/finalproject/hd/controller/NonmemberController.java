package com.jhta.finalproject.hd.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.hd.service.NonmemberService;
import com.jhta.finalproject.hd.service.OrderHistoryService;
import com.jhta.finalproject.hd.vo.HistoryDetailBookListVo;
import com.jhta.finalproject.hd.vo.HistoryDetailInfoVo;
import com.jhta.finalproject.hd.vo.VbankVo;

@Controller
public class NonmemberController {
	@Autowired
	private OrderHistoryService ohservice;
	@Autowired
	private NonmemberService service;
	
	@RequestMapping(value="/nomem/inquiryorder",method=RequestMethod.POST)
	@ResponseBody
	public String inquiryorder(int bpaynum,String phone) {
		HashMap<String, Object>map=new HashMap<String, Object>();
		map.put("bpaynum", bpaynum);
		map.put("phone", phone);
		int n=service.confirmbpayment(map);
		String result="";
		JSONObject json=new JSONObject();
		if(n==0) {
			result="nothing";
			json.put("result", result);
			return json.toString();
		}
		HashMap<String, Object>resultmap=service.nomenOrder(map);
		int bstatus=((BigDecimal)resultmap.get("BSTATUS")).intValue();
		int btype=((BigDecimal)resultmap.get("BTYPE")).intValue();
		if(bstatus==4) {
			result="applycancel";
			json.put("result", result);
			return json.toString();
		}else if(bstatus==5) {
			result="confirmcancel";
			json.put("result", result);
			return json.toString();
		}else if(bstatus==6) {
			result="cancelorder";
			json.put("result", result);
			return json.toString();
		}else {
			result="success";
		}
		json.put("btype", btype);
		json.put("bpaynum", bpaynum);
		json.put("result", result);
		return json.toString();
	}
	
	@RequestMapping(value="/orderhistory/useddetailview1",method = RequestMethod.POST)
	public String useddetailvew(int bpaynum,Model model) {
		int totalprice=0;
		int totalpoint=0;
		//책리스트
		List<HistoryDetailBookListVo>blist=ohservice.usedorderbooklist(bpaynum);
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
		HistoryDetailInfoVo ivo=ohservice.orderinfo(bpaynum);
	
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
			VbankVo vbvo=ohservice.vbank_info(bpaynum);
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
	@RequestMapping(value="/orderhistory/detailview1",method=RequestMethod.POST)
	public String detailvew(int bpaynum,Model model) {
		int totalprice=0;
		int totalpoint=0;
		//책리스트
		List<HistoryDetailBookListVo>blist=ohservice.orderbooklist(bpaynum);
		for(HistoryDetailBookListVo bvo:blist) {
			int bcount=bvo.getBcount();
			int bprice=bvo.getBprice();
			int totalvalue=bcount*bprice;
			totalprice+=totalvalue;
			bvo.setTotalvalue(totalvalue);
			int point=bvo.getPoint();
			totalpoint+=point;
		}
		HistoryDetailInfoVo ivo=ohservice.orderinfo(bpaynum);
	
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
			VbankVo vbvo=ohservice.vbank_info(bpaynum);
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
}
