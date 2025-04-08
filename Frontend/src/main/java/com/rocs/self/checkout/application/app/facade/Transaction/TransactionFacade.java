package com.rocs.self.checkout.application.app.facade.Transaction;

import com.rocs.self.checkout.application.data.model.Customer;
import com.rocs.self.checkout.application.data.model.Item;
import com.rocs.self.checkout.application.data.model.ItemQuantity;

import java.util.List;

public interface TransactionFacade {
    Item findItemById(String id);
    Customer findCustomerById(String id);
    boolean saveTransaction(int transId, String customerId, String date, List<ItemQuantity> items);
}