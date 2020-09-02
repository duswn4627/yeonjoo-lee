package com.jhta.finalproject.hd.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.hd.service.MemberService;
import com.jhta.finalproject.hd.vo.LoginCheckVo;
import com.jhta.finalproject.hd.vo.MemberinfoVo;
import com.jhta.finalproject.jh.service.MembersPointService;
@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	@Autowired
	private MembersPointService pointService;
	
	//로그인화면으로 이동..
		@RequestMapping("/login")
		public String moveloginPage() {
			return "heedo/login/login";
		}
		//로그인 jsp에서 로그인눌렀을때..
		@PostMapping("/loginCheck")
		@ResponseBody
		public String loginCheck(HttpSession session,String id,String pwd) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("id", id);
			map.put("pwd",pwd);
			String result="success";
			LoginCheckVo vo=service.membercheck(map);
			if(vo==null) {
				result="fail";
			}else if(vo.getMstatus()==0) {
				result="leave";
			}else if(vo.getSnum()!=0){  //snum이 있으면 세션에 저장함.
				session.setAttribute("mnum", vo.getMnum());
				session.setAttribute("mid", vo.getMid());
				session.setAttribute("snum", vo.getSnum());
				session.setAttribute("point", pointService.getTotPoint(Integer.parseInt(vo.getMnum())));//포인트 세션에 저장
				session.setAttribute("grade", pointService.getGrade(Integer.parseInt(vo.getMnum())));//등급 세션에 저장
			}else {
				session.setAttribute("mnum", vo.getMnum());
				session.setAttribute("mid", vo.getMid());
				session.setAttribute("point", pointService.getTotPoint(Integer.parseInt(vo.getMnum())));//포인트 세션에 저장
				session.setAttribute("grade", pointService.getGrade(Integer.parseInt(vo.getMnum())));//등급 세션에 저장
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();
		}
		//로그아웃버튼 클릭시.
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		//회원정보페이지로 이동
		@RequestMapping("/member/memberinfopage")
		public String infopage(HttpSession session,Model model) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			MemberinfoVo vo=service.memberinfo(mnum);
			String mname=vo.getMname();
			String mid=vo.getMid();
			Date regdate=vo.getRegdate();
			model.addAttribute("mname",mname);
			model.addAttribute("mid",mid);
			model.addAttribute("regdate",regdate);
			return ".memberinfo";
		}
		//회원탈퇴페이지로 이동
		@RequestMapping("/member/memberleavepage")
		public String leavepage() {
			return ".memberleave";
		}
		//탈퇴시 체크
		@RequestMapping(value="/member/leavecheck",method = RequestMethod.POST)
		@ResponseBody
		public String leaveCheck(HttpSession session) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			JSONObject json=new JSONObject();
			String result="";
			int n=service.ordercheck(mnum);
			if(n>0) { // 주문,결제 상태 주문내역존재 
				result="orderfail";
				json.put("result", result);
				return json.toString();
			}
			int n1=service.depositapplycheck(mnum);
			if(n1>0) { // 인출신청중인 예치금존재
				result="depositapplyfail";
				json.put("result", result);
				return json.toString();
			}
			List<Integer>list=service.depositcheck(mnum);
			int totaldeposit=0;
			if(list!=null) {
				for(int val:list) {
					totaldeposit+=val;
				}
			}
			if(totaldeposit>0) {
				result="depositfail";
				json.put("result", result);
				return json.toString();
			}else if(totaldeposit<0) {
				result="err";
				json.put("result", result);
				return json.toString();
			}
			int snum=service.obsellercheck(mnum);
			int n2=0;
			if(snum>0) {
				n2=service.obcheck(snum);
			}
			if(n2>0) {
				result="obfail";
				json.put("result", result);
				return json.toString();
			}
			result="success";
			json.put("result", result);
			return json.toString();
		}
		//탈퇴처리.
		@RequestMapping(value="/member/leavemember",method = RequestMethod.POST)
		@ResponseBody
		public String leavemember(HttpSession session) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			int n=service.leavemember(mnum);
			String result="";
			if(n>0) {
				result="success";
			}else {
				result="fail";
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();
		}
		//회원정보페이지 이동.
		@RequestMapping(value="/member/memberinfo",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
		@ResponseBody
		public String memberinfo(HttpSession session) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			MemberinfoVo vo=service.memberinfo(mnum);
			JSONObject json=new JSONObject();
			json.put("mid", vo.getMid());
			json.put("mpwd", vo.getMpwd());
			json.put("email", vo.getEmail());
			json.put("phone", vo.getPhone());
			String addr=vo.getAddr();
			String [] addrGroup=addr.split("\\|");
			String addr1=addrGroup[0]; //우편번호
			String addr2=addrGroup[1]; // 도로명주소
			String addr3=addrGroup[2]; // 지번주소
			String addr4=addrGroup[3]; // 상세주소
			String addr5=addrGroup[4]; // 참고주소
			json.put("addr1", addr1);
			json.put("addr2", addr2);
			json.put("addr3", addr3);
			json.put("addr4", addr4);
			json.put("addr5", addr5);
			return json.toString();
		}
		
		//전화번호수정.
		@RequestMapping(value="/member/updatephone",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String updatePhone(HttpSession session,String phone) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("mnum", mnum);
			map.put("phone",phone);
			int n=service.updatephone(map);
			String result="";
			if(n>0) {
				result="success";
			}else {
				result="fail";
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();
		}
		
		@RequestMapping(value="/member/updatepwd",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String updatePwd(HttpSession session,String pwd) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("mnum", mnum);
			map.put("mpwd",pwd);
			int n=service.updatepwd(map);
			String result="";
			if(n>0) {
				result="success";
			}else {
				result="fail";
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();
		}
		
		@RequestMapping(value="/member/updateEmail",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String updateEmail(HttpSession session,String email) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("mnum", mnum);
			map.put("email",email);
			int n=service.updateEmail(map);
			String result="";
			if(n>0) {
				result="success";
			}else {
				result="fail";
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();
		}
		
		@RequestMapping(value="/member/updateaddr",produces = "application/json;charset=utf-8")
		@ResponseBody
		public String updateaddr(HttpSession session,String addr) {
			String smnum=(String)session.getAttribute("mnum");
			int mnum=Integer.parseInt(smnum);
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("mnum", mnum);
			map.put("addr",addr);
			int n=service.updateaddr(map);
			String result="";
			if(n>0) {
				result="success";
			}else {
				result="fail";
			}
			JSONObject json=new JSONObject();
			json.put("result", result);
			return json.toString();
		}
}
