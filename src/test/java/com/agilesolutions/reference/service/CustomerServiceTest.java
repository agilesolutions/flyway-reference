package com.agilesolutions.reference.service;

import com.agilesolutions.reference.dao.CustomerDao;
import com.agilesolutions.reference.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService customerService;

    /**
     * Initializes mocks before each test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCustomers() {

        when(customerDao.getCustomers()).thenReturn(List.of(Customer.builder().id(1).name("Rob").build()));

        List<Customer> customers = customerService.getCustomers();

        assertNotNull(customers);
        assertEquals(1, customers.size());
        assertEquals("Rob", customers.get(0).name());




    }
}