package com.bndlvsk;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
class Workspace implements Serializable {
    @Setter
    @Getter
    private int id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}