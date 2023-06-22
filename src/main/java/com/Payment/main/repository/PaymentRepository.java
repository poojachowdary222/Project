package com.Payment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Payment.main.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

}
