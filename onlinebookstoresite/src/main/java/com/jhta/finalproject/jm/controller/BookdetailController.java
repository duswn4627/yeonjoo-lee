package com.jhta.finalproject.jm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhta.finalproject.jm.service.BookdetailService;
import com.jhta.finalproject.jm.service.BooksService;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.BreviewVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ReviewinsertVo;
import com.jhta.page.util.PageUtil;

@Controller
public class BookdetailController {
	@Autowired
	private BookdetailService service;

	@RequestMapping(value = "/bdetail", method = RequestMethod.GET)
//	@GetMapping(value = "/bdetail")
	public ModelAndView detailtest(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "bnum", defaultValue = "0")int bnum)  {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("field",field);
		map.put("keyword",keyword);
		service.addHit(bnum);
		
		
		ModelAndView mv = new ModelAndView(".bdetail");
		int totalRowCount = service.breviewcount(bnum);// 리뷰 갯수
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 5, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("bnum",bnum);
		
		List<AllListVo> bookvo=service.bookdetail(bnum);
		List<BreviewVo> reviewvo=service.reviewlist(map);
	//	ImgVo imglist=service.imginfo(bnum);

		//썸네일,상세이미지 구분하기
		mv.addObject("bookvo",bookvo.get(0));
		
		for(AllListVo vo:bookvo) {
			if(vo.getThumbnail()==1) {
				mv.addObject("img1",vo);
			}else {
				mv.addObject("img2",vo);
			}
		}
		////////////////////
		//별점평균구하기
		int cnt = 0;
		int tot = 0;
		double avg=0;
		for(BreviewVo vo:reviewvo) {
			int i =+ vo.getBscore();
			cnt ++;
			tot += i;
			avg = tot/cnt;
			mv.addObject("avg",avg);					
		}
		System.out.println("AVG에 뭐들어있냐?"+avg);
		int bcnt=0;
		for(AllListVo vo:bookvo) {
			bcnt=vo.getBcount();
			mv.addObject("bcnt",bcnt);
		}	
		System.out.println("bcnt는???"+bcnt);
		mv.addObject("pu",pu);
		mv.addObject("reviewvo",reviewvo);
		mv.addObject("bnum",bnum);
		return mv;
	}
	
	@RequestMapping(value="/enrllReview", method = RequestMethod.GET)
	public String enrollReview(@RequestParam(value = "reviewcontent", defaultValue = "0")String reviewcontent, 
								@RequestParam(value = "bscore", defaultValue = "0")int bscore,
								@RequestParam(value = "mnum", defaultValue = "0")int mnum,
								@RequestParam(value = "bnum", defaultValue = "0")int bnum,
								RedirectAttributes redirect) {
		
		System.out.println("=====리뷰컨텐츠:"+reviewcontent);
		System.out.println("=====스코어:"+bscore);
		System.out.println("=====mnum:"+mnum);
		System.out.println("=====bnum:"+bnum);
		//insert 할때 밑에 Vo가 필요하다, mapper에 쿼리문이 작성되어있기떄문에 해당 필요한 4가지 mnum,bnum,reviewcontent,bscore 만 입력해준다.
		ReviewinsertVo vo=new ReviewinsertVo(0, mnum, bnum, reviewcontent, bscore, null);

		service.breviewinsert(vo);// 해당 vo를 result 값으로 받는다.

//		List<BreviewVo> list=service.reviewlist(map);

		redirect.addAttribute("bnum",bnum);
		
		return "redirect:/bdetail";

	}

}

