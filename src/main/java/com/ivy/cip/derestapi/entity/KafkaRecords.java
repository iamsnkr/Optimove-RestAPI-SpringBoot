package com.ivy.cip.derestapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "KAFKA_TOPIC")
public class KafkaRecords {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "BRAND_TYPE")
    private String brand;
    @Column(name = "CUSTOMER")
    private String customer;

    public KafkaRecords(String customer, String accountName, String brand) {
        this.customer = customer;
        this.accountName = accountName;
        this.brand = brand;
    }
}
