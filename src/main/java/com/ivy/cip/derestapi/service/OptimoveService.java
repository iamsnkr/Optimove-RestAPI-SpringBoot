package com.ivy.cip.derestapi.service;

import com.ivy.cip.derestapi.entity.Optimove;
import com.ivy.cip.derestapi.repository.OptimoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OptimoveService {

        @Autowired
        OptimoveRepository optimoveRepository;

        public List<Optimove> addCustomerAttributes(){
           List<Optimove> optimoveList = new ArrayList<>();
            for (int i = 0; i < 25; i++) {
                int custid = (int) (Math.random()*8788651);
                List<String> custAttributes = Arrays.asList("cl_user1"+custid);
                Optimove optimove  = new Optimove(15+i,
                        ""+custid+"", "",
                        "casino", custAttributes.toString().substring(1,custAttributes.toString().length()-1));
                if( i >= 5){
                    optimove.setFinalCustomerAttribute("poker");
                }

                optimoveList.add(optimoveRepository.save(optimove));
                }
            return optimoveList;
        }

    public List<Optimove> getPageCustomerAttributes(int pageNumber, int pageSize) {
        return optimoveRepository.findAll(PageRequest.of(
                pageNumber,
                pageSize)).getContent();

    }


    public List<Optimove> getPageCustomerAttributesByBrand(int pageNumber, int pageSize, String brand) {
            return optimoveRepository.findAllByFinalCustomerAttribute(brand, PageRequest.of(
                    pageNumber,
                    pageSize));

        }
}
