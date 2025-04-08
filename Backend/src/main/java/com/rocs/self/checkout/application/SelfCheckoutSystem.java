package com.rocs.self.checkout.application;

import com.rocs.self.checkout.application.app.facade.Transaction.impl.TransactionFacadeImpl;
import com.rocs.self.checkout.application.data.model.Customer;
import com.rocs.self.checkout.application.data.model.Item;
import com.rocs.self.checkout.application.data.model.ItemQuantity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelfCheckoutSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionFacadeImpl facade = new TransactionFacadeImpl();

        try {
            System.out.println("Welcome to Mini Grocery System");
            System.out.println("Choose an option:");
            System.out.println("1. Retrieve Item by ID");
            System.out.println("2. Retrieve Customer by ID");
            System.out.println("3. Save Transaction");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Item ID: ");
                    String ItemId = scanner.nextLine();
                    if (ItemId.length() == 1) {
                        ItemId = "0" + ItemId;
                    }
                    Item item = facade.findItemById(ItemId);
                    if (item != null) {
                        System.out.println("Description: " + item.getItemDesc());
                        System.out.println("Price: " + item.getUnitPrice());
                    } else {
                        System.out.println("Item not found.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter Customer ID: ");
                    String CustomerID = scanner.nextLine();
                    Customer customer = facade.findCustomerById(CustomerID);
                    if (customer != null) {
                        System.out.println("Name: " + customer.getCustomerName());
                        System.out.println("Address: " + customer.getAddress());
                        System.out.println("Contact: " + customer.getContactNumber());
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Transaction ID: ");
                    int transId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    List<ItemQuantity> items = new ArrayList<>();
                    System.out.print("How many items? ");
                    int itemCount = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < itemCount; i++) {
                        System.out.print("Enter Item ID: ");
                        String itemId = scanner.nextLine();
                        System.out.print("Enter Quantity: ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();
                        items.add(new ItemQuantity(itemId, qty));
                    }

                    if (facade.saveTransaction(transId, studentId, date, items)) {
                        System.out.println("Transaction saved successfully.");
                    } else {
                        System.out.println("Failed to save transaction.");
                    }
                }
                default -> System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

