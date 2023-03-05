package com.jms.cache.SpringCache.service;


import com.jms.cache.SpringCache.dto.CustomerDTO;
import com.jms.cache.SpringCache.entity.Customer;
import com.jms.cache.SpringCache.repository.CustomerRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Cacheable("customers")
    public List<CustomerDTO> all(){

        List<CustomerDTO> customers = new ArrayList<>();

        List<Customer> customerList = this.customerRepository.findAll();

        customerList.forEach(d ->{
            CustomerDTO dto = new CustomerDTO();
            dto.setCustomerId(d.getCustomerId());
            dto.setCustomerName(d.getCustomerName());

            customers.add(dto);
        });

        return customers;
    }

    @Caching(evict = {
            @CacheEvict(value = "customers", allEntries = true)
    })
    public void save(CustomerDTO dto){
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());

        this.customerRepository.save(customer);
    }

}
