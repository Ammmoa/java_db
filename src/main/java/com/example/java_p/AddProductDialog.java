package com.example.java_p;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProductDialog {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Add Product");

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label DescriptionLabel = new Label("Description:");
        TextField DescriptionField = new TextField();

        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();

        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();

        Label categoryLabel = new Label("Category ID:");
        TextField categoryField = new TextField();

        Label supplierLabel = new Label("Supplier ID:");
        TextField supplierField = new TextField();

        Button addButton = new Button("Add");

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String description = DescriptionField.getText();

            BigDecimal price = new BigDecimal(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            int categoryId = Integer.parseInt(categoryField.getText());
            int supplierId = Integer.parseInt(supplierField.getText());

            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "INSERT INTO products (product_name, description, price, in_stock, category_id, supplier_id) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, name);
                    statement.setString(2, description);
                    statement.setBigDecimal(3, price);
                    statement.setInt(4, quantity);
                    statement.setInt(5, categoryId);
                    statement.setInt(6, supplierId);
                    statement.executeUpdate();
                }
                stage.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        VBox vbox = new VBox(10, nameLabel, nameField, priceLabel, priceField, quantityLabel, quantityField, categoryLabel, categoryField, supplierLabel, supplierField, addButton);
        Scene scene = new Scene(vbox, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
