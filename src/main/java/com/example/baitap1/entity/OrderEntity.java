package com.example.baitap1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "orders")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "total_amount")
    private double totalAmount;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
