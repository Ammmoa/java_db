package com.example.java_p;

import java.util.Date;

public class Order {
    public int client_id;
    public Date order_date;
    public Date delivery_date;

    // Getters and setters


    public int getClientId() {
        return client_id;
    }

    public void setClientId(int clientId) {
        this.client_id = clientId;
    }

    public Date getOrderDate() {
        return order_date;
    }

    public void setOrderDate(Date orderDate) {
        this.order_date = orderDate;
    }

    public Date getDeliveryDate() {
        return delivery_date;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.delivery_date = deliveryDate;
    }
}
