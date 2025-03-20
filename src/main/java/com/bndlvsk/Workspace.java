package com.bndlvsk;

import java.io.Serializable;

class Workspace implements Serializable {
    private int id;
    private String name;
    private double price;
    private boolean isAvailable;

    public Workspace(int id, String type, double price, boolean isAvailable) {
        this.id = id;
        this.name = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Available: " + isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}