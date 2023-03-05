package com.jms.cache.SpringCache.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;
}
