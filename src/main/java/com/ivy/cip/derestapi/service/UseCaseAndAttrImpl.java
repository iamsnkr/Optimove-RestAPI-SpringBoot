package com.ivy.cip.derestapi.service;

import com.ivy.cip.derestapi.collection.UseCaseAndTopics;
import com.ivy.cip.derestapi.repository.UseCaseAndAttrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UseCaseAndAttrImpl implements UseCaseAndAttrService {

    @Autowired
    private UseCaseAndAttrRepo useCaseAndAttrRepo;


    @Override
    public List<UseCaseAndTopics> save() {
        List<UseCaseAndTopics> useCaseAndTopicsList = new ArrayList<>();
        List<String> custAttributesList = new ArrayList<>();
        custAttributesList.add("casino");
        custAttributesList.add("poker");

        for (int i = 0; i < 5; i++) {

            UseCaseAndTopics UseCaseAndTopic = new UseCaseAndTopics("random" + i, "Optimove",
                    "kafka.topic.cip", "lcg_optimove",
                    "user_product_prefrence", custAttributesList);

            if (i >= 3) {
                UseCaseAndTopic.setOptimoveInstance("gvc_optimove");
            }

            useCaseAndTopicsList.add(UseCaseAndTopic);
            useCaseAndAttrRepo.save(UseCaseAndTopic);
        }
        return useCaseAndTopicsList;

    }

    @Override
    public List<UseCaseAndTopics> getUseCaseData() {
        save();
        return useCaseAndAttrRepo.findAll();
    }
}


