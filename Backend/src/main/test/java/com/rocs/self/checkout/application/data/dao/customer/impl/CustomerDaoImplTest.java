package com.rocs.self.checkout.application.data.dao.customer.impl;

import com.rocs.self.checkout.application.data.dao.Customer.CustomerDao;
import com.rocs.self.checkout.application.data.dao.Customer.impl.CustomerDaoImpl;
import com.rocs.self.checkout.application.data.model.Customer;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerDaoImplTest {

    private static CustomerDao customerDao;

    @BeforeAll
    static void setup() {
        customerDao = new CustomerDaoImpl();

        Customer existing = customerDao.findById("C001");
        if (existing == null) {

        }
    }

    @Test
    @Order(1)
    void testFindById_existingCustomer() {
        String testCustomerId = "C001";
        Customer customer = customerDao.findById(testCustomerId);
        Assertions.assertNotNull(customer, "Customer should not be null");
        Assertions.assertEquals(testCustomerId, customer.getCustomerID());
        Assertions.assertEquals("Test Customer", customer.getCustomerName());
    }

    @Test
    @Order(2)
    void testFindById_nonExistingCustomer() {
        String testCustomerId = "NON_EXISTENT";
        Customer customer = customerDao.findById(testCustomerId);
        Assertions.assertNull(customer, "Customer should be null for non-existing ID");
    }
}
