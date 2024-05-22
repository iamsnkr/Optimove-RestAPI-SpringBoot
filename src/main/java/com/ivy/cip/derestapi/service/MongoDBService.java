package com.ivy.cip.derestapi.service;

import com.ivy.cip.derestapi.entity.KafkaRecords;
import com.ivy.cip.derestapi.entity.MongoDBCollection;
import com.ivy.cip.derestapi.entity.Optimove;
import com.ivy.cip.derestapi.repository.KafkaRepository;
import com.ivy.cip.derestapi.repository.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MongoDBService {
    int start = 0;
    @Autowired
    MongoDBRepository mongoDBRepository;

    public List<MongoDBCollection> addCustomerAttributes(){
        List<MongoDBCollection> mongoDBList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> custAttributes = Arrays.asList("casino", "poker");
            MongoDBCollection mongoDb = new MongoDBCollection("Optimove",
                    "kafka.topic.cip", "lcg_optimove",
                    "user_product_prefrence", custAttributes.toString().substring(1, custAttributes.toString().length() - 1));

            if(i>=3){
                mongoDb.setOptimoveInstance("gvc_optimove");
            }
           // db.delete(mongoDb);
            mongoDBList.add(mongoDb);
            mongoDBRepository.save(mongoDb);
        }
        return mongoDBList;
    }

    public List<MongoDBCollection> getDbDetails(){
       return mongoDBRepository.findAll();
    }



    @Autowired
    KafkaRepository kafkaRepository;
    public List<KafkaRecords> generateKafkaData(){


        String mongoUrl = "http://localhost:8080/mongodetails";

        RestTemplate rest = new RestTemplate();
        MongoDBCollection[] mongoDb = rest.getForObject(mongoUrl, MongoDBCollection[].class);
        for(MongoDBCollection document: mongoDb){
              String[] brands = document.getCustomerAttrs().split(", ");
              for (String brand:brands){
                  String branding = "&brand="+brand;
                  fetchAndUpdateData(rest, branding);
              }

        }

        System.out.println(mongoDb);
        return  kafkaRepository.findAll();
    }

    private void fetchAndUpdateData(RestTemplate rest, String brand) {
        List<Optimove> optimoveData;
        int size =2;
        do{
            String optimoveURL= "http://localhost:8080/optimovelistwithbrand?page="+start+"&size="+size+brand;
            optimoveData = Arrays.asList(rest.getForObject(optimoveURL, Optimove[].class));
            System.out.println(
                    "The Values coming from get Call is " + optimoveData
            );
            for ( Optimove optiObject :optimoveData) {
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


        }while (!optimoveData.isEmpty());
        start=0;

    }


}
