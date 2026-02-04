package com.agilesolutions.reference.dao;

import com.agilesolutions.reference.dao.base.BasePGIntegrationTest;
import com.agilesolutions.reference.model.Customer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {CustomerDao.class})
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class CustomerDaoTest extends BasePGIntegrationTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    @Disabled
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