package com.ivy.cip.derestapi.service;

import com.ivy.cip.derestapi.collection.UseCaseAndTopics;
import com.ivy.cip.derestapi.entity.KafkaRecords;
import com.ivy.cip.derestapi.entity.Optimove;

import java.util.List;

public interface KafkaService {

    List<Optimove> getOptimoveData(int start, int size, String brand);

    List<UseCaseAndTopics> getUseCaseAndTopics();

    List<KafkaRecords> generateKafkaData();


}
