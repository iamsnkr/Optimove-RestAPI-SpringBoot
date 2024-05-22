package com.ivy.cip.derestapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "OPTIMOVEDATA")
@AllArgsConstructor
@NoArgsConstructor
public class Optimove {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="CUSTOMER_ID")
    private String customerID;
    @Column(name="INITIAL_CUSTOMER_ATTRIBUTE")
    private String initialCustomerAttribute;
    @Column(name="FINAL_CUSTOMER_ATTRIBUTE")
    private String finalCustomerAttribute;
    @Column(name="CUSTOMER_ATTRIBUTES")
    private String customerAttributes;

}
