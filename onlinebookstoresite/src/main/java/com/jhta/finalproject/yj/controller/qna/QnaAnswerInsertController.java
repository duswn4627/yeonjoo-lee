package com.jhta.finalproject.yj.controller.qna;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.finalproject.yj.service.QnaAnswerTranService;
import com.jhta.finalproject.yj.vo.QnaAnswerVO;
import com.jhta.finalproject.yj.vo.QnaVO;

@Controller
public class QnaAnswerInsertController {
	@Autowired
	private QnaAnswerTranService service;

	@PostMapping("/qnaAnswerInsert")
	public String insertOk(HttpServletRequest req) {
		int n = 0;
		try {
			int qnanum = Integer.parseInt(req.getParameter("qnanum"));
			String acontent = req.getParameter("acontent");
			QnaAnswerVO avo = new QnaAnswerVO(null, qnanum, acontent, null);

			int mnum = Integer.parseInt(req.getParameter("mnum"));
			String qnatitle = req.getParameter("qnatitle");
			String qnacontent = req.getParameter("qnacontent");
			QnaVO qvo = new QnaVO(qnanum, mnum, qnatitle, qnacontent, 0, null);
			n = service.qnastatusInsertUpdate(avo, qvo);
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
