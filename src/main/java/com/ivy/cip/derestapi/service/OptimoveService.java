package com.ivy.cip.derestapi.service;

import com.ivy.cip.derestapi.entity.Optimove;

import java.util.List;

public interface OptimoveService {


    List<Optimove> addCustomerAttributes();

    List<Optimove> getPageCustomerAttributes(int pageNumber, int pageSize);

    List<Optimove> getPageCustomerAttributesByBrand(int pageNumber, int pageSize, String brand);

}
