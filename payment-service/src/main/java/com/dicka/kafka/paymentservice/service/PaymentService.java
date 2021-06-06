package com.dicka.kafka.paymentservice.service;

import com.dicka.kafka.paymentservice.entity.Payment;
import com.dicka.kafka.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(isPaymentProcession());
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setTransactionDate(new Date());
        return paymentRepository.save(payment);
    }

    public String isPaymentProcession(){
        //bisa call pihak ke 3 seperti doku/midtrans atau yang lainnya
        return new Random().nextBoolean()? "success" : "false";
    }
}
