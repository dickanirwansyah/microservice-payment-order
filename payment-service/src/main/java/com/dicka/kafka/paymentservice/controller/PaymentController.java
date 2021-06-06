package com.dicka.kafka.paymentservice.controller;

import com.dicka.kafka.paymentservice.entity.Payment;
import com.dicka.kafka.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/do-payment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }
}
