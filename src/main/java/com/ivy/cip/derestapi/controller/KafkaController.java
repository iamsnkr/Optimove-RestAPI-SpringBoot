package com.ivy.cip.derestapi.controller;


import com.ivy.cip.derestapi.entity.KafkaRecords;
import com.ivy.cip.derestapi.service.KafkaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
@Api(tags = "kafka Controller")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/kafkadata")
    List<KafkaRecords> getKafkaData(){
        Long startTime = System.currentTimeMillis();
        System.out.println("=============================================================");
        List<KafkaRecords> kafkaRecords = kafkaService.generateKafkaData();
        System.out.println("=============================================================");
        System.out.println(System.currentTimeMillis() - startTime + " Time took to process " + kafkaRecords.size());

        return kafkaRecords;
    }

}
