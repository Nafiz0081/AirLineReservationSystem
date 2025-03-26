import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemoryCustomerRepository implements CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(String id) {
        return customers.stream()
                .filter(c -> c.getUserID().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer findByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateCustomer(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserID().equals(customer.getUserID())) {
                customers.set(i, customer);
                return;
            }
        }
    }

    @Override
    public boolean deleteCustomer(String id) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getUserID().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }
}