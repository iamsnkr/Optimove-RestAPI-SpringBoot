package com.ivy.cip.derestapi.service;

import com.ivy.cip.derestapi.entity.Optimove;
import com.ivy.cip.derestapi.repository.OptimoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OptimoveImpl implements OptimoveService {

    @Autowired
    OptimoveRepository optimoveRepository;

    @Override
    public List<Optimove> addCustomerAttributes() {
        List<Optimove> optimoveList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            int custid = (int) (Math.random() * 8788651);
            List<String> custAttributes = Arrays.asList("cl_user1" + custid);
            Optimove optimove = new Optimove(15 + i,
                    "" + custid + "", "",
                    "casino", custAttributes.toString().substring(1, custAttributes.toString().length() - 1));
            if (i >= 5) {
                optimove.setFinalCustomerAttribute("poker");
            }

            optimoveList.add(optimoveRepository.save(optimove));
        }
        return optimoveList;
    }

    @Override
    public List<Optimove> getPageCustomerAttributes(int pageNumber, int pageSize) {
        return optimoveRepository.findAll(PageRequest.of(
                pageNumber,
                pageSize)).getContent();

    }

    @Override
    public List<Optimove> getPageCustomerAttributesByBrand(int pageNumber, int pageSize, String brand) {
        addCustomerAttributes();
        return optimoveRepository.findAllByFinalCustomerAttribute(brand, PageRequest.of(
                pageNumber,
                pageSize));

    }
}
