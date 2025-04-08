package com.rocs.self.checkout.application.data.model;

public class Customer {
    private String CustomerID;
    private String CustomerName;
    private String Address;
    private String ContactNumber;

    public Customer(String CustomerID, String CustomerName, String address, String contactNumber) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
    }

    public String getCustomerID() { return CustomerID; }
    public String getCustomerName() { return CustomerName; }
    public String getAddress() { return Address; }
    public String getContactNumber() { return ContactNumber; }
}
