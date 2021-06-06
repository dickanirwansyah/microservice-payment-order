package com.dicka.kafka.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long orderId;
    private BigDecimal amount;
    private String transactionId;
    private String paymentStatus;
}
