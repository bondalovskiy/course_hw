package com.bndlvsk;

import java.io.*;
import java.util.Scanner;

public class DataProcessing {

    private static Workspace[] workspaces = new Workspace[10];
    private static Reservation[] reservations = new Reservation[50];
    private static int workspaceCount = 0;
    private static int reservationCount = 0;


    static void addWorkspace(Scanner scanner) {
        System.out.println("Enter workspace ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter workspace name:");
        String name = scanner.nextLine();
        System.out.println("Enter workspace price:");
        double price = scanner.nextDouble();
        System.out.println("Is the workspace available? (true/false):");
        boolean isAvailable = scanner.nextBoolean();

        workspaces[workspaceCount++] = new Workspace(id, name, price, isAvailable);
        System.out.println("Workspace added successfully.");
    }

    static void removeWorkspace(Scanner scanner) {
        System.out.println("Enter workspace ID to remove:");
        int id = scanner.nextInt();
        for (int i = 0; i < workspaceCount; i++) {
            if (workspaces[i].getId() == id) {
                workspaces[i] = workspaces[--workspaceCount];
                System.out.println("Workspace removed successfully.");
                return;
            }
        }
        System.out.println("Workspace not found.");
    }

    static void viewAllReservations() {
        for (int i = 0; i < reservationCount; i++) {
            System.out.println(reservations[i]);
        }
    }

    static void browseSpaces() {
        for (int i = 0; i < workspaceCount; i++) {
            System.out.println(workspaces[i]);
        }
    }

    static void makeReservation(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter date (YYYY-MM-DD):");
        String date = scanner.next();
        System.out.println("Enter start time (HH:MM):");
        String startTime = scanner.next();
        System.out.println("Enter end time (HH:MM):");
        String endTime = scanner.next();
        System.out.println("Enter workspace ID:");
        int workspaceId = scanner.nextInt();

        Workspace selectedWorkspace = null;
        for (int i = 0; i < workspaceCount; i++) {
            if (workspaces[i].getId() == workspaceId && workspaces[i].isAvailable()) {
                selectedWorkspace = workspaces[i];
                break;
            }
        }

        if (selectedWorkspace != null) {
            reservations[reservationCount++] = new Reservation(reservationCount + 1, name, date, startTime, endTime, selectedWorkspace);
            selectedWorkspace.setAvailable(false);
            System.out.println("Reservation made successfully.");
        } else {
            System.out.println("Workspace not available.");
        }
    }

    static void viewMyReservations(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.next();
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].getCustomerName().equals(name)) {
                System.out.println(reservations[i]);
            }
        }
    }

    static void cancelReservation(Scanner scanner) {
        System.out.println("Enter reservation ID to cancel:");
        int id = scanner.nextInt();
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].getReservationId() == id) {
                reservations[i].getWorkspace().setAvailable(true);
                reservations[i] = reservations[--reservationCount];
                System.out.println("Reservation canceled successfully.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    public static void exitSerialize(){
        try(FileOutputStream fileOut = new FileOutputStream("appState");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(workspaces);
            out.writeObject(reservations);
            out.writeInt(workspaceCount);
            out.writeInt(reservationCount);
            System.out.println("Data serialized.");
        } catch (IOException exception) {
            System.out.println("Error with serializing data.");
        } finally {
            System.exit(0);
        }
    }

    static void startUpDeserialize() {
        try (FileInputStream fileIn = new FileInputStream("appState");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            workspaces = (Workspace[]) in.readObject();
            reservations = (Reservation[]) in.readObject();
            workspaceCount = in.readInt();
            reservationCount = in.readInt();
            System.out.println("Data deserialized.");
        } catch (IOException | ClassNotFoundException i) {
            System.out.println("No previous state found");
        }
    }

}
