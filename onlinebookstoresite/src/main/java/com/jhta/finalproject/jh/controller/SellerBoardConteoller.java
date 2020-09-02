package com.jhta.finalproject.jh.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.jh.service.SellerBoardService;
import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerObqanswerVo;
import com.jhta.finalproject.jh.vo.SellerQnaListJoinVo;
import com.jhta.finalproject.jh.vo.SellerReviewJoinVo;
import com.jhta.page.util.PageUtil;

@Controller
public class SellerBoardConteoller {
	@Autowired
	private SellerBoardService service;
	//====================Qna===========================
	//중고판매자 QnA리스트
	@RequestMapping("/seller/qnalist")
	public String sellerQnaList(Model model,HttpSession session,
			@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
			@RequestParam(value="obqstatus",defaultValue = "2")int obqstatus,
			String obqdate,String startDay,String endDay,String field,
			String keyword) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("snum",session.getAttribute("snum"));//판매자번호
		map.put("obqstatus", obqstatus);
		map.put("obqdate", obqdate);
		map.put("startDay", startDay);
		map.put("endDay", endDay);
		map.put("field", field);
		map.put("keyword", keyword);
		int totalRowCount=service.getSellerQnaCount(map);//글갯수
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 3);
		map.put("startRow",pu.getStartRow());
		map.put("endRow",pu.getEndRow());
		
		List<SellerQnaListJoinVo> list=service.getSellerQnaList(map);//문의글리스트
		
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		model.addAttribute("map", map);
		return ".seller.qna";  
	}
	
	//중고 문의사항 상세페이지로 이동
	@RequestMapping("/seller/qnadetail")
	public String obQnaDetail(int obqnum,Model model) {
		SellerQnaListJoinVo qnaList=service.getSellerQnaDetail(obqnum); //문의사항
		SellerObqanswerVo answerList=service.getSellerAnswerList(obqnum); //답변
		SellerImgVo img=service.getQnaDetailImg(qnaList.getObnum()); //썸네일이미지
		model.addAttribute("answerList", answerList);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("img", img);
		return ".seller.qnadetail";
	}
	
	//중고Qna답글달기 (트랜잭션)
	@PostMapping("/seller/insertAnswer")
	public String insertAnswer(int obqnum,String obqacontent,HttpSession session,Model model) {
		int snum=(Integer)session.getAttribute("snum");
		
		try {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("snum",snum);
			map.put("obqnum",obqnum);
			map.put("obqacontent",obqacontent);
			int n=service.sellerQnaInsert(map);
			model.addAttribute("obqnum", obqnum);
			return "redirect:/seller/qnadetail";
		}catch(Exception e){
			e.printStackTrace();
			return ".seller.insertfail";
		}
	}
	//중고Qna 답글 수정페이지로 이동
	@RequestMapping("/seller/qnaupdate")
	public String sellerQnaUpdate(int obqnum,Model model) {
		SellerQnaListJoinVo qnaList=service.getSellerQnaDetail(obqnum); //문의사항
		SellerObqanswerVo answerList=service.getSellerAnswerList(obqnum); //답변
		SellerImgVo img=service.getQnaDetailImg(qnaList.getObnum()); //썸네일이미지
		model.addAttribute("answerList", answerList);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("img", img);
		return ".seller.qnaupdate";
	}
	
	//중고Qna 답글 수정하기
	@RequestMapping("/seller/goqnaupdate")
	public String sellerQnaUpdateOk(String obqnum,String obqacontent,Model model) throws Exception{
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("obqnum",obqnum);
		map.put("obqacontent",obqacontent);
		service.updateObqanswer(map);
		model.addAttribute("obqnum", obqnum);
		return "redirect:/seller/qnadetail";
	}
	//===========================================================
	
	//====================리뷰========================
	//중고판매자 리뷰페이지
	@RequestMapping("/seller/review")
	public String sellerReview(HttpSession session,Model model,
			@RequestParam(value="pageNum", defaultValue = "1")int pageNum) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("snum",session.getAttribute("snum"));//판매자번호 
		int totalRowCount=service.getObreviewCount(map);//글갯수
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 3);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<SellerReviewJoinVo> list=service.getObreviewList(map);//리뷰리스트
		//판매자 총 평점
		Double reviewAvg=service.getReviewAvg((Integer)session.getAttribute("snum"));
		
		model.addAttribute("list", list);
		model.addAttribute("reviewAvg", reviewAvg);
		model.addAttribute("pu", pu);
		return ".seller.review";
	}
}
