package com.jhta.finalproject.jm.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.finalproject.jm.service.BooksService;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BigcateVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.BreviewVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ListimgVo;
import com.jhta.finalproject.jm.vo.SmallcateVo;
import com.jhta.page.util.PageUtil;

@Controller
public class ListController {
	@Autowired
	private BooksService service;

	//전체 리스트
	@GetMapping(value = "/list1")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		map.put("field", field); //null
		map.put("keyword", keyword); //null

		ModelAndView mv = new ModelAndView(".list1");
		int totalRowCount = service.count1(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());

		List<AllListVo> list=service.allbooklist(map);
		List<BigcateVo> list2=service.list2();

		mv.addObject("list", list);	
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		mv.addObject("bnum",bnum);
		
		return mv;
	}
	
	// 베스트셀러 리스트..(bhit 기준)
	@GetMapping(value = "/list2")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView bestlist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		map.put("field", field);
		map.put("keyword", keyword);

		ModelAndView mv = new ModelAndView(".list2");
		int totalRowCount = service.count1(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<AllListVo> bestlist = service.bestlist(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("bestlist", bestlist);
		
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		mv.addObject("bnum",bnum);
		
		return mv;
	}
	
	// 검색했을때 리스트
	@RequestMapping(value = "/sbooklist")
	public ModelAndView sbooklist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword ,@RequestParam(value = "bcate2", defaultValue = "0")int bcate2,
			@RequestParam(value = "scate2", defaultValue = "0")int scate2,
			@RequestParam(value = "bnum", defaultValue = "0")int bnum) {
		System.out.println("scate:" + scate2);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		ModelAndView mv = new ModelAndView(".sclist");
		map.put("keyword", keyword);
		map.put("bcatenum", bcate2);
		map.put("scatenum", scate2);
		
		System.out.println(keyword);

		int totalRowCount = service.sbooklist1count(map);// 전체글의 갯수
		
		System.out.println("전체"+totalRowCount);

		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		// 검색조건 Map에 담기
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());

		
		System.out.println("scate2?" + scate2);
		System.out.println("bcate2?" + bcate2);
		String scatename=service.getsCatename(scate2);
		String bcatename=service.getbCatename(bcate2);
		System.out.println("scatename?" + scatename);
		System.out.println("bcatename?" + bcatename);
		System.out.println(pu.getStartRow()+"/"+pu.getEndRow()+"/"+scate2);
		
		List<AllListVo> sbooklist1=service.sbooklist1(map);
		List<BigcateVo> list2=service.list2();

		System.out.println("pu:" + pu);
		mv.addObject("sbooklist1", sbooklist1);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("scatenum", scate2);
		mv.addObject("keyword", keyword);
		mv.addObject("bcatenum", bcate2);
		mv.addObject("bnum",bnum);
		mv.addObject("bcatename",bcatename);
		mv.addObject("scatename",scatename);
		return mv;
	}
	
	//신간 리스트
	@GetMapping(value = "/newlist")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView newlist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		map.put("field", field);
		map.put("keyword", keyword);

		ModelAndView mv = new ModelAndView(".newlist");
		int totalRowCount = service.count1(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);

		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<AllListVo> newlist = service.newlist(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("newlist", newlist);
	
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
		
	//소설분류 리스트
	@GetMapping(value = "/cnovel")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView cnovellist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".cnovel");
		
		map.put("field", field);
		map.put("keyword", keyword);

		int totalRowCount = service.novelcount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);

		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> catenovel = service.catenovel(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("catenovel", catenovel);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	//		시/에세이분류 리스트
	@GetMapping(value = "/cpoetry")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView cpoetrylist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".cpoetry");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.poetrycount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> catepoetry = service.catepoetry(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("catepoetry", catepoetry);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	//		인문 분류 리스트
	@GetMapping(value = "/chuman")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView chumanlist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".chuman");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.humancount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> catehuman = service.catehuman(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("catehuman", catehuman);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	//		경제/경영 분류 리스트
	@GetMapping(value = "/ceconomy")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView ceconomylist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".ceconomy");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.economycount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> cateeconomy = service.cateeconomy(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("cateeconomy", cateeconomy);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	//		자기계발 분류 리스트
	@GetMapping(value = "/cselfdev")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView cselfdevlist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".cselfdev");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.selfdevcount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> cateselfdev = service.cateselfdev(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("cateselfdev", cateselfdev);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	//		역사 분류 리스트
	@GetMapping(value = "/chistory")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView chistorylist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".chistory");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.historycount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> catehistory = service.catehistory(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("catehistory", catehistory);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	//	 취업 분류 리스트
	@GetMapping(value = "/cjob")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView cjoblist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".cjob");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.jobcount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> catejob = service.catejob(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("catejob", catejob);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	//	 취업 분류 리스트
	@GetMapping(value = "/ctravel")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView ctravellist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".ctravel");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.travelcount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> catetravel = service.catetravel(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("catetravel", catetravel);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	
	//	 It/컴퓨터 분류 리스트
	@GetMapping(value = "/cit")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView citlist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".cit");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.itcount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> cateit = service.cateit(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("cateit", cateit);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	
	//	 만화 분류 리스트
	@GetMapping(value = "/ccartoon")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView ccartoonlist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".ccartoon");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.cartooncount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> catecartoon = service.catecartoon(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("catecartoon", catecartoon);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	
	
	//	 기타 분류 리스트
	@GetMapping(value = "/cguitar")
	// 파라미터가 pageNum으로 넘어오지않으면 기본값(defaultValue)를 1로 줘라~
	public ModelAndView cguitarlist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 검색조건 Map에 담기
		ModelAndView mv = new ModelAndView(".cguitar");
		
		map.put("field", field);
		map.put("keyword", keyword);
		
		int totalRowCount = service.guitarcount(map);// 전체글의 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 10, 10);
		
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		List<AllListVo> categuitar = service.categuitar(map);
		List<BigcateVo> list2=service.list2();
		mv.addObject("categuitar", categuitar);
		mv.addObject("list2", list2);
		mv.addObject("pu", pu);
		mv.addObject("field", field);
		mv.addObject("keyword", keyword);
		
		return mv;
	}
	

}
