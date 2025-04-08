package com.rocs.self.checkout.application;

import com.rocs.self.checkout.application.data.model.Customer;
import com.rocs.self.checkout.application.data.model.Item;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

public class SelfCheckoutController {
    @FXML private TextField customerIdField, customerNameField;
    @FXML private TextField itemIdField, descriptionField, priceField, quantityField;
    @FXML private TableView<Item> cartTable;
    @FXML private TableColumn<Item, String> colItemId, colDescription;
    @FXML private TableColumn<Item, Double> colPrice;
    @FXML private TableColumn<Item, Integer> colQuantity;

    private ObservableList<Item> cartItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colItemId.setCellValueFactory(cellData -> cellData.getValue().itemIdProperty());
        colDescription.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        colPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        colQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());

        cartTable.setItems(cartItems);
    }

    @FXML
    private void onCustomerIdEnter() {
        String id = customerIdField.getText().trim();
        Customer customer = MockDatabase.getCustomerById(id);
        if (customer != null) {
            customerNameField.setText(customer.getCustomerName());
        } else {
            showAlert("Customer not found.");
        }
    }

    @FXML
    private void onItemIdEnter() {
        String id = itemIdField.getText().trim();
        Item item = MockDatabase.getItemById(id);
        if (item != null) {
            descriptionField.setText(item.getDescription());
            priceField.setText(String.valueOf(item.getPrice()));
        } else {
            showAlert("Item not found.");
        }
    }

    @FXML
    private void onAddToCart() {
        try {
            String itemId = itemIdField.getText();
            String description = descriptionField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            cartItems.add(new Item(itemId, description, price));
            clearItemFields();
        } catch (Exception e) {
            showAlert("Please check all fields and ensure valid data.");
        }
    }

    @FXML
    private void onCheckout() {
        double total = cartItems.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        showAlert("Total amount to pay: $" + total);
    }

    private void clearItemFields() {
        itemIdField.clear();
        descriptionField.clear();
        priceField.clear();
        quantityField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

