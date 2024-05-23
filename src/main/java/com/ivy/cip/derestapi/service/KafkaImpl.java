package com.ivy.cip.derestapi.service;


import com.ivy.cip.derestapi.collection.UseCaseAndTopics;
import com.ivy.cip.derestapi.entity.KafkaRecords;
import com.ivy.cip.derestapi.entity.Optimove;
import com.ivy.cip.derestapi.repository.KafkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class KafkaImpl implements KafkaService{

    int start = 0;

    @Autowired
    KafkaRepository kafkaRepository;

    @Override
    public List<Optimove> getOptimoveData(int start, int size, String brand) {
        RestTemplate restTemplate = new RestTemplate();
        String optimoveURL= "http://localhost:8080/api/optimove/optimovelistwithbrand?page="+start+"&size="+size+"&brand="+brand;
        Optimove[] optimoveArray = restTemplate.getForObject(optimoveURL, Optimove[].class);
        return Arrays.asList(optimoveArray);
    }

    @Override
    public List<UseCaseAndTopics> getUseCaseAndTopics() {
        RestTemplate restTemplate = new RestTemplate();
        String usecaseAndTopicsURL= "http://localhost:8080/api/usecase/topics/data";
        UseCaseAndTopics[] useCaseAndTopicsArray = restTemplate.getForObject(usecaseAndTopicsURL, UseCaseAndTopics[].class);
        return Arrays.asList(useCaseAndTopicsArray);
    }


    @Override
    public List<KafkaRecords> generateKafkaData() {

        List<UseCaseAndTopics> getUseCaseAndTopicsList = getUseCaseAndTopics();
        for ( UseCaseAndTopics usecaseAndTopic : getUseCaseAndTopicsList) {
            List<String> brands = usecaseAndTopic.getCustomerAttrs();
            for (String brand : brands) {
                fetchAndUpdateData(brand);
            }

        }
        return kafkaRepository.findAll();
    }



    private void fetchAndUpdateData(String brand) {
        List<Optimove> optimoveData;
        int size = 2;
        do {
            optimoveData = getOptimoveData(start, size, brand);
            System.out.println(
                    "The Values coming from get Call is " + optimoveData
            );
            for (Optimove optiObject : optimoveData) {
                KafkaRecords kafkaRecord = new KafkaRecords(
                        optiObject.getCustomerAttributes(),
                        optiObject.getCustomerID(),
                        optiObject.getFinalCustomerAttribute()
                );
                kafkaRepository.save(kafkaRecord);


            }
            System.out.println("Start  before " + start);
            start++;
            System.out.println("Start after " + start);


        } while (!optimoveData.isEmpty());
        start = 0;

    }

}
