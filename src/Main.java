import java.util.Scanner;

public class Main {

    private static Workspace[] workspaces = new Workspace[10];
    private static Reservation[] reservations = new Reservation[50];
    private static int workspaceCount = 0;
    private static int reservationCount = 0;

    public static void main(String[] args) {
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
                    System.exit(0);
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
                    browseSpaces();
                    break;
                case 2:
                    addWorkspace(scanner);
                    break;
                case 3:
                    removeWorkspace(scanner);
                    break;
                case 4:
                    viewAllReservations();
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
                    browseSpaces();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewMyReservations(scanner);
                    break;
                case 4:
                    cancelReservation(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private static void addWorkspace(Scanner scanner) {
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

    private static void removeWorkspace(Scanner scanner) {
        System.out.println("Enter workspace ID to remove:");
        int id = scanner.nextInt();
        for (int i = 0; i < workspaceCount; i++) {
            if (workspaces[i].id == id) {
                workspaces[i] = workspaces[--workspaceCount];
                System.out.println("Workspace removed successfully.");
                return;
            }
        }
        System.out.println("Workspace not found.");
    }

    private static void viewAllReservations() {
        for (int i = 0; i < reservationCount; i++) {
            System.out.println(reservations[i]);
        }
    }

    private static void browseSpaces() {
        for (int i = 0; i < workspaceCount; i++) {
            System.out.println(workspaces[i]);
        }
    }

    private static void makeReservation(Scanner scanner) {
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
            if (workspaces[i].id == workspaceId && workspaces[i].isAvailable) {
                selectedWorkspace = workspaces[i];
                break;
            }
        }

        if (selectedWorkspace != null) {
            reservations[reservationCount++] = new Reservation(reservationCount + 1, name, date, startTime, endTime, selectedWorkspace);
            selectedWorkspace.isAvailable = false;
            System.out.println("Reservation made successfully.");
        } else {
            System.out.println("Workspace not available.");
        }
    }

    private static void viewMyReservations(Scanner scanner) {
        System.out.println("Enter your name:");
        String name = scanner.next();
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].customerName.equals(name)) {
                System.out.println(reservations[i]);
            }
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.println("Enter reservation ID to cancel:");
        int id = scanner.nextInt();
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].reservationId == id) {
                reservations[i].workspace.isAvailable = true;
                reservations[i] = reservations[--reservationCount];
                System.out.println("Reservation canceled successfully.");
                return;
            }
        }
        System.out.println("Reservation not found.");
    }
}