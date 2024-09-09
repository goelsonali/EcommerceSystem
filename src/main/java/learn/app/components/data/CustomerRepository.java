package learn.app.components.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import learn.app.components.model.CustomerDetails;

public class CustomerRepository {
    static Map<String, CustomerDetails> customerWithPoints = new ConcurrentHashMap<>();

    //get loyaltypoints
    public static int getPoints(String customerId) {
        CustomerDetails customerDetails = customerWithPoints.get(customerId);
        if(customerDetails != null) {
            return customerDetails.loyaltyPoints();
        } else {
            return 0;
        }
    }
    //add loyaltypoints
    public static void addPoints(String customerId, int loyaltyPoints) {
        CustomerDetails customerDetails = customerWithPoints.get(customerId);
        if (customerDetails == null ) {
            customerDetails = new CustomerDetails(customerId, loyaltyPoints);
        } else {
            customerDetails = new CustomerDetails(customerId, getPoints(customerId) + loyaltyPoints);
        }
        customerWithPoints.put(customerId, customerDetails);
    }

    // Optionally, a method to get the whole CustomerDetails object
    public static CustomerDetails getCustomer(String customerId) {
        return customerWithPoints.get(customerId);
    }
}
