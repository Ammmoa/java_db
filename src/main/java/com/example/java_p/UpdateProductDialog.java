package com.example.java_p;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProductDialog {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Update Product Quantity");

        Label productIdLabel = new Label("Product ID:");
        TextField productIdField = new TextField();

        Label newQuantityLabel = new Label("New Quantity:");
        TextField newQuantityField = new TextField();

        Button updateButton = new Button("Update Quantity");

        updateButton.setOnAction(e -> {
            int productId = Integer.parseInt(productIdField.getText());
            int newQuantity = Integer.parseInt(newQuantityField.getText());

            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "UPDATE products SET  in_stock = ? WHERE product_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, newQuantity);
                    statement.setInt(2, productId);
                    statement.executeUpdate();
                }
                stage.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        VBox vbox = new VBox(10, productIdLabel, productIdField, newQuantityLabel, newQuantityField, updateButton);
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
