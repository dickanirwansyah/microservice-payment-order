package com.dicka.kafka.orderservice.controller;

import com.dicka.kafka.orderservice.entity.Order;
import com.dicka.kafka.orderservice.model.TransactionRequest;
import com.dicka.kafka.orderservice.model.TransactionResponse;
import com.dicka.kafka.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/book-order")
    public Order bookOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PostMapping(value = "/check-out-order")
    public TransactionResponse checkOutOrder(@RequestBody TransactionRequest transactionRequest){
        return orderService.checkOut(transactionRequest);
    }
}
