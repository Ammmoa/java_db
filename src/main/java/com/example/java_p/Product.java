package com.example.java_p;

public class Product {
    public String product_name;
    public String description;
    public float price;
    public int in_stock;
    public int supplier_id;
    public int category_id;


    public String getName() {
        return product_name;
    }

    public void setName(String name) {
        this.product_name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return in_stock;
    }

    public void setQuantity(int quantity) {
        this.in_stock = quantity;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int categoryId) {
        this.category_id = categoryId;
    }

    public int getSupplierId() {
        return supplier_id;
    }

    public void setSupplierId(int supplierId) {
        this.supplier_id = supplierId;
    }
}
