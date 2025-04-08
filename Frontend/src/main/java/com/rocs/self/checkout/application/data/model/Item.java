package com.rocs.self.checkout.application.data.model;

import javafx.beans.property.*;

public class Item {
    private final StringProperty itemId;
    private final StringProperty description;
    private final DoubleProperty price;
    private IntegerProperty quantity;

    public Item(String itemId, String description, double price) {
        this.itemId = new SimpleStringProperty(itemId);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleDoubleProperty(price);
        quantity = null;
        this.quantity = new SimpleIntegerProperty();
    }

    public StringProperty itemIdProperty() { return itemId; }
    public StringProperty descriptionProperty() { return description; }
    public DoubleProperty priceProperty() { return price; }
    public IntegerProperty quantityProperty() { return quantity; }

    public String getItemId() { return itemId.get(); }
    public String getDescription() { return description.get(); }
    public double getPrice() { return price.get(); }
    public int getQuantity() { return quantity.get(); }
}
