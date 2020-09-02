
package com.jhta.finalproject.jh.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.finalproject.jh.service.SellerInsertService;
import com.jhta.finalproject.jh.vo.SellerBigcategoryVo;
import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerOldbooksVo;
import com.jhta.finalproject.jh.vo.SellerSmallcategoryVo;
@Controller
public class SellerProdInsertController {
	
	@Autowired
	private SellerInsertService service;
	
	//========================상품등록 페이지로 이동하기 위한 메소드========================
	@RequestMapping("/seller/productInput")
	public String sellerProdInput(Model model) {
		List<SellerBigcategoryVo> list=service.getBigcate();
		model.addAttribute("list", list);
		return ".seller.product";
	}
	
	//========================대분류 선택시 소분류 가져오는 메소드========================
	@RequestMapping("/seller/getSmallcate")
	@ResponseBody
	public List<SellerSmallcategoryVo> getSmallcate(int bcatenum) {
		List<SellerSmallcategoryVo> list= service.getSmallcate(bcatenum);
		return list;
	}
	
	//========================상품등록하기 위한 메소드========================
	@RequestMapping(value="/seller/prodInsert") 
	public String insertProd(HttpServletRequest req,HttpSession session, MultipartFile img1,//img1--thumbnail
			MultipartFile img2,MultipartFile img3,MultipartFile img4) {
		SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");//날짜형식 지정
		try {
			int snum=(Integer)session.getAttribute("snum");//중고판매자번호
			String selleraddr=req.getParameter("addr1")+"|"+req.getParameter("addr2")+"|"+req.getParameter("addr3")+"|"+
					req.getParameter("addr4")+"|"+req.getParameter("addr5"); //출고주소
			int obdelfee=Integer.parseInt(req.getParameter("obdelfee"));//배송료
			String obname=req.getParameter("obname"); //책이름
			String obwriter=req.getParameter("obwriter"); //저자
			String obpublisher=req.getParameter("obpublisher"); //출판사
			Date obpdate=dformat.parse(req.getParameter("obpdate")); //출간일 
			int obstatus=Integer.parseInt(req.getParameter("obstatus")); //품질
			int oborgprice=Integer.parseInt(req.getParameter("oborgprice")); //정가
			int obsaleprice=Integer.parseInt(req.getParameter("obsaleprice"));  //판매가
			String obdetail=req.getParameter("obdetail"); //상품설명
			
			//파일 업로드 경로명 가져오기
			String upload=session.getServletContext().getRealPath("/resources/jh/jhobupload");

			//썸네일 파일만 있을 경우 실행할 상품등록 작업
			if(img2.isEmpty() && img3.isEmpty() && img4.isEmpty()) {
				//파일 업로드를 위한 작업(썸네일)
				String orgFileName1=img1.getOriginalFilename();
				String saveFileName1=UUID.randomUUID()+"_"+orgFileName1;
				InputStream fis=img1.getInputStream();
				FileOutputStream fos=
						new FileOutputStream(upload+"\\"+saveFileName1);
				FileCopyUtils.copy(fis, fos);
				fis.close();
				fos.close();
				
				SellerImgVo img1vo=new SellerImgVo(orgFileName1, 0, saveFileName1, 0, 0, 0);
				int scatenum=Integer.parseInt(req.getParameter("scatename")); //작은카테고리번호
				SellerOldbooksVo vo=new SellerOldbooksVo(0, snum, selleraddr, obname, obwriter, obpublisher, 
						obpdate, obstatus, oborgprice, obsaleprice, obdetail, obdelfee, 0, 0, scatenum,null);
				service.insertProd(vo,img1vo);//중고책등록
			}else {
				//썸네일+선택이미지 있을 경우 실행할 상품등록 작업
				String orgFileName1=img1.getOriginalFilename();
				String saveFileName1=UUID.randomUUID()+"_"+orgFileName1;
				InputStream fis=img1.getInputStream();
				FileOutputStream fos=
						new FileOutputStream(upload+"\\"+saveFileName1);
				FileCopyUtils.copy(fis, fos);
				fis.close();
				fos.close();
				SellerImgVo img1vo=new SellerImgVo(orgFileName1, 0, saveFileName1, 0, 0, 0);
				int scatenum=Integer.parseInt(req.getParameter("scatename")); //작은카테고리번호
				SellerOldbooksVo vo=new SellerOldbooksVo(0, snum, selleraddr, obname, obwriter, obpublisher, 
						obpdate, obstatus, oborgprice, obsaleprice, obdetail, obdelfee, 0, 0, scatenum,null);
				
				//선택 이미지들을 담기 위한 배열
				List<SellerImgVo> list=new ArrayList<SellerImgVo>();
				
				if(!(img2.isEmpty())) {
					String orgFileName2=img2.getOriginalFilename();
					String saveFileName2=UUID.randomUUID()+"_"+orgFileName2;
					InputStream fis2=img2.getInputStream();
					FileOutputStream fos2=
							new FileOutputStream(upload+"\\"+saveFileName2);
					FileCopyUtils.copy(fis2, fos2);
					fis2.close();
					fos2.close();
					SellerImgVo img2vo=new SellerImgVo(orgFileName2, 0, saveFileName2, 0, 0, 0);
					list.add(img2vo);
				}
				if(!(img3.isEmpty())) {
					String orgFileName3=img3.getOriginalFilename();
					String saveFileName3=UUID.randomUUID()+"_"+orgFileName3;
					InputStream fis3=img3.getInputStream();
					FileOutputStream fos3=
							new FileOutputStream(upload+"\\"+saveFileName3);
					FileCopyUtils.copy(fis3, fos3);
					fis3.close();
					fos3.close();
					SellerImgVo img3vo=new SellerImgVo(orgFileName3, 0, saveFileName3, 0, 0, 0);
					list.add(img3vo);
				}
				if(!(img4.isEmpty())) {
					String orgFileName4=img4.getOriginalFilename();
					String saveFileName4=UUID.randomUUID()+"_"+orgFileName4;
					InputStream fis4=img4.getInputStream();
					FileOutputStream fos4=
							new FileOutputStream(upload+"\\"+saveFileName4);
					FileCopyUtils.copy(fis4, fos4);
					fis4.close();
					fos4.close();
					SellerImgVo img4vo=new SellerImgVo(orgFileName4, 0, saveFileName4, 0, 0, 0);
					list.add(img4vo);
				}
				service.insertProd(vo, img1vo, list);
			}
		}catch(ParseException e) {
			e.printStackTrace();
			return ".seller.insertfail";
		}catch(IOException ie) {
			ie.printStackTrace();
			return ".seller.insertfail";
		}
		//새로고침 방지하기 위한 컨트롤러로 이동
		return "redirect:/seller/insertOk";
	}
	
	@RequestMapping("/seller/insertOk")
	public String sellerInsertOk() {
		return ".seller.insertok";
	}
}
