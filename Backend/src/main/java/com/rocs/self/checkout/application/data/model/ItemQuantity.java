package com.rocs.self.checkout.application.data.model;

public class ItemQuantity {
    private String itemId;
    private int quantity;

    public ItemQuantity(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
}
