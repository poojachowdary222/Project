package com.Payment.main.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Payment.main.entity.Payment;
import com.Payment.main.exception.InvalidPaymentId;
import com.Payment.main.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
    
   private static  Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    PaymentRepository paymentRepository;

    public Payment insertPayment(Payment payment) throws Exception {
        logger.info("Inserting payment: {}", payment);
        return paymentRepository.save(payment);
    }
 
    @Override
    public List<Payment> getAllPayments() throws Exception {
        logger.info("Fetching all payments");
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment) throws Exception {
        logger.info("Updating payment: {}", payment);
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(int pId) throws InvalidPaymentId {
        logger.info("Deleting payment with ID: {}", pId);
        paymentRepository.deleteById(pId);
    }
}


	
	