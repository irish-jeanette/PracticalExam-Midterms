package com.rocs.self.checkout.application.app.facade.Transaction.impl;

import com.rocs.self.checkout.application.app.facade.Transaction.TransactionFacade;
import com.rocs.self.checkout.application.data.dao.Customer.CustomerDao;
import com.rocs.self.checkout.application.data.dao.Customer.impl.CustomerDaoImpl;
import com.rocs.self.checkout.application.data.dao.Item.ItemDao;
import com.rocs.self.checkout.application.data.dao.Item.impl.ItemDaoImpl;
import com.rocs.self.checkout.application.data.dao.Transaction.TransactionDao;
import com.rocs.self.checkout.application.data.dao.Transaction.impl.TransactionDaoImpl;
import com.rocs.self.checkout.application.data.model.Customer;
import com.rocs.self.checkout.application.data.model.Item;
import com.rocs.self.checkout.application.data.model.ItemQuantity;

import java.util.List;

public class TransactionFacadeImpl implements TransactionFacade {
    private final ItemDao itemDao = new ItemDaoImpl();
    private final CustomerDao customerDao = new CustomerDaoImpl();
    private final TransactionDao transactionDao = new TransactionDaoImpl();

    public Item findItemById(String ItemID) {
        return itemDao.findById(ItemID);
    }

    public Customer findCustomerById(String CustomerID) {
        return customerDao.findById(CustomerID);
    }

    public boolean saveTransaction(int TransactionID, String CustomerID, String TransDate, List<ItemQuantity> items) {
        return transactionDao.saveTransaction(TransactionID, CustomerID, TransDate, items);
    }

}

