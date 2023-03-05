package com.jms.cache.SpringCache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jms.cache.SpringCache.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Transactional
    @Override
    List<Customer> findAll();

}
