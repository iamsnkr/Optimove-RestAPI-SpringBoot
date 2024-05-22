package com.ivy.cip.derestapi.collection;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustAttributes {


    private String attribute;
    public CustAttributes(String attribute) {
        this.attribute = attribute;
    }
}
