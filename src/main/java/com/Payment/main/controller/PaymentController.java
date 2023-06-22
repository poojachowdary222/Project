package com.Payment.main.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Payment.main.entity.Payment;
import com.Payment.main.service.PaymentService;

@RestController  
@RequestMapping("/payment")
//@CrossOrigin(" http://localhost:4200/")
public class PaymentController {

    private static  Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;
    
 

    @PostMapping("/addPayment")
    public Payment insertPayment(@RequestBody Payment payment) {
       
    	
    	try {
            // Log a debug message
            logger.debug("Inserting payment: {}", payment);
            return paymentService.insertPayment(payment);
        } catch (Exception e) {
            // Log an error message with the stack trace
            logger.error("Error while inserting payment", e);
            e.printStackTrace();
        }
        return payment;
    } 

    @DeleteMapping("/deletePayment/{pId}")
    public String deletePayment(@PathVariable int pId) throws Exception {
        try {
            // Log an info message
            logger.info("Deleting payment with ID: {}", pId);
            paymentService.deletePayment(pId);
        } catch (Exception e) {
            // Log an error message with the stack trace
           // logger.error("Error while deleting payment with ID: " + pId, e);
            e.printStackTrace();
        }
        return "Deleted Id = " + pId + " Data";
    }

    @PutMapping("/updatePayment")
    public Payment updatePayment(@RequestBody Payment payment) throws Exception {
        // Log a debug message
        logger.debug("Updating payment: {}", payment);
      
        return paymentService.updatePayment(payment);
        
    }

    @GetMapping("/allPayments")
    public List<Payment> getAllPayments() throws Exception {
        // Log a debug message
        logger.debug("Retrieving all payments");
      
        return paymentService.getAllPayments(); 
    }

}