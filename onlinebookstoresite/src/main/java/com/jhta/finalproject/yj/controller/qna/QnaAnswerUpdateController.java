package com.jhta.finalproject.yj.controller.qna;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.finalproject.yj.service.QnaService;
import com.jhta.finalproject.yj.vo.QnaAnswerVO;

@Controller
public class QnaAnswerUpdateController {
	@Autowired
	private QnaService service;

	@PostMapping("/qnaAnswerUpdate")
	public String answerUpdate(HttpServletRequest req) {
		int qnanum = Integer.parseInt(req.getParameter("qnanum"));
		String acontent = req.getParameter("acontent"); // 수정할 답변내용
		QnaAnswerVO vo = new QnaAnswerVO(null, qnanum, acontent, null);
		int n = service.answerUpdate(vo);
		if (n > 0) {
			return "/admin/success";
		} else {
			return "/admin/fail";
		}
	}
}
