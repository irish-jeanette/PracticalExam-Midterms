package com.rocs.self.checkout.application.data.dao.Transaction;

import com.rocs.self.checkout.application.data.model.ItemQuantity;

import java.util.List;

public interface TransactionDao {
    boolean saveTransaction(int transId, String customerId, String date, List<ItemQuantity> items);
}
