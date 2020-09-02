package com.jhta.finalproject.yr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhta.finalproject.yr.vo.DepositVo;
import com.jhta.finalproject.yr.vo.PaymentBooksVo;
import com.jhta.finalproject.yr.vo.PaymentVo;
import com.jhta.finalproject.yr.vo.PointVo;

@Service
public interface CancelService {
	int makeCancelPayment(PaymentVo vo, List<PaymentBooksVo> booklist);
	int updateStatus(int bpaynum, List<Integer> paymentbookNumList, DepositVo dvo,PointVo pointVo);
}
