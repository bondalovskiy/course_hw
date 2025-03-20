package com.bndlvsk;

import java.util.Scanner;

public class MenuProcessing {

    static void welcomeMenu(){
        DataProcessing.startUpDeserialize();
        Scanner scanner = new Scanner(System.in);
            while (true) {
            System.out.println("Welcome to 'Coworking Space Reservation' System");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    userMenu(scanner);
                    break;
                case 3:
                    DataProcessing.exitSerialize();
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("Admin Menu");
            System.out.println("1. Browse all spaces");
            System.out.println("2. Add a new coworking space");
            System.out.println("3. Remove a coworking space");
            System.out.println("4. View all reservations");
            System.out.println("5. Back to main menu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    DataProcessing.browseSpaces();
                    break;
                case 2:
                    DataProcessing.addWorkspace(scanner);
                    break;
                case 3:
                    DataProcessing.removeWorkspace(scanner);
                    break;
                case 4:
                    DataProcessing.viewAllReservations();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userMenu(Scanner scanner) {
        while (true) {
            System.out.println("User Menu");
            System.out.println("1. Browse available spaces");
            System.out.println("2. Make a reservation");
            System.out.println("3. View my reservations");
            System.out.println("4. Cancel a reservation");
            System.out.println("5. Back to main menu");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    DataProcessing.browseSpaces();
                    break;
                case 2:
                    DataProcessing.makeReservation(scanner);
                    break;
                case 3:
                    DataProcessing.viewMyReservations(scanner);
                    break;
                case 4:
                    DataProcessing.cancelReservation(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}
