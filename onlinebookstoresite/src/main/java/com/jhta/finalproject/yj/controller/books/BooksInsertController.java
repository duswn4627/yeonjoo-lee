package com.jhta.finalproject.yj.controller.books;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.finalproject.yj.service.BooksImgService;
import com.jhta.finalproject.yj.service.BooksTransService;
import com.jhta.finalproject.yj.vo.BigCategoryVO;
import com.jhta.finalproject.yj.vo.BooksVO;
import com.jhta.finalproject.yj.vo.ImgVO;
import com.jhta.finalproject.yj.vo.SmallCategoryVO;

@Controller
public class BooksInsertController {
	@Autowired
	private BooksImgService service;
	@Autowired
	private BooksTransService insertService;

	@GetMapping("/booksInsert")
	public String booksInsert(Model model) {
		List<BigCategoryVO> getBigctg = service.getBigctg();
		model.addAttribute("getBigctg", getBigctg);
		return ".booksInsert";
	}
	
	// 큰 카테고리에 해당하는 작은 카테고리 불러오기
	@RequestMapping(value = "/booksctg", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String sctgList(int bcatenum) {
		List<SmallCategoryVO> getsctg = service.getSmallctg(bcatenum);
		JSONArray arr = new JSONArray();
		for (SmallCategoryVO vo : getsctg) {
			JSONObject json = new JSONObject();
			json.put("scatenum", vo.getScatenum());
			json.put("bcatenum", vo.getBcatenum());
			json.put("scataname", vo.getScataname());
			arr.put(json);
		}
		return arr.toString();
	}

	@PostMapping("/booksInsert")
	public String insertOk(MultipartFile thumbnail, MultipartFile img1, HttpSession session, HttpServletRequest req) {
		int n = 0;
		try {
			String btitle = req.getParameter("btitle");
			String bwriter = req.getParameter("bwriter");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bpublishdate = sdf.parse(req.getParameter("bpublishdate"));
			String bpublisher = req.getParameter("bpublisher");
			int bprice = Integer.parseInt(req.getParameter("bprice"));
			int bpoint = Integer.parseInt(req.getParameter("bpoint"));
			int bcount = Integer.parseInt(req.getParameter("bcount"));
			String bcontent = req.getParameter("bcontent");
			int smctg = Integer.parseInt(req.getParameter("smctg"));

			String uploadPath = session.getServletContext().getRealPath("/resources/imgUpload");
//			C:\web\Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\onlinebookstoresite\resources\imgUpload

			// file
			if (!(thumbnail.isEmpty()) && !(img1.isEmpty())) {
				// 썸네일
				List<ImgVO> list = new ArrayList<ImgVO>();
				String imgorgfilename1 = thumbnail.getOriginalFilename();
				String imgsavefilename1 = UUID.randomUUID() + "_" + imgorgfilename1;
				InputStream fis1 = thumbnail.getInputStream();
				FileOutputStream fos1 = new FileOutputStream(uploadPath + "\\" + imgsavefilename1);
				FileCopyUtils.copy(fis1, fos1);
				fis1.close();
				fos1.close();

				BooksVO bvo=new BooksVO(0, btitle, bwriter, bpublishdate, bpublisher, bprice, bpoint, bcount, bcontent, 0, smctg, null);
				ImgVO ivo1 = new ImgVO(imgorgfilename1, 0, imgsavefilename1, 1, 1, bvo.getBnum());
				list.add(ivo1);

				// 이미지
				String imgorgfilename2 = img1.getOriginalFilename();
				String imgsavefilename2 = UUID.randomUUID() + "_" + imgorgfilename2;
				InputStream fis2 = img1.getInputStream();
				FileOutputStream fos2 = new FileOutputStream(uploadPath + "\\" + imgsavefilename2);
				FileCopyUtils.copy(fis2, fos2);
				fis2.close();
				fos2.close();

				ImgVO ivo2 = new ImgVO(imgorgfilename2, 0, imgsavefilename2, 0, 1, bvo.getBnum());
				list.add(ivo2);
				n = insertService.insertList(bvo, list);
			}
		} catch (ParseException pe) {
			System.out.println(pe.getMessage());
			return "/admin/fail";
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
			return "/admin/fail";
		}
//		return "redirect:/booksList";
		if (n > 0) {
			return "/admin/success";
		} else {
			return "/admin/fail";
		}
	}
}
