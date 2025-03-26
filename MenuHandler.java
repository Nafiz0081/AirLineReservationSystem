import java.util.Scanner;

public class MenuHandler {
    private final Customer customerManager;
    private final Flight flightManager;
    private final FlightReservation bookingManager;
    private final RolesAndPermissions authManager;
    private final Scanner scanner;

    public MenuHandler() {
        this.customerManager = new Customer();
        this.flightManager = new Flight();
        this.bookingManager = new FlightReservation();
        this.authManager = new RolesAndPermissions();
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.printf("%n%n%50s %s Welcome to BAV Airlines Main Menu %s%n", "", "++++++++++++++++",
                "++++++++++++++++");
        System.out.printf("%-30s (a) Press 1 to Login as Admin....%n", "");
        System.out.printf("%-30s (b) Press 2 to Register as Admin....%n", "");
        System.out.printf("%-30s (c) Press 3 to Login as Passenger....%n", "");
        System.out.printf("%-30s (d) Press 4 to Register as Passenger....%n", "");
        System.out.printf("%-30s (e) Press 5 to Display Flight Schedule....%n", "");
        System.out.printf("%-30s (f) Press 6 to Display Manual....%n", "");
        System.out.printf("%-30s (g) Press 0 to Exit....%n", "");
    }

    public void handleAdminLogin() {
        System.out.print("\nEnter the UserName to login to the Management System :     ");
        String username = scanner.nextLine();
        System.out.print("Enter the Password to login to the Management System :    ");
        String password = scanner.nextLine();

        int authResult = authManager.isPrivilegedUserOrNot(username, password);
        handleAdminAuthResult(authResult, username);
    }

    private void handleAdminAuthResult(int authResult, String username) {
        if (authResult == -1) {
            System.out.printf("\n%20sERROR!!! Unable to login. Invalid credentials. Try registering first.\n", "");
            return;
        }

        if (authResult == 0) {
            System.out.println("You have standard privileges. You can only view customer data.");
            customerManager.displayCustomersData(true);
            return;
        }

        System.out.printf("%-20sLogged in Successfully as \"%s\". Select an option below.\n", "", username);
        handleAdminMenu();
    }

    private void handleAdminMenu() {
        int choice;
        do {
            displayAdminMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            processAdminMenuChoice(choice);
        } while (choice != 0);
    }

    private void displayAdminMenu() {
        System.out.printf("\n\n%-60s+++++++++ Admin Menu +++++++++\n", "");
        System.out.printf("%-30s (1) Add new Passenger\n", "");
        System.out.printf("%-30s (2) Search Passenger\n", "");
        System.out.printf("%-30s (3) Update Passenger Data\n", "");
        System.out.printf("%-30s (4) Delete Passenger\n", "");
        System.out.printf("%-30s (5) Display all Passengers\n", "");
        System.out.printf("%-30s (6) Display Passenger Flights\n", "");
        System.out.printf("%-30s (7) Display Flight Passengers\n", "");
        System.out.printf("%-30s (8) Delete Flight\n", "");
        System.out.printf("%-30s (0) Logout\n", "");
        System.out.print("Enter choice: ");
    }

    private void processAdminMenuChoice(int choice) {
        switch (choice) {
            case 1:
                customerManager.addNewCustomer();
                break;
            case 2:
                handlePassengerSearch();
                break;
            case 3:
                handlePassengerUpdate();
                break;
            case 4:
                handlePassengerDelete();
                break;
            case 5:
                customerManager.displayCustomersData(false);
                break;
            case 6:
                handleDisplayPassengerFlights();
                break;
            case 7:
                handleDisplayFlightPassengers();
                break;
            case 8:
                handleDeleteFlight();
                break;
            case 0:
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void handlePassengerSearch() {
        customerManager.displayCustomersData(false);
        System.out.print("Enter CustomerID to Search: ");
        String customerId = scanner.nextLine();
        customerManager.searchUser(customerId);
    }

    private void handlePassengerUpdate() {
        customerManager.displayCustomersData(false);
        System.out.print("Enter CustomerID to Update: ");
        String customerId = scanner.nextLine();
        if (!Customer.customerCollection.isEmpty()) {
            customerManager.editUserInfo(customerId);
        } else {
            System.out.printf("%-50sNo Customer Found\n", " ");
        }
    }

    private void handlePassengerDelete() {
        customerManager.displayCustomersData(false);
        System.out.print("Enter CustomerID to Delete: ");
        String customerId = scanner.nextLine();
        if (!Customer.customerCollection.isEmpty()) {
            customerManager.deleteUser(customerId);
        } else {
            System.out.printf("%-50sNo Customer Found\n", " ");
        }
    }

    private void handleDisplayPassengerFlights() {
        customerManager.displayCustomersData(false);
        System.out.print("Enter Passenger ID to display flights: ");
        String id = scanner.nextLine();
        bookingManager.displayFlightsRegisteredByOneUser(id);
    }

    private void handleDisplayFlightPassengers() {
        System.out.print("Display all flights (Y) or specific flight (N)? ");
        char choice = scanner.nextLine().charAt(0);
        
        if (Character.toUpperCase(choice) == 'Y') {
            bookingManager.displayRegisteredUsersForAllFlight();
        } else if (Character.toUpperCase(choice) == 'N') {
            flightManager.displayFlightSchedule();
            System.out.print("Enter Flight Number: ");
            String flightNum = scanner.nextLine();
            bookingManager.displayRegisteredUsersForASpecificFlight(flightNum);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void handleDeleteFlight() {
        flightManager.displayFlightSchedule();
        System.out.print("Enter Flight Number to delete: ");
        String flightNum = scanner.nextLine();
        flightManager.deleteFlight(flightNum);
    }
}