package com.rocs.self.checkout.application.data.model;

public class Item {
    private String itemID;
    private String itemDesc;
    private double unitPrice;

    public Item(String itemID, String itemDesc, double unitPrice) {
        this.itemID = itemID;
        this.itemDesc = itemDesc;
        this.unitPrice = unitPrice;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}