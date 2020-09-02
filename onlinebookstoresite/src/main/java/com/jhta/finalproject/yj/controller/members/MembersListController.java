package com.jhta.finalproject.yj.controller.members;

import java.text.SimpleDateFormat;
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

import com.jhta.finalproject.yj.service.MembersService;
import com.jhta.finalproject.yj.vo.MembersVO;
import com.jhta.finalproject.yj.vo.PageUtil;

@Controller
public class MembersListController {
	@Autowired
	private MembersService service;

	// 일반회원
	@RequestMapping("/membersList")
	public ModelAndView memList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String infoField,
			String infoKeyword, String ageKeyword1,
			@RequestParam(value = "ageKeyword2", defaultValue = "0") String ageKeyword2, String dateKeyword1,
			@RequestParam(value = "dateKeyword2", defaultValue = "0") String dateKeyword2) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		if (ageKeyword2.equals("0")) {
			ageKeyword2 = ageKeyword1;
		}

		if (dateKeyword2.equals("0")) {
			dateKeyword2 = dateKeyword1;
		}

		map.put("infoField", infoField);
		map.put("infoKeyword", infoKeyword);
		map.put("ageKeyword1", ageKeyword1);
		map.put("ageKeyword2", ageKeyword2);
		map.put("dateKeyword1", dateKeyword1);
		map.put("dateKeyword2", dateKeyword2);

		int totalRowCnt = service.memCount(map); // 전체 글의 개수
		PageUtil pu = new PageUtil(pageNum, totalRowCnt, 20, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());

		ModelAndView mv = new ModelAndView();
		List<MembersVO> list = service.memList(map);
		mv.addObject("list", list);
		mv.addObject("infoField", infoField);
		mv.addObject("infoKeyword", infoKeyword);
		mv.addObject("ageKeyword1", ageKeyword1);
		mv.addObject("ageKeyword2", ageKeyword2);
		mv.addObject("dateKeyword1", dateKeyword1);
		mv.addObject("dateKeyword2", dateKeyword2);
		mv.addObject("pu", pu);
		mv.setViewName(".membersList");
		return mv;
	}

	// 탈퇴회원
	@RequestMapping("/ghostList")
	public ModelAndView ghostList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, String infoField,
			String infoKeyword, String ageKeyword1,
			@RequestParam(value = "ageKeyword2", defaultValue = "0") String ageKeyword2, String dateKeyword1,
			@RequestParam(value = "dateKeyword2", defaultValue = "0") String dateKeyword2) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		if (ageKeyword2.equals("0")) {
			ageKeyword2 = ageKeyword1;
		}

		if (dateKeyword2.equals("0")) {
			dateKeyword2 = dateKeyword1;
		}

		map.put("infoField", infoField);
		map.put("infoKeyword", infoKeyword);
		map.put("ageKeyword1", ageKeyword1);
		map.put("ageKeyword2", ageKeyword2);
		map.put("dateKeyword1", dateKeyword1);
		map.put("dateKeyword2", dateKeyword2);

		int totalRowCnt = service.ghostCount(map); // 전체 글의 개수
		PageUtil pu = new PageUtil(pageNum, totalRowCnt, 20, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());

		ModelAndView mv = new ModelAndView();
		List<MembersVO> list = service.ghostList(map);
		mv.addObject("list", list);
		mv.addObject("infoField", infoField);
		mv.addObject("infoKeyword", infoKeyword);
		mv.addObject("ageKeyword1", ageKeyword1);
		mv.addObject("ageKeyword2", ageKeyword2);
		mv.addObject("dateKeyword1", dateKeyword1);
		mv.addObject("dateKeyword2", dateKeyword2);
		mv.addObject("pu", pu);
		mv.setViewName(".ghostList");
		return mv;
	}

	// 회원 상세 조회
	@RequestMapping("/memInfo")
	public String memInfo(Model model, int mnum) {
		MembersVO vo = service.memInfo(mnum);
		model.addAttribute("vo", vo);
		return ".memInfo";
	}

	// 탈퇴회원 상세 조회
	@RequestMapping("/ghostInfo")
	public String ghostInfo(Model model, int mnum) {
		MembersVO vo = service.ghostInfo(mnum);
		model.addAttribute("vo", vo);
		return ".ghostInfo";
	}

	// 엑셀 다운로드 메소드
	@RequestMapping("/membersExcelDownload")
	public void membersExcelDownload(HttpServletResponse res) throws Exception {
		List<MembersVO> list = service.excelMemList();
		Workbook wb = new HSSFWorkbook(); // 워크북 생성
		Sheet sheet = wb.createSheet("유저데이터");// 시트 생성

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
		headerCell.setCellValue("이름");
		headerCell = headerRow.createCell(2);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("아이디");
		headerCell = headerRow.createCell(3);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("비밀번호");
		headerCell = headerRow.createCell(4);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("이메일");
		headerCell = headerRow.createCell(5);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("전화번호");
		headerCell = headerRow.createCell(6);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("주소");
		headerCell = headerRow.createCell(7);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("가입일");
		headerCell = headerRow.createCell(8);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("등급");
		headerCell = headerRow.createCell(9);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("생년월일");
		headerCell = headerRow.createCell(10);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("성별");

		// 바디(값)
		Row bodyRow = null;
		Cell bodyCell = null;

		for (int i = 0; i < list.size(); i++) {
			MembersVO vo = list.get(i);
			bodyRow = sheet.createRow(i + 1);
			bodyCell = bodyRow.createCell(0);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMnum());
			bodyCell = bodyRow.createCell(1);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMname());
			bodyCell = bodyRow.createCell(2);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMid());
			bodyCell = bodyRow.createCell(3);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMpwd());
			bodyCell = bodyRow.createCell(4);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getEmail());
			bodyCell = bodyRow.createCell(5);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getPhone());
			bodyCell = bodyRow.createCell(6);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getAddr());
			bodyCell = bodyRow.createCell(7);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()));
			bodyCell = bodyRow.createCell(8);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getGrade());
			bodyCell = bodyRow.createCell(9);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(vo.getBirth()));
			bodyCell = bodyRow.createCell(10);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getSex());
		}
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment;filename=members_Data.xls");
		wb.write(res.getOutputStream());
		wb.close();
	}

	// 엑셀 다운로드 메소드
	@RequestMapping("/excelGhostList")
	public void excelGhostList(HttpServletResponse res) throws Exception {
		List<MembersVO> list = service.excelGhostList();
		Workbook wb = new HSSFWorkbook(); // 워크북 생성
		Sheet sheet = wb.createSheet("탈퇴회원데이터");// 시트 생성

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
		headerCell.setCellValue("이름");
		headerCell = headerRow.createCell(2);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("아이디");
		headerCell = headerRow.createCell(3);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("비밀번호");
		headerCell = headerRow.createCell(4);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("이메일");
		headerCell = headerRow.createCell(5);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("전화번호");
		headerCell = headerRow.createCell(6);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("주소");
		headerCell = headerRow.createCell(7);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("가입일");
		headerCell = headerRow.createCell(8);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("등급");
		headerCell = headerRow.createCell(9);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("생년월일");
		headerCell = headerRow.createCell(10);
		headerCell.setCellStyle(headStyle); // 스타일 적용
		headerCell.setCellValue("성별");

		// 바디(값)
		Row bodyRow = null;
		Cell bodyCell = null;

		for (int i = 0; i < list.size(); i++) {
			MembersVO vo = list.get(i);
			bodyRow = sheet.createRow(i + 1);
			bodyCell = bodyRow.createCell(0);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMnum());
			bodyCell = bodyRow.createCell(1);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMname());
			bodyCell = bodyRow.createCell(2);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMid());
			bodyCell = bodyRow.createCell(3);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getMpwd());
			bodyCell = bodyRow.createCell(4);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getEmail());
			bodyCell = bodyRow.createCell(5);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getPhone());
			bodyCell = bodyRow.createCell(6);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getAddr());
			bodyCell = bodyRow.createCell(7);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()));
			bodyCell = bodyRow.createCell(8);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getGrade());
			bodyCell = bodyRow.createCell(9);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(vo.getBirth()));
			bodyCell = bodyRow.createCell(10);
			bodyCell.setCellStyle(bodyStyle); // 스타일 적용
			bodyCell.setCellValue(vo.getSex());
		}
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment;filename=ghostMem_Data.xls");
		wb.write(res.getOutputStream());
		wb.close();
	}

}
