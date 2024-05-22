package com.ivy.cip.derestapi.repository;

import com.ivy.cip.derestapi.entity.Optimove;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptimoveRepository extends JpaRepository<Optimove, Integer> {

    List<Optimove> findAllByFinalCustomerAttribute(String brand, Pageable pageable);
}
