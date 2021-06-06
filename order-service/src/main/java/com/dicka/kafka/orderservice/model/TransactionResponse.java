package com.dicka.kafka.orderservice.model;

import com.dicka.kafka.orderservice.entity.Order;
import com.dicka.kafka.orderservice.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;
    private Payment payment;
    private String transactionId;
    private String statusPayment;
}
