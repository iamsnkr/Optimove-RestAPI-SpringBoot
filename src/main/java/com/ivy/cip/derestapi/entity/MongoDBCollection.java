/*
package com.ivy.cip.derestapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MONGODB")
public class MongoDBCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SOURCE")
    private String source;
    @Column(name = "DESTINATION")
    private String detination;
    @Column(name = "OPTIMOVE_INSTANCE")
    private String optimoveInstance;
    @Column(name = "USECASE")
    private String usecase;
    @Column(name = "CUSTOMER_ATTRS")
    private String customerAttrs;

    public MongoDBCollection(String source, String detination, String optimoveInstance, String usecase, String customerAttrs) {
        this.source = source;
        this.detination = detination;
        this.optimoveInstance = optimoveInstance;
        this.usecase = usecase;
        this.customerAttrs = customerAttrs;
    }
}
*/
