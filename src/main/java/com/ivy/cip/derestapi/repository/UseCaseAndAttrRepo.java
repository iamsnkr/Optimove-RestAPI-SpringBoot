package com.ivy.cip.derestapi.repository;

import com.ivy.cip.derestapi.collection.UseCaseAndTopics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseCaseAndAttrRepo extends MongoRepository<UseCaseAndTopics, String> {

}
