package com.agilesolutions.reference.dao;

import com.agilesolutions.reference.dao.base.BasePGIntegrationTest;
import com.agilesolutions.reference.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringJUnitConfig(classes = {CustomerDao.class})
class CustomerDaoTest extends BasePGIntegrationTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    void getCustomerByName() {

        List<Customer> customers = customerDao.getCustomerByName("rob");
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
        for (Customer customer : customers) {
            assertEquals("John Doe", customer.name());

        }
    }

    @Test
    void getCustomers() {

        List<Customer> customers = customerDao.getCustomers();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());

    }
}