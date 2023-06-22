package com.example.tastybite.Models;

public class OrdersModel {
    int orderimage;
    String orderItemName,textView9,orderNumber;

    public OrdersModel(int orderImage, String orderItemName, String textView9, String orderNumber) {
        this.orderimage = orderimage;
        this.orderItemName = orderItemName;
        this.textView9 = textView9;
        this.orderNumber = orderNumber;
    }

    public OrdersModel() {

    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public String getTextView9() {
        return textView9;
    }

    public void setTextView9(String textView9) {
        this.textView9 = textView9;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
