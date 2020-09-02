package com.jhta.finalproject.hd.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.hd.service.OrderManagerService;
import com.jhta.finalproject.hd.vo.refundBookVo;

@Controller
public class OrderManagerController {
	@Autowired
	private OrderManagerService service;
	
	//새상품관련..
	@RequestMapping(value="/order/manage",method = RequestMethod.POST)
	@ResponseBody
	public String orderManage(int bpaynum,int bstatus,String apply,@RequestParam(value="bnum")String[]bnum,HttpSession session) {
		int mnum=0;
		String smnum=(String)session.getAttribute("mnum");
		if(smnum!=null) {
			mnum=Integer.parseInt(smnum);
		}
		try {
			JSONObject json=new JSONObject();
			boolean result=false;
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("bpaynum", bpaynum);
			map.put("mnum", mnum);
			map.put("bstatus", bstatus);
			map.put("apply",apply);
			map.put("bnum", bnum);
			if(bstatus==0) { //주문전체취소할때
				int n=service.orderCancel(map);
				if(n>0) {
					result=true;
				}
			}else {
				List<refundBookVo>list=service.getpaymentbook(map);
				map.put("list",list);
				int n=service.orderapply(map);	
				if(n==1) {
					result=true;
				}
			}
			json.put("result", result);
			return json.toString();
		}catch(Exception e) {
			JSONObject json=new JSONObject();
			boolean result=false;
			json.put("result", result);
			return json.toString();
		}
	}
	//중고상품....
	@RequestMapping(value="/order/usedmanage",method = RequestMethod.POST)
	@ResponseBody
	public String usedorderManage(int bpaynum,int bstatus,String apply,
			int totalprice,int totalvalue,int delfee,HttpSession session) {
		int mnum=0;
		String smnum=(String)session.getAttribute("mnum");
		if(smnum!=null) {
			mnum=Integer.parseInt(smnum);
		}
		try {
			JSONObject json=new JSONObject();
			boolean result=false;
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("bpaynum", bpaynum);
			map.put("mnum", mnum);
			map.put("apply",apply);
			map.put("totalprice", totalprice);
			map.put("totalvalue", totalvalue);
			map.put("delfee",delfee);
			if(apply.equals("confirm")) { //중고제품 구매확정누를때
				service.confirmorder(map);
				result=true;
			}else if(apply.equals("cancel")){
				map.put("bstatus", 0);
				service.cancelUsedorder(map);
				result=true;
			}
			json.put("result", result);
			return json.toString();
		}catch(Exception e) {
			JSONObject json=new JSONObject();
			boolean result=false;
			json.put("result", result);
			return json.toString();
		}
	}
	
	
}
