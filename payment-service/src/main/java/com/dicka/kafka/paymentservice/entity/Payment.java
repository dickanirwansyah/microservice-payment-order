package com.dicka.kafka.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "transatcion_id")
    private String transactionId;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "amount")
    private BigDecimal amount;
}
