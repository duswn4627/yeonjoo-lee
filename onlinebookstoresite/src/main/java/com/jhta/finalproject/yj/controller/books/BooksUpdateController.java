package com.jhta.finalproject.yj.controller.books;

import java.io.File;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.finalproject.yj.service.BooksImgService;
import com.jhta.finalproject.yj.service.BooksTransService;
import com.jhta.finalproject.yj.vo.BigCategoryVO;
import com.jhta.finalproject.yj.vo.BooksVO;
import com.jhta.finalproject.yj.vo.ImgVO;
import com.jhta.finalproject.yj.vo.SmallCategoryVO;

@Controller
public class BooksUpdateController {
	@Autowired
	public BooksImgService service;
	@Autowired
	public BooksTransService updateService;

	// 수정 폼
	@GetMapping("/booksUpdate")
	public String updateForm(int bnum, Model model) {
		BooksVO bvo = service.getBooksInfo(bnum);

		List<ImgVO> imgList = service.getImgInfo(bnum);
		model.addAttribute("thumbImg", imgList.get(0));

		if (imgList.size() == 2) { // 만약에 이미지가 두개일 경우 (그냥 이미지가 존재)
			model.addAttribute("img1", imgList.get(1));
		}

		int bcatenum = service.updateBigCtg(bnum);
//		System.out.println("카테고리넘버:" + bcatenum);
		model.addAttribute("bcatenum", bcatenum);

		List<BigCategoryVO> getBigctg = service.getBigctg();
		model.addAttribute("getBigctg", getBigctg);
		List<SmallCategoryVO> getsctg = service.getSmallctg(bcatenum);
		model.addAttribute("getsctg", getsctg);

		model.addAttribute("bvo", bvo);
		return ".booksUpdate";
	}

	// 폼에서 전달된 정보
	@PostMapping("/booksUpdate")
	public String updateOk(MultipartFile thumbnail, MultipartFile img1, HttpSession session, HttpServletRequest req,
			int thumbNum, int imgNum) {
		int n = 0;
		try {
			int bnum = Integer.parseInt(req.getParameter("bnum"));
			String btitle = req.getParameter("btitle");
			String bwriter = req.getParameter("bwriter");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bpublishdate = sdf.parse(req.getParameter("bpublishdate"));
//			System.out.println("bpublishdate:" + bpublishdate);
			String bpublisher = req.getParameter("bpublisher");
			int bprice = Integer.parseInt(req.getParameter("bprice"));
			int bpoint = Integer.parseInt(req.getParameter("bpoint"));
			int bcount = Integer.parseInt(req.getParameter("bcount"));
			String bcontent = req.getParameter("bcontent");
//			System.out.println(req.getParameter("smctg"));
			int smctg = Integer.parseInt(req.getParameter("smctg"));

			String uploadPath = session.getServletContext().getRealPath("/resources/imgUpload");
			
			List<ImgVO> imgList = service.getImgInfo(bnum);

			// file
			if (!(thumbnail.isEmpty()) && !(img1.isEmpty())) { // 둘 다 존재하면
				// 썸네일
				File f1 = new File(uploadPath + "\\" + imgList.get(0).getImgsavefilename());
				f1.delete();

				String imgorgfilename1 = thumbnail.getOriginalFilename();
				String imgsavefilename1 = UUID.randomUUID() + "_" + imgorgfilename1;
				InputStream fis1 = thumbnail.getInputStream();
				FileOutputStream fos1 = new FileOutputStream(uploadPath + "\\" + imgsavefilename1);

				FileCopyUtils.copy(fis1, fos1);
				fis1.close();
				fos1.close();

				BooksVO bvo1 = new BooksVO(bnum, btitle, bwriter, bpublishdate, bpublisher, bprice, bpoint, bcount,
						bcontent, 0, smctg, null);
				ImgVO ivo1 = new ImgVO(imgorgfilename1, thumbNum, imgsavefilename1, 1, 1, bnum);

				// 이미지
				File f2 = new File(uploadPath + "\\" + imgList.get(1).getImgsavefilename());
				f2.delete();

				String imgorgfilename2 = img1.getOriginalFilename();
				String imgsavefilename2 = UUID.randomUUID() + "_" + imgorgfilename2;
				InputStream fis2 = img1.getInputStream();
				FileOutputStream fos2 = new FileOutputStream(uploadPath + "\\" + imgsavefilename2);

				FileCopyUtils.copy(fis2, fos2);
				fis2.close();
				fos2.close();

				ImgVO ivo2 = new ImgVO(imgorgfilename2, imgNum, imgsavefilename2, 0, 1, bnum);
				service.booksUpdate(bvo1);
				n = updateService.update(ivo1, ivo2);
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
