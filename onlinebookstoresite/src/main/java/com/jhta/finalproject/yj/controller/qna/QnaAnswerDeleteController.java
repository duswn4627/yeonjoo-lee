package com.jhta.finalproject.yj.controller.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.finalproject.yj.service.QnaAnswerTranService;
import com.jhta.finalproject.yj.vo.QnaVO;

@Controller
public class QnaAnswerDeleteController {
	@Autowired
	private QnaAnswerTranService service;

	@RequestMapping("/qnaAnswerDelete")
	public String answerDelete(int qnanum, QnaVO qvo) {
		int n = 0;
		try {
			n = service.qnastatusDeleteUpdate(qnanum, qvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "/admin/fail";
		}
		if (n > 0) {
			return "/admin/success";
		} else {
			return "/admin/fail";
		}
	}
}
