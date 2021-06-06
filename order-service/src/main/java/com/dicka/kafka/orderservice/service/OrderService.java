package com.dicka.kafka.orderservice.service;

import com.dicka.kafka.orderservice.entity.Order;
import com.dicka.kafka.orderservice.entity.Payment;
import com.dicka.kafka.orderservice.model.TransactionRequest;
import com.dicka.kafka.orderservice.model.TransactionResponse;
import com.dicka.kafka.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_PAYMENT = "http://localhost:8889/api/payment/do-payment";

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    /** checkout transaction **/
    public TransactionResponse checkOut(TransactionRequest transactionRequest){
        Order order = transactionRequest.getOrder();
        Order responseOrder = orderRepository.save(order);

        Payment payment = transactionRequest.getPayment();
        double amount = order.getQty() * order.getPrice().doubleValue();
        payment.setAmount(new BigDecimal(amount));
        payment.setOrderId(responseOrder.getId());

        //rest call
        Payment responsePayment = restTemplate.postForObject(API_PAYMENT, payment, Payment.class);
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setOrder(responseOrder);
        transactionResponse.setPayment(responsePayment);
        transactionResponse.setStatusPayment(responsePayment.getPaymentStatus());
        transactionResponse.setTransactionId(responsePayment.getTransactionId());


        //update status order
        responseOrder.setStatusOrder(responsePayment.getPaymentStatus().equals("success") ? "checkout_success" : "checkout_failed");
        orderRepository.save(responseOrder);
        return transactionResponse;
    }
}
