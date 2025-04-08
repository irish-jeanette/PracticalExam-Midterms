package com.rocs.self.checkout.application.data.dao.utils.querycontants;

public class QueryConstants {

    public String getFindItemByIdQuery() {
        return "SELECT * FROM Items WHERE ItemID = ?";
    }

    public String getFindCustomerByIdQuery() {
        return "SELECT * FROM Customers WHERE CustomerID = ?";
    }

    public String getInsertTransactionQuery() {
        return "INSERT INTO transactions (TransactionID, CustomerID, TransDate) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
    }

    public String getInsertTransactionDetailsQuery() {
        return "INSERT INTO transaction_items (TransactionID, ItemID, Quantity) VALUES (?, ?, ?)";
    }
}

