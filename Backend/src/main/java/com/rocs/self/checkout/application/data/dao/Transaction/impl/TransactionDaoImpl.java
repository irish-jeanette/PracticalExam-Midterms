package com.rocs.self.checkout.application.data.dao.Transaction.impl;

import com.rocs.self.checkout.application.data.connection.ConnectionHelper;
import com.rocs.self.checkout.application.data.dao.Transaction.TransactionDao;
import com.rocs.self.checkout.application.data.dao.utils.querycontants.QueryConstants;
import com.rocs.self.checkout.application.data.model.ItemQuantity;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class TransactionDaoImpl implements TransactionDao{

    private static final Logger logger = Logger.getLogger(TransactionDaoImpl.class.getName());
    private final QueryConstants queryConstants = new QueryConstants();

    @Override
    public boolean saveTransaction(int TransactionID, String CustomerID, String TransDate, List<ItemQuantity> items) {
        String insertTransaction = queryConstants.getInsertTransactionQuery();
        String insertDetails = queryConstants.getInsertTransactionDetailsQuery();

        try (Connection connection = ConnectionHelper.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement stmt1 = connection.prepareStatement(insertTransaction);
                 PreparedStatement stmt2 = connection.prepareStatement(insertDetails)) {

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
                connection.commit();
                logger.info("Transaction saved: " + TransactionID);
                return true;

            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
