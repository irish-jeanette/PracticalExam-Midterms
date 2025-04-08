package com.rocs.self.checkout.application;



import com.rocs.self.checkout.application.data.model.Customer;
import com.rocs.self.checkout.application.data.model.Item;

import java.util.*;

public class MockDatabase {
    private static final Map<String, Customer> customers = Map.of(
            "C001", new Customer("C001", "Alice"),
            "C002", new Customer("C002", "Bob")
    );

    private static final Map<String, Item> items = Map.of(
            "I001", new Item("I001", "Apple", 0.5),
            "I002", new Item("I002", "Banana", 0.3)
    );

    public static Customer getCustomerById(String id) {
        return customers.get(id);
    }

    public static Item getItemById(String id) {
        Item i = items.get(id);
        return (i == null) ? null : new Item(i.getItemId(), i.getDescription(), i.getPrice());
    }
}
