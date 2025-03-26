/*
 * This class is intended to be the main class for this Project. All necessary methods are getting calls from this class.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private static final int MAX_ADMINS = 10;
    static String[][] adminUserNameAndPassword = new String[MAX_ADMINS][2];
    private static List<Customer> customersCollection = new ArrayList<>();

    static {
        // Initialize default admin credentials
        adminUserNameAndPassword[0][0] = "root";
        adminUserNameAndPassword[0][1] = "root";
    }

    public static List<Customer> getCustomersCollection() {
        return customersCollection;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Flight flightManager = new Flight();
            MenuHandler menuHandler = new MenuHandler();
            flightManager.flightScheduler();

            System.out.println(
                    "\n\t\t\t\t\t+++++++++++++ Welcome to BAV AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
            System.out.println(
                    "\n***** Default Username && Password is root-root ***** Using Default Credentials will restrict you to just view the list of Passengers....\n");
            
            int choice;
            do {
                menuHandler.displayMainMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                try {
                    switch (choice) {
                        case 1:
                            menuHandler.handleAdminLogin();
                            break;
                        case 2:
                            menuHandler.handleAdminRegistration();
                            break;
                        case 3:
                            menuHandler.handlePassengerLogin();
                            break;
                        case 4:
                            menuHandler.handlePassengerRegistration();
                            break;
                        case 5:
                            flightManager.displayFlightSchedule();
                            break;
                        case 6:
                            displayManual();
                            break;
                        case 0:
                            System.out.println("Thank you for using BAV Airlines. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static String[][] getAdminCredentials() {
        return adminUserNameAndPassword;
    }

    public static void addAdmin(String username, String password) {
        for (int i = 0; i < MAX_ADMINS; i++) {
            if (adminUserNameAndPassword[i][0] == null) {
                adminUserNameAndPassword[i][0] = username;
                adminUserNameAndPassword[i][1] = password;
                break;
            }
        }
    }

    public static void addCustomer(Customer customer) {
        customersCollection.add(customer);
    }

    public static void removeCustomer(Customer customer) {
        customersCollection.remove(customer);
    }

    public static Customer findCustomerById(String id) {
        return customersCollection.stream()
                .filter(customer -> customer.getUserID().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    private static void displayManual() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%n%n%50s %s Welcome to BAV Airlines User Manual %s", "", "+++++++++++++++++",
                "+++++++++++++++++");
        System.out.println("\n\n\t\t(a) Press 1 to display Admin Manual.");
        System.out.println("\t\t(b) Press 2 to display User Manual.");
        System.out.print("\nEnter the desired option :    ");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 2) {
            System.out.print("ERROR!!! Invalid entry...Please enter a value either 1 or 2....Enter again....");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            displayAdminManual();
        } else {
            displayUserManual();
        }
    }
    
    private static void displayAdminManual() {
        System.out.println(
                "\n\n(1) Admin have the access to all users data...Admin can delete, update, add and can perform search for any customer...\n");
        System.out.println(
                "(2) In order to access the admin module, you've to get yourself register by pressing 2, when the main menu gets displayed...\n");
        System.out.println(
                "(3) Provide the required details i.e., name, email, id...Once you've registered yourself, press 1 to login as an admin... \n");
        System.out.println(
                "(4) Once you've logged in, 2nd layer menu will be displayed on the screen...From here on, you can select from variety of options...\n");
        System.out.println(
                "(5) Pressing \"1\" will add a new Passenger, provide the program with required details to add the passenger...\n");
        System.out.println(
                "(6) Pressing \"2\" will search for any passenger, given the admin(you) provides the ID from the table printing above....  \n");
        System.out.println(
                "(7) Pressing \"3\" will let you update any passengers data given the user ID provided to program...\n");
        System.out.println("(8) Pressing \"4\" will let you delete any passenger given its ID provided...\n");
        System.out.println("(9) Pressing \"5\" will let you display all registered passenger...\n");
        System.out.println(
                "(10) Pressing \"6\" will let you display all registered passengers...After selecting, program will ask, if you want to display passengers for all flights(Y/y) or a specific flight(N/n)\n");
        System.out.println(
                "(11) Pressing \"7\" will let you delete any flight given its flight number provided...\n");
        System.out.println(
                "(11) Pressing \"0\" will make you logged out of the program...You can login again any time you want during the program execution....\n");
    }
    
    private static void displayUserManual() {
        System.out.println(
                "\n\n(1) Local user has the access to its data only...He/She won't be able to change/update other users data...\n");
        System.out.println(
                "(2) In order to access local users benefits, you've to get yourself register by pressing 4, when the main menu gets displayed...\n");
        System.out.println(
                "(3) Provide the details asked by the program to add you to the users list...Once you've registered yourself, press \"3\" to login as a passenger...\n");
        System.out.println(
                "(4) Once you've logged in, 3rd layer menu will be displayed...From here on, you embarked on the journey to fly with us...\n");
        System.out.println(
                "(5) Pressing \"1\" will display available/scheduled list of flights...To get yourself booked for a flight, enter the flight number and number of tickets for the flight...Max num of tickets at a time is 10 ...\n");
        System.out.println(
                "(7) Pressing \"2\" will let you update your own data...You won't be able to update other's data... \n");
        System.out.println("(8) Pressing \"3\" will delete your account... \n");
        System.out
                .println("(9) Pressing \"4\" will display randomly designed flight schedule for this runtime...\n");
        System.out.println("(10) Pressing \"5\" will let you cancel any flight registered by you...\n");
        System.out.println("(11) Pressing \"6\" will display all flights registered by you...\n");
        System.out.println(
                "(12) Pressing \"0\" will make you logout of the program...You can login back at anytime with your credentials...for this particular run-time... \n");
    }
}