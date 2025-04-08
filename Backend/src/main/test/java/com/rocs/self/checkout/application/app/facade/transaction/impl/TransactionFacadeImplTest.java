package com.rocs.self.checkout.application.app.facade.transaction.impl;

import com.rocs.self.checkout.application.app.facade.Transaction.impl.TransactionFacadeImpl;
import com.rocs.self.checkout.application.data.model.Customer;
import com.rocs.self.checkout.application.data.model.Item;
import com.rocs.self.checkout.application.data.model.ItemQuantity;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionFacadeImplTest {

    private static TransactionFacadeImpl transactionFacade;

    @BeforeEach
    public void setup() {
        transactionFacade = new TransactionFacadeImpl();
    }

    @Test
    public void testFindItemById() {
        String testItemId = "01";

        Item item = transactionFacade.findItemById(testItemId);

        assertNotNull(item, "Item should not be null");
        assertEquals(testItemId, item.getItemID(), "Item ID should match");
    }

    @Test
    @Order(2)
    void testFindCustomerById() {
        String testCustomerId = "C001";
        Customer customer = transactionFacade.findCustomerById(testCustomerId);
        assertNotNull(customer, "Customer should not be null");
        assertEquals(testCustomerId, customer.getCustomerID());
    }

    @Test
    @Order(3)
    void testSaveTransaction() {
        int transactionId = UUID.randomUUID().toString().hashCode();
        String customerId = "C001";
        String date = "2024-04-12";

        List<ItemQuantity> items = Arrays.asList(
                new ItemQuantity("01", 2),
                new ItemQuantity("02", 1)
        );

        boolean result = transactionFacade.saveTransaction(transactionId, customerId, date, items);
        assertTrue(result, "Transaction should be saved successfully");

    }
}
