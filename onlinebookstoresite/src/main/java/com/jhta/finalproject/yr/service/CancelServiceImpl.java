package com.jhta.finalproject.yr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.finalproject.yr.dao.CSManageDao;
import com.jhta.finalproject.yr.dao.ReturnDao;
import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.PaymentBooksVo;
import com.jhta.finalproject.yr.vo.PaymentVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Service
public class CancelServiceImpl implements CancelService{
	
	@Autowired
	private CSManageDao dao;
	@Autowired
	private ReturnDao rdao;
	
	@Transactional
	@Override
	public int makeCancelPayment(PaymentVo vo, List<PaymentBooksVo> booklist) {
		
		
		dao.cancelPaymentInsert(vo);
		for (PaymentBooksVo booksVo : booklist) {
			dao.paymentbooksInsert(booksVo);			
		}
		return 1;
	}

	@Transactional
	@Override
	public int updateStatus(int bpaynum, List<Integer> paymentbookNumList,DepositVo dvo,PointVo pointVo) {
		//포인트 회수하기
		rdao.pointReturn(pointVo);
		//예치금입금
		rdao.giveDeposit(dvo);

		//원래 주문번호 상태 바꾸기
		dao.updateCancelStatus(bpaynum);
		//refundhistory에  status에 처리완료 상태로 업데이트
		for (Integer paymentbooknum : paymentbookNumList) {
			dao.updateRefundStatus(paymentbooknum);			
		}
		return 1;
	}	
}
