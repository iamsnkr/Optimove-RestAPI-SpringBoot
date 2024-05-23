package com.ivy.cip.derestapi.controller;


import com.ivy.cip.derestapi.entity.Optimove;
import com.ivy.cip.derestapi.service.OptimoveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptimoveController {

    @Autowired
    OptimoveImpl optimoveImpl;
    @GetMapping("/save")
    List<Optimove> getOpptimoveDataList(){
      return optimoveImpl.addCustomerAttributes();
    }

    @GetMapping("/optimovelist")
    public List<Optimove> getOptimoveList(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") int size){
       // ObjectMapper
        return optimoveImpl.getPageCustomerAttributes(page, size);
    }


    @GetMapping("/optimovelistwithbrand")
    public List<Optimove> getOptimoveList(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "size") int size,
            @RequestParam(name = "brand") String brand){
        // ObjectMapper
        return optimoveImpl.getPageCustomerAttributesByBrand(page, size, brand);
    }


  /*  @Autowired
    MongoDBService mongoDBService;
    @GetMapping("/mongodbsave")
    List<MongoDBCollection> getMongoDbDataList(){
        return mongoDBService.addCustomerAttributes();
    }


    @GetMapping("/mongodetails")
    List<MongoDBCollection> getDbDataList(){
        return mongoDBService.getDbDetails();
    }


    @GetMapping("/finalpayload")
    List<KafkaRecords> getKafkaDetails(){
       getOpptimoveDataList();
       getMongoDbDataList();
        Long startTime = System.currentTimeMillis();
        System.out.println("=============================================================");
        List<KafkaRecords> kafkaRecords = mongoDBService.generateKafkaData();
        System.out.println("=============================================================");
        System.out.println(System.currentTimeMillis() - startTime + " Time took to process " + kafkaRecords.size());

        return kafkaRecords;
    }
*/
}
