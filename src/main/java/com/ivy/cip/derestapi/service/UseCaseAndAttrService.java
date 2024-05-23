package com.ivy.cip.derestapi.service;

import com.ivy.cip.derestapi.collection.UseCaseAndTopics;
import com.ivy.cip.derestapi.entity.Optimove;

import java.util.List;

public interface UseCaseAndAttrService {
    List<UseCaseAndTopics> save();


    List<UseCaseAndTopics> getUseCaseData();

}
