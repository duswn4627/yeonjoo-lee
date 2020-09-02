package com.jhta.finalproject.hd.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.hd.service.OrderService;
import com.jhta.finalproject.hd.vo.OrderCompleteListVo;
import com.jhta.finalproject.hd.vo.OrderCompleteResultVo;
import com.jhta.finalproject.hd.vo.OrderCompleteUsedListVo;
import com.jhta.finalproject.hd.vo.OrderListResultVo;
import com.jhta.finalproject.hd.vo.ShipmentInfoVo;
import com.jhta.finalproject.hd.vo.UsedOrderListVo;
import com.jhta.finalproject.hd.vo.VbankVo;

@Controller
public class OrderController {
	@Autowired
	private OrderService service;
	//================== 중고상품 주문 컨트롤러 시작 =========================//
	//장바구니에서 주문하기 클릭했을때
	@RequestMapping(value="/order/usedorder",method= RequestMethod.POST)
	public String usedorder(@RequestParam(value="cartNum")int[]cartNum,Model model,HttpSession session) {
		ArrayList<Integer> data=new ArrayList<Integer>(Arrays.stream(cartNum).boxed().collect(Collectors.toList()));
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("datalist", data);
		List<UsedOrderListVo> list=service.usedorderlist(map);
		String path=session.getAttribute("cp")+"/resources/jh/jhobupload";
		int totalprice=0;
		HashMap<String, Object> shipmap=new HashMap<String, Object>();
		for(UsedOrderListVo vo:list) {
			// 중고판매자마자 배송비 결정 //
			if(shipmap.get(vo.getSid())==null) {
				shipmap.put(vo.getSid(),vo.getObdelfee());
			}else {
				if((int)shipmap.get(vo.getSid())<(vo.getObdelfee())) {
					shipmap.put(vo.getSid(),vo.getObdelfee());
				}
			}
			// ====================//
			int status=vo.getObstatus();
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
			vo.setStatusString(statusString);
			int saleprice=vo.getObsaleprice();
			int bcount=vo.getBcount();
			vo.setTotalvalue(saleprice*bcount);
			totalprice+=saleprice*bcount;
			String imgpath=path+"\\"+vo.getImgsavefilename();
			vo.setImgpath(imgpath);
		}
		int totalshipfee=0;
		Iterator iterator=shipmap.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry entry=(Entry)iterator.next();
			totalshipfee+=(int)entry.getValue();
		}
		model.addAttribute("totalprice",totalprice);
		model.addAttribute("totalshipfee",totalshipfee);
		model.addAttribute("list",list);
		model.addAttribute("sidmap",shipmap);
		
