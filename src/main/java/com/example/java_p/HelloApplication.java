package com.example.java_p;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Resource Management Application");

        Label label = new Label("Resource Management");
        Button addButton = new Button("Add Product");
        Button filterOrdersButton = new Button("Filter Orders by Client ID");
        Button updateQuantityButton = new Button("Update Quantity");

        addButton.setOnAction(e -> new AddProductDialog().show());
        filterOrdersButton.setOnAction(e -> new FilterOrdersDialog().show());
        updateQuantityButton.setOnAction(e -> new UpdateProductDialog().show());

        VBox vbox = new VBox(10, label, addButton, filterOrdersButton, updateQuantityButton);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}