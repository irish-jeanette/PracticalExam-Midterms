package com.rocs.self.checkout.application.data.dao.Item.impl;

import com.rocs.self.checkout.application.data.connection.ConnectionHelper;
import com.rocs.self.checkout.application.data.dao.Item.ItemDao;
import com.rocs.self.checkout.application.data.dao.utils.querycontants.QueryConstants;
import com.rocs.self.checkout.application.data.model.Item;

import java.sql.*;

public class ItemDaoImpl implements ItemDao {

    private final QueryConstants queryConstants = new QueryConstants();

    @Override
    public Item findById(String ItemID) {
        String query = queryConstants.getFindItemByIdQuery();
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, ItemID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Item(resultSet.getString("ItemID"), resultSet.getString("ItemDesc"), resultSet.getDouble("UnitPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}



