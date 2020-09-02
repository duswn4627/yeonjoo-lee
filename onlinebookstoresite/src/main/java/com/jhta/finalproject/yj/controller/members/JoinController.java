package com.jhta.finalproject.yj.controller.members;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.yj.service.MembersService;
import com.jhta.finalproject.yj.vo.MembersVO;

@Controller
public class JoinController {
	@Autowired
	private MembersService service;

	@GetMapping("/join")
	public String join() {
		return ".join";
	}

	// 아이디 중복체크
	@RequestMapping(value = "/joinIdCheck", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(@RequestParam("mid") String mid) {
		int result = service.idCheck(mid);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}

	// 이메일 중복체크
	@RequestMapping(value = "/joinEmailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String emailCheck(@RequestParam("email") String email) {
		int result = service.emailCheck(email);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}

	@PostMapping("/join")
	public String joinOk(HttpServletRequest req) {
		int n = 0;
		try {
			String mname = req.getParameter("mname");
			String mid = req.getParameter("mid");
			String mpwd = req.getParameter("mpwd");

			String email1 = req.getParameter("email1");
			String email2 = req.getParameter("email2");
			String email = email1 + email2;

			String phone1 = req.getParameter("phone1");
			String phone2 = req.getParameter("phone2");
			String phone3 = req.getParameter("phone3");
			String phone = phone1 + "-" + phone2 + "-" + phone3;

			String addr1 = req.getParameter("addr1");
			String addr2 = req.getParameter("addr2");
			String addr3 = req.getParameter("addr3");
			String addr4 = req.getParameter("addr4");
			String addr5 = req.getParameter("addr5");
			String addr = addr1 + "|" + addr2 + "|" + addr3 + "|" + addr4 + "|" + addr5;

			String yyyy = req.getParameter("yyyy");
			String mm = req.getParameter("mm");
			String dd = req.getParameter("dd");

			if (mm.length() == 1) {
				mm = 0 + mm;
			}
			if (dd.length() == 1) {
				dd = 0 + dd;
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birth = sdf.parse(yyyy + "-" + mm + "-" + dd);
			String sex = req.getParameter("sex");
			MembersVO vo = new MembersVO(0, mname, mid, mpwd, email, phone, addr, null, 0, 1, birth, sex);
			n = service.join(vo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (n > 0) {
			return ".main";
		} else {
			return ".join";
		}
	}
}
