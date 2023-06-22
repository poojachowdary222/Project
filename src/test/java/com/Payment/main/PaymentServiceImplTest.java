package com.Payment.main;


import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Payment.main.entity.Payment;
import com.Payment.main.exception.InvalidPaymentId;
import com.Payment.main.repository.PaymentRepository;
import com.Payment.main.service.PaymentServiceImpl;

import java.util.ArrayList;
import java.util.List;

// import static org.junit.Assert.assertThrows;
// import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceImplTest { 

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertPayment() throws Exception {
    	Payment payment = new Payment();
        payment.setpId(1);
        payment.setTotalAmount(10.5f);
        

        when(paymentRepository.save(payment)).thenReturn(payment);

        Payment result = paymentService.insertPayment(payment);

        assertNotNull(result); 
        assertEquals(payment, result);

        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    public void testGetAllPayments() throws Exception {
        List<Payment> paymentList = new ArrayList<>();
        paymentList.add(new Payment(1, 2, 11.6f));
        paymentList.add(new Payment(1, 2, 11.6f));

        when(paymentRepository.findAll()).thenReturn(paymentList);

        List<Payment> result = paymentService.getAllPayments();

        assertNotNull(result);
        assertEquals(paymentList, result);

        verify(paymentRepository, times(1)).findAll();
    }

    @Test
    public void testUpdatePayment() throws Exception {
        Payment payment = new Payment();
        payment.setpId(1);
        payment.setTotalAmount(10.5f);
       

        when(paymentRepository.existsById(payment.getpId())).thenReturn(true);
        when(paymentRepository.save(payment)).thenReturn(payment);

        Payment result = paymentService.updatePayment(payment);

        assertNotNull(result);
        assertEquals(payment, result);
    }

   

    @Test
    public void testDeletePayment() throws Exception {
        int paymentId = 1;

        when(paymentRepository.existsById(paymentId)).thenReturn(true);

assertDoesNotThrow(() -> paymentService.deletePayment(paymentId)); 

    }

  
}
