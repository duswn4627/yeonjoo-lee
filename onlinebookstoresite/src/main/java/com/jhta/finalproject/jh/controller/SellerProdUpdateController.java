package com.jhta.finalproject.jh.controller;

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

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.finalproject.jh.service.SellerInsertService;
import com.jhta.finalproject.jh.service.SellerProdLookService;
import com.jhta.finalproject.jh.vo.SellerBigcategoryVo;
import com.jhta.finalproject.jh.vo.SellerImgVo;
import com.jhta.finalproject.jh.vo.SellerOldbooksVo;
import com.jhta.finalproject.jh.vo.SellerSmallcategoryVo;

@Controller
public class SellerProdUpdateController {
	@Autowired
	private SellerProdLookService lookService;
	@Autowired
	private SellerInsertService insertService;

	// 기존 정보를 가지고 수정할 페이지로 이동하는 메소드
	@RequestMapping("/seller/prodUpdateView")
	public String prodUpdateView(Model model, int obnum) {
		try {
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");// 날짜형식 지정
			List<SellerBigcategoryVo> list = insertService.getBigcate();
			List<SellerOldbooksVo> prodList = lookService.prodUpdateSelect(obnum);//수정할 상품 정보
			List<SellerImgVo> imgList=lookService.getProdImgList(obnum);//이미지
			int bcatenum = lookService.getBiccatenum(obnum);
			List<SellerSmallcategoryVo> smallList = insertService.getSmallcate(bcatenum);
			int scatenum = prodList.get(0).getScatenum();
			//-------------------------------------------------------
			//주소api사용한 부분 문자열 나누기
			String addrStr=prodList.get(0).getSelleraddr();
			String[] arr=addrStr.split("\\|");
			// ----------------기존 파라미터값들 보내주기-------------------
			model.addAttribute("obnum", obnum);//상품번호
			model.addAttribute("list", list);// 큰카테고리 리스트
			model.addAttribute("slist", smallList);// 작은 카테고리 리스트
			model.addAttribute("bbcatenum", bcatenum);// 기존 큰카테고리
			model.addAttribute("sscatenum", scatenum);// 기존 작은 카테고리
			model.addAttribute("getObname", prodList.get(0).getObname());// 기존도서명
			model.addAttribute("getObwriter", prodList.get(0).getObwriter());// 기존저자
			model.addAttribute("getObpublisher", prodList.get(0).getObpublisher());// 기존출판사
			model.addAttribute("getObpdate", dformat.format(prodList.get(0).getObpdate()));// 기존출간일
			model.addAttribute("getOborgprice", prodList.get(0).getOborgprice());// 기존정가
			model.addAttribute("getObstatus", prodList.get(0).getObstatus());// 기존품질
			model.addAttribute("getObsaleprice", prodList.get(0).getObsaleprice());// 기존판매가
			model.addAttribute("getObdelfee", prodList.get(0).getObdelfee());//택배비
			model.addAttribute("addr1", arr[0]);//주소1
			model.addAttribute("addr2", arr[1]);//주소2
			model.addAttribute("addr3", arr[2]);//주소3
			model.addAttribute("addr4", arr[3]);//주소4
			model.addAttribute("addr5", arr[4]);//주소5
			model.addAttribute("getObdetail", prodList.get(0).getObdetail());//상품상세설명
			model.addAttribute("imgList", imgList);//등록한 이미지 리스트
			return ".seller.prodUpdateView";
		} catch (Exception e) {
			e.printStackTrace();
			return ".seller.insertfail";
		}
	}
	
