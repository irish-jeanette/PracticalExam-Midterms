package com.rocs.self.checkout.application.data.dao.Customer.impl;

import com.rocs.self.checkout.application.data.connection.ConnectionHelper;
import com.rocs.self.checkout.application.data.dao.Customer.CustomerDao;
import com.rocs.self.checkout.application.data.model.Customer;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {
    public Customer findById(String id) {
        String query = "SELECT * FROM Customers WHERE CustomerID = ?";
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString("CustomerID"),
                        rs.getString("CustomerName")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}