		return ".usedorder";
	}

	//================== 중고상품 주문 컨트롤러 끝 ===========================//
	@RequestMapping(value="/order/directUsedOrder")
	public String directUsedOrder(int obnum,int bcount,Model model,HttpSession session) {
		String path=session.getAttribute("cp")+"/resources/jh/jhobupload";
		String smnum=(String)session.getAttribute("mnum");
		int mnum=0; //비회원 회원번호 0번으로 가정함.
		if(smnum!=null) {
			mnum=Integer.parseInt(smnum);
		}
		
		int totalprice=0;
		int totalpoint=0;
		UsedOrderListVo vo=service.directusedorder(obnum);
		int status=vo.getObstatus();
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
		vo.setStatusString(statusString);
		int saleprice=vo.getObsaleprice();
		vo.setBcount(bcount);
		vo.setTotalvalue(saleprice*bcount);
		totalprice+=saleprice*bcount;
		String imgpath=path+"\\"+vo.getImgsavefilename();
		vo.setImgpath(imgpath);
		int totalshipfee=vo.getObdelfee();
		List<UsedOrderListVo>list=new ArrayList<UsedOrderListVo>();
		list.add(vo);
		model.addAttribute("list", list);
		model.addAttribute("totalprice", totalprice);
		model.addAttribute("totalshipfee",totalshipfee);
		return ".usedorder";
	}
	
	//================== 중고/새상품 공용컨트롤러 시작 ========================//
	//주문/결제 완료페이지로 이동함.
		@RequestMapping(value="/order/resultorder",method=RequestMethod.POST)
		public String orderCompletePage(int bpaynum,String method,String separate,HttpSession session,Model model) {
			int mnum=0;
			String smnum=(String)session.getAttribute("mnum");
			if(smnum!=null) {
				mnum=Integer.parseInt(smnum);
			}
			OrderCompleteResultVo vo=service.complete_info(bpaynum);
			if(mnum!=0) {
				vo.setName(service.getName(mnum));
			}else {
				vo.setName(vo.getReceiver());
			}
			String addr=vo.getAddr();
			String [] addrGroup=addr.split("\\|");
			String addr1=addrGroup[0]; //우편번호
			String addr2=addrGroup[1]; // 도로명주소
			String addr3=addrGroup[2]; // 지번주소
			String addr4=addrGroup[3]; // 상세주소
			String addr5=addrGroup[4]; // 참고주소
			String jibunaddr="("+addr1+") "+addr3+" "+addr5+" "+addr4;
			String roadaddr="("+addr1+") "+addr2+" "+addr5+" "+addr4;
			vo.setJibunaddr(jibunaddr);
			vo.setRoadaddr(roadaddr);
			String path=session.getAttribute("cp")+"/resources/imgUpload";
			if(separate.equals("new")) {
				List<OrderCompleteListVo>list=service.getPaymentBook(bpaynum);
				int totalpoint=0;
				int totalprice=0;
				for(OrderCompleteListVo vo1:list) {
					String imgpath=path+"\\"+vo1.getImgsavefilename();
					vo1.setImgpath(imgpath);
					vo1.setTotalvalue(vo1.getBprice()*vo1.getBcount());
					vo1.setTotalpoint(vo1.getBpoint()*vo1.getBcount());
					totalpoint+=vo1.getBpoint()*vo1.getBcount();
					totalprice+=vo1.getBprice()*vo1.getBcount();
				}
				model.addAttribute("list", list);
				model.addAttribute("totalpoint",totalpoint); //총 적립예정포인트
				model.addAttribute("totalprice", totalprice);
			}else {
				 path=session.getAttribute("cp")+"/resources/jh/jhobupload";
				List<OrderCompleteUsedListVo>list=service.getUsedPaymentBook(bpaynum);
				int totalprice=0;
				for(OrderCompleteUsedListVo vo1:list) {
					String imgpath=path+"\\"+vo1.getImgsavefilename();
					vo1.setImgpath(imgpath);
					vo1.setTotalvalue(vo1.getObsaleprice()*vo1.getBcount());
					totalprice+=vo1.getObsaleprice()*vo1.getBcount();
					int status=vo1.getObstatus();
					
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
					vo1.setStatusString(statusString);
					
				}
				model.addAttribute("list", list);
				model.addAttribute("totalprice", totalprice);
			}		
			if(method.equals("vbank")) {
				VbankVo bankvo=service.vbank_info(bpaynum);
				model.addAttribute("bank",bankvo);
			}
			
			int payvalue=vo.getPaymentmoney()+vo.getDelfee(); //입금해야할 금액.
			model.addAttribute("payvalue", payvalue); 
			model.addAttribute("method",method);
			model.addAttribute("vo", vo);
			model.addAttribute("separate",separate);
			return ".complete";
		}

		//주문완료 메소드
		@RequestMapping(value="/order/complete",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
		@ResponseBody
		public String orderComplete_card(@RequestParam(value="cartNum",required=false)String[]cartNum, 
				@RequestParam(value="bnum")String[]bnum,
				  @RequestParam(value="bcount")String[]bcount, @RequestParam(value="point")String[]point,
				  int usepoint,int totalpoint,int shipCharge,String shipaddr,int pay_price,int pay_price_noshipfee,
				  String receiver,String callnum,String method,String imp_uid,@RequestParam(required = false)String vbank_due
				  ,String separate,@RequestParam(required = false)String vbank_name,
				  @RequestParam(required = false,defaultValue = "0")long vbank_num,
				  @RequestParam(required = false)String vbank_holder,HttpSession session) {
			int mnum=0;
			String smnum=(String)session.getAttribute("mnum");
			if(smnum!=null) {
				mnum=Integer.parseInt(smnum);
			}
			int orderprice=pay_price+usepoint;
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("mnum",mnum);
			if(cartNum!=null) {
				if(cartNum[0]!="0") { //장바구니있는경우는 장바구니에서도 삭제해줘야하기때문에.
					map.put("cartNum",cartNum);
				}
			}
			map.put("separate",separate);
			//가상계좌일때만 추가되는 map 값들
			if(method.equals("vbank")) {
				if(vbank_name=="") {
					vbank_name="케이뱅크";
				}
				map.put("vbank_name",vbank_name);
				map.put("vbank_holder",vbank_holder);
				map.put("vbank_num",vbank_num);
			}
			//=====================
			map.put("bnum", bnum);
			map.put("bcount", bcount);
			map.put("point", point);
			map.put("usepoint",usepoint);
			map.put("totalpoint",totalpoint);
			map.put("shipCharge",shipCharge);
			map.put("shipaddr",shipaddr);
			map.put("pay_price", pay_price);
			map.put("pay_price_noshipfee", pay_price_noshipfee);
			map.put("pay_price", pay_price);
			map.put("method",method); //결제수단
			map.put("receiver",receiver);
			map.put("callnum",callnum);
			map.put("orderprice",orderprice);
			
			HashMap<String, Object> resultmap=service.ordercomplete(map);
			JSONObject json=new JSONObject();
			json.put("bpaynum", (int)resultmap.get("bpaynum"));
			json.put("method", method);
			json.put("separate",separate);
			return json.toString();
		}
			
	
	//주문페이지에서 현재 사용가능한 포인트조회..
		@RequestMapping(value="/order/usablepoint",method=RequestMethod.POST)
		@ResponseBody
		public String usablepoint(HttpSession session) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=0;
			if(smnum!=null) {
				mnum=Integer.parseInt(smnum);
			}
			int point=service.getPoint(mnum);
			JSONObject json=new JSONObject();
			json.put("point", point);
			return json.toString();
		}
		
		//주문페이지에서 배송지 얻어옴.
		@RequestMapping(value="/order/getAddr",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String getShipAddr(HttpSession session) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=0;
			if(smnum!=null) {
				mnum=Integer.parseInt(smnum);
			}
			JSONObject json=new JSONObject();
			String addr1="";
			String addr2="";
			String addr3="";
			String addr4="";
			String addr5="";
			String phone1="";
			String phone2="";
			String phone3="";
			String mname="";
			ShipmentInfoVo vo=null;
			if(mnum!=0) {
				vo=service.getAddr(mnum);
				//06000|서울 강남구 강남대로 708|서울 강남구 압구정동 386-1|z| (압구정동)
				String [] addrGroup=vo.getAddr().split("\\|");
				addr1=addrGroup[0]; //우편번호
				addr2=addrGroup[1]; // 도로명주소
				addr3=addrGroup[2]; // 지번주소
				addr4=addrGroup[3]; // 상세주소
				addr5=addrGroup[4]; // 참고주소
				
				String [] phoneGroup=vo.getPhone().split("-");
				phone1=phoneGroup[0];
				phone2=phoneGroup[1];
				phone3=phoneGroup[2];
				
				mname=vo.getMname();
			}
			json.put("addr1", addr1); 
			json.put("addr2", addr2);
			json.put("addr3", addr3);
			json.put("addr4", addr4);
			json.put("addr5", addr5);
			json.put("mname",mname);
			json.put("phone1", phone1);
			json.put("phone2", phone2);
			json.put("phone3", phone3);
			return json.toString();
		}
	//================== 중고/새상품 공용컨트롤러 끝 ========================//	
	
		
		
	//================== 새상품 주문 컨트롤러 시작 ===========================//
	
	// 장바구니에서 주문하기 클릭했을때 처리함.
	@RequestMapping(value="/order/order",method = RequestMethod.POST)
	public String order(@RequestParam(value="cartNum")int[]cartNum,Model model,HttpSession session) {
		ArrayList<Integer> data=new ArrayList<Integer>(Arrays.stream(cartNum).boxed().collect(Collectors.toList()));
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("datalist", data);
		String path=session.getAttribute("cp")+"/resources/imgUpload";
		List<OrderListResultVo> list=service.inputorderlist(map);
		int totalprice=0;
		int totalpoint=0;
		for(OrderListResultVo vo:list) {
			String imgpath=path+"\\"+vo.getImgsavefilename();
			int point=vo.getBpoint();
			int price=vo.getBprice();
			int bcount=vo.getBcount();
			totalprice+=(price*bcount);
			totalpoint+=(point*bcount);
			vo.setTotalpoint(point*bcount); //각 행마다 적립될포인트.
			vo.setTotalvalue(price*bcount); //각행마다 총합
			vo.setImgpath(imgpath);
		}
		model.addAttribute("list", list);
		model.addAttribute("totalprice", totalprice);
		model.addAttribute("totalpoint", totalpoint);
		return ".order";
	}
	// 바로 주문하기 눌렀을때  (( 책번호랑 몇개주문했는지 bcount 받아야함 )):
	@RequestMapping(value="/order/directorder")
	public String directOrder(HttpSession session,int bnum,int bcount,Model model) {
		String path=session.getAttribute("cp")+"/resources/imgUpload";
		String smnum=(String)session.getAttribute("mnum");
		int mnum=0; //비회원 회원번호 0번으로 가정함.
		if(smnum!=null) {
			mnum=Integer.parseInt(smnum);
		}
		int totalprice=0;
		int totalpoint=0;
		OrderListResultVo vo=service.directorder(bnum);
		String imgpath=path+"\\"+vo.getImgsavefilename();
		int point=vo.getBpoint();
		int price=vo.getBprice();
		vo.setBcount(bcount);
		totalprice+=(price*bcount);
		totalpoint+=(point*bcount);
		vo.setTotalpoint(point*bcount);
		vo.setTotalvalue(price*bcount);
		vo.setImgpath(imgpath);
		List<OrderListResultVo> list=new ArrayList<OrderListResultVo>();
		list.add(vo);
		model.addAttribute("list", list);
		model.addAttribute("totalprice", totalprice);
		model.addAttribute("totalpoint", totalpoint);
		model.addAttribute("mnum",mnum);
		return ".order";
	}
	
	//================== 새상품 주문 컨트롤러 끝 ===========================//
}
