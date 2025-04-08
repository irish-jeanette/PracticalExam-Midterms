package com.rocs.self.checkout.application.data.dao.Transaction.impl;

import com.rocs.self.checkout.application.data.connection.ConnectionHelper;
import com.rocs.self.checkout.application.data.dao.Transaction.TransactionDao;
import com.rocs.self.checkout.application.data.model.ItemQuantity;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class TransactionDaoImpl implements TransactionDao {
    private static final Logger logger = Logger.getLogger(TransactionDaoImpl.class.getName());

    public boolean saveTransaction(int TransactionID, String CustomerID, String TransDate, List<ItemQuantity> items) {
        String insertTransaction = "INSERT INTO Transactions (TransactionID, CustomerID, TransDate) VALUES (?, ?, ?));";
        String insertDetails = "INSERT INTO TransactionDetails (TransactionID, ItemID, quantity) VALUES (?, ?, ?);";

        try (Connection conn = ConnectionHelper.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(insertTransaction);
                 PreparedStatement stmt2 = conn.prepareStatement(insertDetails)) {

                stmt1.setInt(1, TransactionID);
                stmt1.setString(2, CustomerID);
                stmt1.setString(3, TransDate);
                stmt1.executeUpdate();

                for (ItemQuantity item : items) {
                    stmt2.setInt(1, TransactionID);
                    stmt2.setString(2, item.getItemId());
                    stmt2.setInt(3, item.getQuantity());
                    stmt2.addBatch();
                }
                stmt2.executeBatch();
                conn.commit();
                logger.info("Transaction saved: " + TransactionID);
                return true;

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
