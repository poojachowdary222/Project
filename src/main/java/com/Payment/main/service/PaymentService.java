package com.Payment.main.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.Payment.main.entity.Payment;
import com.Payment.main.exception.InvalidPaymentId;

@Service

public interface PaymentService {

	public Payment insertPayment(Payment payment)throws Exception;
	public List<Payment> getAllPayments()throws Exception;	
	public Payment updatePayment(Payment payment)throws Exception;
	public void deletePayment(int pId) throws InvalidPaymentId;


}
