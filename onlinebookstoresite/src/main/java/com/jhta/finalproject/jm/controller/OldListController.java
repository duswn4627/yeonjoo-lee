package com.jhta.finalproject.jm.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.finalproject.jm.service.OldBooksService;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BigcateVo;
import com.jhta.finalproject.jm.vo.OldAllListVo;
import com.jhta.page.util.PageUtil;

@Controller
public class OldListController {
	@Autowired
	private OldBooksService service;
	
	//전체 리스트
	@GetMapping(value = "/oldallbook")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView oldalllist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "obnum", defaultValue = "0")int obnum) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		map.put("field", field); //아무것도 안들어감1
		map.put("keyword", keyword); //아무것도 안들어감2
		ModelAndView mv = new ModelAndView(".oldallbook");
		int totalRowCount = service.oldallcount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<OldAllListVo> list=service.oldalllist(map);
		List<BigcateVo> bclist=service.bcatelist();

		mv.addObject("list", list);	
		mv.addObject("bclist", bclist);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	// 검색했을때 리스트
	@RequestMapping(value = "/oldsclist")
	public ModelAndView sbooklist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword ,@RequestParam(value = "bcate2", defaultValue = "0")int bcate2,
			@RequestParam(value = "scate2", defaultValue = "0")int scate2) {
		System.out.println("scate:" + scate2);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		ModelAndView mv = new ModelAndView(".oldsclist");
		map.put("keyword", keyword);
		map.put("bcatenum", bcate2);
		map.put("scatenum", scate2);
		
		System.out.println(keyword);

		int totalRowCount = service.oldsccount(map);// 전체글의 갯수
		
		System.out.println("전체"+totalRowCount);

		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 10);
		// 검색조건 Map에 담기
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());

		System.out.println("scate2가 뭐냐?" + scate2);
		System.out.println("bcate2가 뭐임?" + bcate2);
		
		String scatename=service.getosCatename(scate2);
		String bcatename=service.getobCatename(bcate2);
		System.out.println("scatename가 뭐냐?" + scatename);
		System.out.println("bcatename가 뭐임?" + bcatename);
		System.out.println(pu.getStartRow()+"/"+pu.getEndRow()+"/"+scate2);
		
		List<OldAllListVo> oldsclist=service.oldsclist(map);
		List<BigcateVo> bclist=service.bcatelist();

		System.out.println("pu:" + pu);
		mv.addObject("oldsclist", oldsclist);
		mv.addObject("bclist", bclist);
		mv.addObject("pu", pu);
		mv.addObject("scatenum", scate2);
		mv.addObject("keyword", keyword);
		mv.addObject("bcatenum", bcate2);
		mv.addObject("bcatename",bcatename);
		mv.addObject("scatename",scatename);
		System.out.println("==========================================================");
		return mv;
	}
	
}
