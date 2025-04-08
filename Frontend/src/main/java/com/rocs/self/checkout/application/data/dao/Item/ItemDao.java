package com.rocs.self.checkout.application.data.dao.Item;

import com.rocs.self.checkout.application.data.model.Item;

public interface ItemDao {
    Item findById(String itemID);
}
