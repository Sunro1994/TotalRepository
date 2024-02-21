package com.eazybytes.repository;


import com.eazybytes.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CustomerRepository extends CrudRepository<Customer,Long> {

    List<Customer> findByEmail(String email); //명명규칙을 통해 추상 메서드생성

    }
