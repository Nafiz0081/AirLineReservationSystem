public interface CustomerRepository {

    void addCustomer(Customer customer);


    Customer findById(String id);


    Customer findByEmail(String email);


    void updateCustomer(Customer customer);


    boolean deleteCustomer(String id);


    java.util.List<Customer> getAllCustomers();
}