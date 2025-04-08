package com.rocs.self.checkout.application.data.dao.transaction.impl;

import com.rocs.self.checkout.application.data.dao.Transaction.TransactionDao;
import com.rocs.self.checkout.application.data.dao.Transaction.impl.TransactionDaoImpl;
import com.rocs.self.checkout.application.data.model.ItemQuantity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

    public class TransactionDaoImplTest {

        private final TransactionDao transactionDao = new TransactionDaoImpl();

        @BeforeEach
        void setUp() {
        }

        @Test
        @Order(1)
        void testSaveTransaction_success() {
            int transactionId = UUID.randomUUID().toString().hashCode();
            String customerId = "C001";
            String date = "2024-04-12";

            List<ItemQuantity> items = Arrays.asList(
                    new ItemQuantity("01", 2),
                    new ItemQuantity("02", 1)
            );

            boolean result = transactionDao.saveTransaction(transactionId, customerId, date, items);
            assertTrue(result, "Transaction should be saved successfully");
        }
    }

