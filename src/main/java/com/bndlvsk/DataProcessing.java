package com.bndlvsk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataProcessing {

    private static List<Workspace> workspaces = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

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

        workspaces.add(new Workspace(id, name, price, isAvailable));
        System.out.println("Workspace added successfully.");
    }

    static void removeWorkspace(Scanner scanner) {
        System.out.println("Enter workspace ID to remove:");
        int id = scanner.nextInt();
        workspaces.removeIf(workspace -> workspace.getId() == id);
        System.out.println("Workspace removed successfully.");
    }

    static void viewAllReservations() {
        reservations.forEach(System.out::println);
    }

    static void browseSpaces() {
        workspaces.forEach(System.out::println);
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

        Workspace selectedWorkspace = workspaces.stream()
                .filter(w -> w.getId() == workspaceId && w.isAvailable())
                .findFirst()
                .orElse(null);

        if (selectedWorkspace != null) {
            reservations.add(new Reservation(reservations.size() + 1, name, date, startTime, endTime, selectedWorkspace));
            selectedWorkspace.setAvailable(false);
            System.out.println("Reservation made successfully.");
        } else {
            System.out.println("Workspace not available.");
        }
    }

    static void viewMyReservations(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.next();
        reservations.stream()
                .filter(r -> r.getCustomerName().equals(name))
                .forEach(System.out::println);
    }

    static void cancelReservation(Scanner scanner) {
        System.out.println("Enter reservation ID to cancel:");
        int id = scanner.nextInt();
        reservations.stream()
                .filter(r -> r.getReservationId() == id)
                .findFirst()
                .ifPresent(r -> {
                    r.getWorkspace().setAvailable(true);
                    reservations.remove(r);
                    System.out.println("Reservation canceled successfully.");
                });
    }

    public static void exitSerialize() {
        try(FileOutputStream fileOut = new FileOutputStream("appState");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(new ArrayList<>(workspaces));
            out.writeObject(new ArrayList<>(reservations));
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
            workspaces = (List<Workspace>) in.readObject();
            reservations = (List<Reservation>) in.readObject();
            System.out.println("Data deserialized.");
        } catch (IOException | ClassNotFoundException i) {
            System.out.println("No previous state found");
        }
    }
}
