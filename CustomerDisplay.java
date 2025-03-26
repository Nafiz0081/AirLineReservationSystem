public class CustomerDisplay {
    /**
     * Shows the customers' data in formatted way.
     * @param customers list of customers to display
     * @param showHeader to check if we want to print ascii art for the customers' data
     */
    public void displayCustomersData(java.util.List<Customer> customers, boolean showHeader) {
        displayHeader();
        int i = 0;
        for (Customer c : customers) {
            i++;
            System.out.println(formatCustomerData(c, i));
            System.out.printf(
                    "%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+\n",
                    "");
        }
    }

    /**
     * Shows the header for printing customers data
     */
    private void displayHeader() {
        System.out.println();
        System.out.printf(
                "%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+\n",
                "");
        System.out.printf(
                "%10s| SerialNum  |   UserID   | Passenger Names                  | Age     | EmailID\t\t       | Home Address\t\t\t     | Phone Number\t       |%n",
                "");
        System.out.printf(
                "%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+\n",
                "");
        System.out.println();
    }

    /**
     * Formats customer data into a display string
     * @param customer the customer to format
     * @param serialNum the serial number for display
     * @return formatted string
     */
    private String formatCustomerData(Customer customer, int serialNum) {
        return String.format("%10s| %-10d | %-10s | %-32s | %-7s | %-27s | %-35s | %-23s |", "",
                serialNum,
                formatUserId(customer.getUserID()),
                customer.getName(),
                customer.getAge(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhone());
    }

    /**
     * Adds space between userID to increase its readability
     * @param userId id to format
     * @return formatted user ID
     */
    private String formatUserId(String userId) {
        if (userId == null || userId.length() < 4) {
            return userId;
        }
        return userId.substring(0, 3) + " " + userId.substring(3);
    }
}