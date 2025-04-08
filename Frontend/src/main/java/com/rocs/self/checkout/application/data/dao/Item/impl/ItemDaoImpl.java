package com.rocs.self.checkout.application.data.dao.Item.impl;

import com.rocs.self.checkout.application.data.connection.ConnectionHelper;
import com.rocs.self.checkout.application.data.dao.Item.ItemDao;
import com.rocs.self.checkout.application.data.model.Item;

import java.sql.*;

public class ItemDaoImpl implements ItemDao {
    @Override
    public Item findById(String itemId) {
        Item item = null;
        try (Connection conn = ConnectionHelper.getConnection()) {
            String sql = "SELECT * FROM Items WHERE ItemID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, itemId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                item = new Item(
                        rs.getString("ItemID"),
                        rs.getString("ItemDesc"),
                        rs.getDouble("UnitPrice")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
