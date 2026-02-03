package com.agilesolutions.reference.service;

import com.agilesolutions.reference.dao.CustomerDao;
import com.agilesolutions.reference.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    public List<Customer> getCustomers()  {

        return customerDao.getCustomers();

        //return List.of(Customer.builder().build());

    }



}
