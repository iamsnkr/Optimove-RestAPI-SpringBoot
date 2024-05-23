package com.ivy.cip.derestapi.repository;

import com.ivy.cip.derestapi.entity.KafkaRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepository extends JpaRepository<KafkaRecords, Integer> {
}
