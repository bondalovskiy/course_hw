package com.bndlvsk;

import java.io.Serializable;

class Reservation implements Serializable {
    private int reservationId;
    private String customerName;
    private String date;
    private String startTime;
    private String endTime;
    private Workspace workspace;

    public Reservation(int reservationId, String customerName, String date, String startTime, String endTime, Workspace workspace) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workspace = workspace;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Customer: " + customerName + ", Date: " + date + ", Time: " + startTime + " - " + endTime + ", Workspace: " + workspace.getName();
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }
}