package com.spring.henallux.transpLux.model;

import java.util.ArrayList;
import java.util.Date;

public class Command {

    private Boolean isPaid;
    private Date date;
    private ArrayList<LineItem> items;
    private String userEmail;

    public Command() {
        isPaid = false;
        date = new Date();
        items = new ArrayList<LineItem>();
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }

    public void addItem(LineItem item) {
        this.items.add(item);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
