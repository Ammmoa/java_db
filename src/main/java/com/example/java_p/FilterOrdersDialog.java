package com.example.java_p;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilterOrdersDialog {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Filter Orders by Client ID");

        Label clientIdLabel = new Label("Client ID:");
        TextField clientIdField = new TextField();

        Button filterButton = new Button("Filter");
        ListView<String> ordersListView = new ListView<>();

        filterButton.setOnAction(e -> {
            int clientId = Integer.parseInt(clientIdField.getText());
            List<String> orders = new ArrayList<>();

            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM orders WHERE client_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, clientId);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int orderId = resultSet.getInt("order_id");
                            String orderDate = resultSet.getDate("order_date").toString();
                            orders.add("Order ID: " + orderId + ", Date: " + orderDate);
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            ordersListView.getItems().setAll(orders);
        });

        VBox vbox = new VBox(10, clientIdLabel, clientIdField, filterButton, ordersListView);
        Scene scene = new Scene(vbox, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
