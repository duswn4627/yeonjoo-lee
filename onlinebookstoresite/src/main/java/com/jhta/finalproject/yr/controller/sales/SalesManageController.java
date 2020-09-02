package com.jhta.finalproject.yr.controller.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.yr.service.SalesService;

@Controller
public class SalesManageController {
	
	@Autowired
	private SalesService service;
	
	@RequestMapping("/sales")
	public String goSales(Model model,String menu,String usedbookmenu, String startDate, String endDate, String week,
			String startYear, String startMonth, String endYear, String endMonth) {
		
//		System.out.println(
//				 menu + " : "+ startDate + " : "+ endDate+ " : "+ week
//				 + " : "+startYear+ " : "+ startMonth + " : "+endYear+ " : "+endMonth);
		
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("week", endDate);
		model.addAttribute("startYear", startYear);
		model.addAttribute("startMonth", startMonth);
		model.addAttribute("endYear", endYear);
		model.addAttribute("endMonth", endMonth);
		
		
		if(menu != null && menu != "") {
			
			model.addAttribute("menu", menu);
			return ".sales";
		}else {
			model.addAttribute("usedbookmenu", usedbookmenu);
			return ".usedbooksales";
			
		}
		
	}
	
	
	@RequestMapping("/sales/getInfo")
	@ResponseBody
	public String getInfo(String menu, String usedbookmenu, String startDate, String endDate, String week,
			String startYear, String startMonth, String endYear, String endMonth) {

		
//		System.out.println(
//				 "ggggggg " + menu + "," + usedbookmenu + " :sd "+ startDate + " :ed "+ endDate+ " :w "+ week
//				 + " :sy "+startYear+ " :sm "+ startMonth + " :ey "+endYear+ " :em "+endMonth);

		List<HashMap<String,String>> result = getDate(menu, usedbookmenu, startDate, endDate, week
				 , startYear, startMonth ,endYear, endMonth); 
		

		JSONArray arry = new JSONArray();
		JSONObject json = new JSONObject();
		List<Object> slabel = new ArrayList<Object>();
		List<Object> data = new ArrayList<Object>();
		if(result != null) {
			for (HashMap<String, String> hashMap : result) {
				for (String key	: hashMap.keySet()) {
					if(key.equals("BPAYDATE") || key.equals("FEEDATE")){
						slabel.add(hashMap.get(key));					
					}else {
						data.add(hashMap.get(key));					
					}
				}
			}

			json.put("code", "success");
			json.put("label",slabel);
			json.put("data",data);
			
			arry.put(json);
			
		}else {
			json.put("code", "error");
			arry.put(json);			
		}
	
		return arry.toString();
	}
	
	public List<HashMap<String,String>> getDate(String menu, String usedbookmenu, String startDate, String endDate, String week,
			String startYear, String startMonth, String endYear, String endMonth) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
		
		if(menu != null && menu != "") {
			if(menu.equals("0")) {
				result = service.getThreeday();
				return result;
			}			
		}
	
		map.put("endDate", endDate);
		map.put("startDate", startDate);
		
		if(week != null && week != "") {
			int iweek = Integer.parseInt(week);
			iweek = (iweek-1) * 7;
			map.put("week", iweek);
		}
		if(startYear != null && startYear != "") {
			String startYearAndMonth= startYear + "-" +  startMonth;
			int iendMonth = Integer.parseInt(endMonth)+1;
			int iendYear = Integer.parseInt(endYear);
			
			if(iendMonth >12) {
				iendYear = iendYear + 1;
			}
			String endYearAndMonth= iendYear + "-" +  iendMonth;
			map.put("startYearAndMonth",startYearAndMonth);
			map.put("endYearAndMonth",endYearAndMonth);
		}
		
		if(menu != null && menu != "") {
			map.put("field","bpaydate");
			
//			for (String key : map.keySet()) {
//				System.out.println(key + " : " + map.get(key));
//			}
			
			
			if(menu.equals("1") ) {
				result = service.getList(map);				
			}else if(menu.equals("2")) {
				result = service.weekList(map);
			}else if(menu.equals("3")) {
				result = service.mothList(map);
			}
		}
		
		if(usedbookmenu != null && usedbookmenu != "") {
			
			map.put("field","feedate");

			if(usedbookmenu.equals("1") ) {
				result = service.usedbookgetList(map);				
			}else if(usedbookmenu.equals("2")) {
				result = service.usedbookweekList(map);				
			}else if(usedbookmenu.equals("3")) {
				result = service.usedbookmothList(map);				
			}
			
		}
		return result;
	}
	
}