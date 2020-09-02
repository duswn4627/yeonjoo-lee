package com.jhta.finalproject.yj.controller.books;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.finalproject.yj.service.BooksImgService;
import com.jhta.finalproject.yj.vo.BooksVO;
import com.jhta.finalproject.yj.vo.ImgVO;
import com.jhta.finalproject.yj.vo.PageUtil;

@Controller
public class BooksListController {
	@Autowired
	private BooksImgService service;

	@RequestMapping("/booksList")
	public ModelAndView showList(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, 
			String infoField, String infoKeyword, 
			String priceKeyword1,
			@RequestParam(value = "priceKeyword2", defaultValue = "0") String priceKeyword2, 
			String countKeyword1,
			@RequestParam(value = "countKeyword2", defaultValue = "0") String countKeyword2, 
			String dateKeyword1, 
			@RequestParam(value = "dateKeyword2", defaultValue = "0") String dateKeyword2) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if (priceKeyword2.equals("0")) {
			priceKeyword2 = priceKeyword1;
		}
		
		if (countKeyword2.equals("0")) {
			countKeyword2 = countKeyword1;
		}
		
		if (dateKeyword2.equals("0")) {
			dateKeyword2 = dateKeyword1;
		}
		map.put("infoField", infoField);
		map.put("infoKeyword", infoKeyword);
		map.put("priceKeyword1", priceKeyword1);
		map.put("priceKeyword2", priceKeyword2);
		map.put("countKeyword1", countKeyword1);
		map.put("countKeyword2", countKeyword2);
		map.put("dateKeyword1", dateKeyword1);
		map.put("dateKeyword2", dateKeyword2);
		
		int totalRowCnt = service.count(map); // 전체 글의 개수
		PageUtil pu = new PageUtil(pageNum, totalRowCnt, 20, 5); // 한 페이지에 20개 목록과 5개 페이지 수
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		ModelAndView mv = new ModelAndView();
		List<BooksVO> list = service.list(map);
		mv.addObject("list", list);
		mv.addObject("infoField", infoField);
		mv.addObject("infoKeyword", infoKeyword);
		mv.addObject("priceKeyword1", priceKeyword1);
		mv.addObject("priceKeyword2", priceKeyword2);
		mv.addObject("countKeyword1", countKeyword1);
		mv.addObject("countKeyword2", countKeyword2);
		mv.addObject("dateKeyword1", dateKeyword1);
		mv.addObject("dateKeyword2", dateKeyword2);
		mv.addObject("pu", pu);
		mv.setViewName(".booksList");
		return mv;
	}

	@RequestMapping("/preview")
	public String preview(int bnum, Model model) {
		BooksVO vo = service.getBooksInfo(bnum);
		String bcontent = vo.getBcontent();
		if (bcontent != null) {
			bcontent = bcontent.replace("\n", "<br>");
		}
		vo.setBcontent(bcontent);

		List<ImgVO> imgList = service.getImgInfo(bnum);

		if (imgList.size() == 2) { // 만약에 이미지가 두개일 경우
			model.addAttribute("imgVO2", imgList.get(1)); //일반 이미지
		}
		
		model.addAttribute("vo", vo);
		model.addAttribute("imgVO1", imgList.get(0)); //썸네일
		return ".booksPreview";
	}
	
	// 엑셀 다운로드 메소드
	@RequestMapping("/booksExcelDownload")
	public void excelDownload(HttpServletResponse res) throws Exception {
		List<BooksVO> list = service.excelList();
		Workbook wb = new HSSFWorkbook(); // 워크북 생성
		Sheet sheet = wb.createSheet("책 데이터");// 시트 생성

		// 컬럼 스타일
		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN); // 경계선 얇게
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex()); // 배경색 노랑
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headStyle.setAlignment(HorizontalAlignment.CENTER); // 가운데정렬

		// 값 스타일
		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);

		// 헤더(컬럼)
		Row headerRow = sheet.createRow(0);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("번호");
		headerCell = headerRow.createCell(1);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("제목");
		headerCell = headerRow.createCell(2);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("작가");
		headerCell = headerRow.createCell(3);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("출간일");
		headerCell = headerRow.createCell(4);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("출판사");
		headerCell = headerRow.createCell(5);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("가격");
		headerCell = headerRow.createCell(6);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("적립포인트");
		headerCell = headerRow.createCell(7);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("수량");
		headerCell = headerRow.createCell(8);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("상세설명");
		headerCell = headerRow.createCell(9);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("작은카테고리번호");
		headerCell = headerRow.createCell(10);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("등록일자");

		// 바디(값)
		Row bodyRow = null;
		Cell bodyCell = null;

		for (int i = 0; i < list.size(); i++) {
			BooksVO vo = list.get(i);
			bodyRow = sheet.createRow(i + 1);
			bodyCell = bodyRow.createCell(0);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBnum());
			bodyCell = bodyRow.createCell(1);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBtitle());
			bodyCell = bodyRow.createCell(2);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBwriter());
			bodyCell = bodyRow.createCell(3);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(vo.getBpublishdate()));
			bodyCell = bodyRow.createCell(4);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBpublisher());
			bodyCell = bodyRow.createCell(5);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBprice());
			bodyCell = bodyRow.createCell(6);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBpoint());
			bodyCell = bodyRow.createCell(7);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBcount());
			bodyCell = bodyRow.createCell(8);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getBcontent());
			bodyCell = bodyRow.createCell(9);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getScatenum());
			bodyCell = bodyRow.createCell(10);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(vo.getBregdate()));
		}
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment;filename=books_Data.xls");
		wb.write(res.getOutputStream());
		wb.close();
	}
}