	//상품 수정하는 메소드
	@RequestMapping("/seller/updateOldbook")
	public String updateOldbook(HttpServletRequest req,HttpSession session,MultipartFile updateImg1,
			MultipartFile updateImg2,MultipartFile updateImg3,MultipartFile updateImg4,MultipartFile img2,
			MultipartFile img3,MultipartFile img4) {
		try {
				SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");//날짜형식 지정
				String selleraddr=req.getParameter("addr1")+"|"+req.getParameter("addr2")+"|"+req.getParameter("addr3")+"|"+
						req.getParameter("addr4")+"|"+req.getParameter("addr5"); //출고주소
				int obdelfee=Integer.parseInt(req.getParameter("obdelfee"));//배송료
				String obname=req.getParameter("obname"); //책이름
				String obwriter=req.getParameter("obwriter"); //저자
				String obpublisher=req.getParameter("obpublisher"); //출판사
				Date obpdate=dformat.parse(req.getParameter("obpdate")); //출간일 
				int obnum=Integer.parseInt(req.getParameter("obnum"));
				int obstatus=Integer.parseInt(req.getParameter("obstatus")); //품질
				int oborgprice=Integer.parseInt(req.getParameter("oborgprice")); //정가
				int obsaleprice=Integer.parseInt(req.getParameter("obsaleprice"));  //판매가
				int scatenum=Integer.parseInt(req.getParameter("scatename"));  //판매가
				String obdetail=req.getParameter("obdetail"); //상품설명
				SellerOldbooksVo vo=new SellerOldbooksVo(obnum, 0, selleraddr, obname, obwriter, obpublisher, obpdate, 
						obstatus, oborgprice, obsaleprice, obdetail, obdelfee, 0, 0, scatenum, null);

				String upload=session.getServletContext().getRealPath("/resources/jh/jhobupload");//업로드 파일 경로명
				List<SellerImgVo> imglist=new ArrayList<SellerImgVo>();
				if(updateImg1!=null && !updateImg1.isEmpty()) {
					String orgUdpateName1=updateImg1.getOriginalFilename();
					String updateSaveName1=UUID.randomUUID()+"_"+orgUdpateName1;
					InputStream fis=updateImg1.getInputStream();
					FileOutputStream fos=
							new FileOutputStream(upload+"\\"+updateSaveName1);
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();
					SellerImgVo updateimg1=new SellerImgVo(orgUdpateName1, 0, updateSaveName1, 1, 2, obnum);
					imglist.add(updateimg1);		
				}
				if(updateImg2!=null && !updateImg2.isEmpty()) {
					String orgUdpateName2=updateImg2.getOriginalFilename();
					String updateSaveName2=UUID.randomUUID()+"_"+orgUdpateName2;
					InputStream fis=updateImg2.getInputStream();
					FileOutputStream fos=
							new FileOutputStream(upload+"\\"+updateSaveName2);
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();
					SellerImgVo updateimg2=new SellerImgVo(orgUdpateName2, 0, updateSaveName2, 0, 2, obnum);
					imglist.add(updateimg2);
				}
				if(updateImg3!=null && !updateImg3.isEmpty()) {
					String orgUdpateName3=updateImg3.getOriginalFilename();
					String updateSaveName3=UUID.randomUUID()+"_"+orgUdpateName3;
					InputStream fis=updateImg3.getInputStream();
					FileOutputStream fos=
							new FileOutputStream(upload+"\\"+updateSaveName3);
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();
					SellerImgVo updateimg3=new SellerImgVo(orgUdpateName3, 0, updateSaveName3, 0, 2, obnum);
					imglist.add(updateimg3);
				}
				if(updateImg4!=null && !updateImg4.isEmpty()) {
					String orgUdpateName4=updateImg4.getOriginalFilename();
					String updateSaveName4=UUID.randomUUID()+"_"+orgUdpateName4;
					InputStream fis=updateImg4.getInputStream();
					FileOutputStream fos=
							new FileOutputStream(upload+"\\"+updateSaveName4);
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();
					SellerImgVo updateimg4=new SellerImgVo(orgUdpateName4, 0, updateSaveName4, 0, 2, obnum);
					imglist.add(updateimg4);
				}
				if(img2!=null && !(img2.isEmpty())) {
					String orgUdpateImg2=img2.getOriginalFilename();
					String updateSaveImg2=UUID.randomUUID()+"_"+orgUdpateImg2;
					InputStream fis=img2.getInputStream();
					FileOutputStream fos=
							new FileOutputStream(upload+"\\"+updateSaveImg2);
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();
					SellerImgVo imgvo=new SellerImgVo(orgUdpateImg2, 0, updateSaveImg2, 0, 2, obnum);
					imglist.add(imgvo);
				}
				if(img3!=null && !(img3.isEmpty())) {
					String orgUdpateImg3=img3.getOriginalFilename();
					String updateSaveImg3=UUID.randomUUID()+"_"+orgUdpateImg3;
					InputStream fis=img3.getInputStream();
					FileOutputStream fos=
							new FileOutputStream(upload+"\\"+updateSaveImg3);
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();
					SellerImgVo imgvo=new SellerImgVo(orgUdpateImg3, 0, updateSaveImg3, 0, 2, obnum);
					imglist.add(imgvo);
				}
				if(img4!=null && !(img4.isEmpty())) {
					String orgUdpateImg4=img4.getOriginalFilename();
					String updateSaveImg4=UUID.randomUUID()+"_"+orgUdpateImg4;
					InputStream fis=img4.getInputStream();
					FileOutputStream fos=
							new FileOutputStream(upload+"\\"+updateSaveImg4);
					FileCopyUtils.copy(fis, fos);
					fis.close();
					fos.close();
					SellerImgVo imgvo=new SellerImgVo(orgUdpateImg4, 0, updateSaveImg4, 0, 2, obnum);
					imglist.add(imgvo);
				}
				//수정할 상품정보+수정한 이미지
				lookService.oldbookAndImgUpdate(vo, imglist);
				return "redirect:/seller/insertOk";
		}catch (ParseException e) {
			e.printStackTrace();
			return ".seller.insertfail";
		}catch (IOException ie) {
			ie.printStackTrace();
			return ".seller.insertfail";
		}
	}
	
	//이미지삭제하는 메소드
	@RequestMapping("/seller/delimg")
	@ResponseBody
	public void delimg(int imgnum,HttpSession session) {
		SellerImgVo vo= lookService.getdelImginfo(imgnum);
		String delname=vo.getImgsavefilename();
		String uploadpath=session.getServletContext().getRealPath("/resources/jh/jhobupload");
		File file=new File(uploadpath+"\\"+delname);
		file.delete();//파일삭제
		int n=lookService.delimg(imgnum);//이미지삭제
		JSONObject json=new JSONObject();
		if(n>0) {
			json.put("code", "success");
		}else {
			json.put("code", "error");
		}
	}
	
	//상품삭제하는 메소드
	@RequestMapping("/seller/oldbookDel")
	public String oldbookDel(int obnum,HttpSession session) {
		List<SellerImgVo> list=lookService.delImglist(obnum);
		String uploadpath=session.getServletContext().getRealPath("/resources/jh/jhobupload");
		for(int n=0;n<list.size();n++) {
			File file=new File(uploadpath+"\\"+list.get(n).getImgsavefilename());
			file.delete();
		}
		lookService.oldbookDel(obnum);
		return "redirect:/seller/prodLook";
	}
}
