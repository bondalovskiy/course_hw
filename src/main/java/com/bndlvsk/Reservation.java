package com.bndlvsk;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
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

}