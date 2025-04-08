package com.rocs.self.checkout.application.data.dao.item.impl;

import com.rocs.self.checkout.application.data.dao.Item.ItemDao;
import com.rocs.self.checkout.application.data.dao.Item.impl.ItemDaoImpl;
import com.rocs.self.checkout.application.data.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemDaoImplTest {

    private ItemDao itemDao;

    @BeforeEach
    void setup() {
        itemDao = new ItemDaoImpl();
    }

    @Test
    @Order(1)
    void testFindById_existingItem() {

        String testItemId = "01";

        Item item = itemDao.findById(testItemId);

        assertNotNull(item, "Item should not be null");
        assertEquals(testItemId, item.getItemID(), "Item ID should match");
        assertEquals("Test Item 01", item.getItemDesc(), "Item description should match");
        assertEquals(15.99, item.getUnitPrice(), 0.01, "Item price should match");
    }

    @Test
    @Order(2)
    void testFindById_nonExistingItem() {
        String testItemId = "NON_EXISTENT";

        Item item = itemDao.findById(testItemId);

        assertNull(item, "Item should be null for non-existing ID");
    }
}

