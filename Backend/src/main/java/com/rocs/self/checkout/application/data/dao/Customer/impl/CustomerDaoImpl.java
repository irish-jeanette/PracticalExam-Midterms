package com.rocs.self.checkout.application.data.dao.Customer.impl;

import com.rocs.self.checkout.application.data.connection.ConnectionHelper;
import com.rocs.self.checkout.application.data.dao.Customer.CustomerDao;
import com.rocs.self.checkout.application.data.dao.utils.querycontants.QueryConstants;
import com.rocs.self.checkout.application.data.model.Customer;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    private final QueryConstants queryConstants = new QueryConstants();

    @Override
    public Customer findById(String CustomerID) {
        String query = queryConstants.getFindCustomerByIdQuery();
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, CustomerID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Customer(resultSet.getString("CustomerID"), resultSet.getString("CustomerName"), resultSet.getString("Address"), resultSet.getString("ContactNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

