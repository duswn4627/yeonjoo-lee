package com.jhta.finalproject.hd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.hd.service.CartService;
import com.jhta.finalproject.hd.vo.CartListVo;
import com.jhta.finalproject.hd.vo.UsedCartListVo;

@Controller
public class CartController {
	@Autowired
	private CartService service;
	//장바구니버튼 클릭시 장바구니로 이동.
	@RequestMapping("/pay/cart")
	public String conCart() {
		return ".cart";
	}
	//============== 중고 관련 AJAX 컨트롤러  시작 =============//
	@RequestMapping(value="/pay/usedlist",produces= "application/json;charset=utf-8")
	@ResponseBody
	public String usedlist(HttpSession session,Model model) {
		String smnum=(String)session.getAttribute("mnum");
		String path=session.getAttribute("cp")+"/resources/jh/jhobupload";
		int mnum=0;
		if(smnum!=null) {
			mnum=Integer.parseInt(smnum);
		}
		List<UsedCartListVo>list=service.usedlist(mnum);
		JSONArray jarr=new JSONArray();
		List<String> sidList= new ArrayList<String>();
		for(UsedCartListVo vo:list) {
			JSONObject json=new JSONObject();
			json.put("cartnum", vo.getCartnum());	
			json.put("bcount", vo.getBcount());
			json.put("obnum", vo.getObnum());
			json.put("btitle", vo.getObname());
			String sid=service.getSid(vo.getSnum());
			//====== 판매자 아이디 리스트  add 시작 ====//
			json.put("sid", sid);
			int confirm=0;
			for(int i=0;i<sidList.size();i++) {
				if(sid.equals(sidList.get(i))) {
					confirm++;
				}
			}
			if(confirm==0) {
				sidList.add(sid);
			}
			//====== 판매자 아이디 리스트  add 끝 ====//
			String imgpath=path+"\\"+vo.getImgsavefilename();
			json.put("imgsrc", imgpath);
			json.put("oborgprice", vo.getOborgprice());
			json.put("obsaleprice", vo.getObsaleprice());
			int totalvalue=vo.getObsaleprice()*vo.getBcount();
			json.put("totalvalue",totalvalue );
			json.put("obstatus", vo.getObstatus());	
			json.put("shipmentfee", vo.getObdelfee());
			jarr.put(json);
		}
		JSONObject json=new JSONObject();
		if(sidList.size()!=0) {
			json.put("sidlist", sidList);
			jarr.put(json); //맨 마지막 json에는 판매자 아이디만 있음.
		}
		return jarr.toString();
	}
	
	//============== 중고 관련 AJAX 컨트롤러  끝 =============//
	
	//============== 중고/새상품 공용 AJAX 컨트롤러 시작 ===========//
	//장바구니에서 상품 하나삭제 AJAX
		@RequestMapping("/pay/deleteOneCart")
		@ResponseBody
		public String deleteOne(int cartNum) {
			int n=service.deleteOne(cartNum);
			String result="fail";
			if(n>0) {
				result="success";
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();	
		}
	
	//============== 중고/새상품 공용 AJAX 컨트롤러 시작 ===========//
	//============== 새상품 관련 AJAX 컨트롤러  시작 =============//
		
	//장바구니 새상품 리스트 출력 AJAX
	@RequestMapping(value="/pay/cartlist",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String cartlist(HttpSession session) {
		//세션에 들어있는 회원번호 받음.
		String smnum=(String)session.getAttribute("mnum");
		int mnum=0;
		if(smnum!=null) {
			mnum=Integer.parseInt(smnum);
		}
		String path=session.getAttribute("cp")+"/resources/imgUpload";
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("mnum", mnum);
		List<CartListVo> list=service.cartlist(map);
		JSONArray jarr=new JSONArray();
		for(CartListVo vo:list) {
			JSONObject json=new JSONObject();
			json.put("cartnum", vo.getCartnum());
			json.put("mnum", vo.getMnum());
			json.put("bnum", vo.getBnum());
			json.put("btitle", vo.getBtitle());
			String imgpath=path+"\\"+vo.getImgsavefilename();
			json.put("imgsrc", imgpath);
			json.put("bprice", vo.getBprice());
			json.put("bpoint", vo.getBpoint());
			json.put("bshipinfo", vo.getBshipinfo());
			json.put("stored", vo.getStored()); //재고 ( books 테이블 )
			json.put("bcount", vo.getBcount());
			int totalvalue=vo.getBprice()*vo.getBcount();
			int totalpoint=vo.getBpoint()*vo.getBcount();
			json.put("totalpoint", totalpoint);
			json.put("totalvalue", totalvalue);
			jarr.put(json);
		}
		return jarr.toString();
	}
	
	//새상품 수량변경 AJAX
	@RequestMapping("/pay/changeCount")
	@ResponseBody
	public String changeCount(int cartNum,int newCount) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("newCount", newCount);
		map.put("cartNum", cartNum);
		int n=service.changeCount(map);
		String result="fail";
		if(n>0) {
			result="success";
		}
		JSONObject json=new JSONObject();
		json.put("result", result);
		return json.toString();	
	}
	// 새상품 선택한거 삭제 AJAX
	@PostMapping("/pay/deleteSelectCart")
	@ResponseBody
	public String deleteSelectCart(@RequestParam(value="cartNumlist[]")List<Integer>cartNumlist) {
		String result="success";
		if(cartNumlist.size()==0) {
			result="fail";
		}else {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("list", cartNumlist);
			int n=service.deleteSelected(map);
			if(n<=0) {
				result="fail";
			}
		}
		JSONObject json=new JSONObject();
		json.put("result", result);
		
		return json.toString();
	}
	//============== 새상품 관련 AJAX 컨트롤러  끝 =============//
}
