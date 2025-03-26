public interface CustomerRepository {
    /**
     * Adds a new customer to the repository
     * @param customer the customer to add
     */
    void addCustomer(Customer customer);

    /**
     * Finds a customer by their ID
     * @param id the customer ID to search for
     * @return the found customer or null if not found
     */
    Customer findById(String id);

    /**
     * Finds a customer by their email
     * @param email the email to search for
     * @return the found customer or null if not found
     */
    Customer findByEmail(String email);

    /**
     * Updates an existing customer's information
     * @param customer the customer with updated information
     */
    void updateCustomer(Customer customer);

    /**
     * Deletes a customer from the repository
     * @param id the ID of the customer to delete
     * @return true if customer was deleted, false if not found
     */
    boolean deleteCustomer(String id);

    /**
     * Gets all customers in the repository
     * @return list of all customers
     */
    java.util.List<Customer> getAllCustomers();
}