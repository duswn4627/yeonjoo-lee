package com.jhta.finalproject.jm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jhta.finalproject.jh.vo.SellerQnaListJoinVo;
import com.jhta.finalproject.jm.service.BookdetailService;
import com.jhta.finalproject.jm.service.BooksService;
import com.jhta.finalproject.jm.service.OldBookdetailService;
import com.jhta.finalproject.jm.vo.AllListVo;
import com.jhta.finalproject.jm.vo.BooksVo;
import com.jhta.finalproject.jm.vo.BreviewVo;
import com.jhta.finalproject.jm.vo.ImgVo;
import com.jhta.finalproject.jm.vo.ObQnaInsertVo;
import com.jhta.finalproject.jm.vo.OldAllListVo;
import com.jhta.finalproject.jm.vo.ReviewinsertVo;

import com.jhta.page.util.PageUtil;

@Controller
public class OldBookdetailController {
	@Autowired
	private OldBookdetailService service;

	@RequestMapping(value = "/obdetail", method = RequestMethod.GET)
//	@GetMapping(value = "/bdetail")
	public ModelAndView detailtest(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String field,
			String keyword,@RequestParam(value = "obnum", defaultValue = "0")int obnum,
			@RequestParam(value = "snum", defaultValue = "0")int snum,HttpSession session)  {
		
		String smnum=(String)session.getAttribute("mnum");
		if(smnum == null) {
			smnum = "0";
			int mnum=Integer.parseInt(smnum);
		}else {
			int mnum=Integer.parseInt(smnum);
		}
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("field",field);
		map.put("keyword",keyword);
		service.addHit(obnum);
		
		
		ModelAndView mv = new ModelAndView(".obdetail");

		map.put("obnum",obnum);

		List<OldAllListVo> oldbookvo=service.bookdetail(obnum);
		List<SellerQnaListJoinVo> qnavo=service.obqna(obnum);

		for(OldAllListVo vo:oldbookvo) {
			if(vo.getThumbnail()==1) {
				mv.addObject("img1",vo);
			}else {
				mv.addObject("img2",vo);
			}
		}
		
		int bcnt1=1;

		//중고라서 재고가 하나임
//		mv.addObject("bcnt", 1); 
		mv.addObject("bcnt",bcnt1);
	

		mv.addObject("oldbookvo",oldbookvo.get(0));
		mv.addObject("qnavo",qnavo);
		mv.addObject("obnum",obnum);
		mv.addObject("snum",snum);
		
		return mv;
	}
	
	@RequestMapping(value="/enrllQna", method = RequestMethod.GET)
	public String enrollReview(@RequestParam(value = "obqcontent", defaultValue = "0")String obqcontent, 
								@RequestParam(value = "obqtitle", defaultValue = "0")String obqtitle,
								@RequestParam(value = "obnum", defaultValue = "0")int obnum,
								@RequestParam(value = "snum", defaultValue = "0")int snum,
								HttpSession session,
								RedirectAttributes redirect) {
		
		String smnum=(String)session.getAttribute("mnum");
		int mnum=Integer.parseInt(smnum);
		
		System.out.println("=====컨텐츠:"+obqcontent);
		System.out.println("=====제목:"+obqtitle);
		System.out.println("=====mnum:"+mnum);
		System.out.println("=====obnum:"+obnum);
		ObQnaInsertVo vo=new ObQnaInsertVo(0, obqtitle, obqcontent, 0, null, obnum, mnum);

		service.obqnainsert(vo);// 해당 vo를 result 값으로 받는다.

		redirect.addAttribute("obnum",obnum);
		redirect.addAttribute("snum", snum);
		
		return "redirect:/obdetail";

	}
	
	@RequestMapping(value="/delqna", method = RequestMethod.GET)
	@ResponseBody
	public String qnadel(@RequestParam(value = "obqnum",defaultValue = "0")int obqnum,
								@RequestParam(value = "obnum", defaultValue = "0")int obnum,
								@RequestParam(value = "snum", defaultValue = "0")int snum,
								HttpSession session,
								RedirectAttributes redirect) {
		
		String smnum=(String)session.getAttribute("mnum");
		int mnum=Integer.parseInt(smnum);
		
		System.out.println("=====obqnum:"+obqnum);
		System.out.println("=====obnum:"+obnum);
		System.out.println("=====mnum:"+mnum);
		System.out.println("=====snum:"+snum);
		
		service.obqnadelete(obqnum);

		redirect.addAttribute("obnum",obnum);
		redirect.addAttribute("snum", snum);
		
		return "redirect:/obdetail";
	}
}

