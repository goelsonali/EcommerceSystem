package learn.app.LoyaltyProgramManagement.components.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import learn.app.LoyaltyProgramManagement.components.model.CustomerDetails;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepository {
    static Map<String, CustomerDetails> customerWithDetails = new ConcurrentHashMap<>();

    //get loyaltypoints
    public static int getPoints(String customerId) {
        CustomerDetails customerDetails = customerWithDetails.get(customerId);
        if(customerDetails != null) {
            return customerDetails.getLoyaltyPoints();
        } else {
            return 0;
        }
    }
    //add loyaltypoints
    public static void addPoints(String customerId, int loyaltyPoints) {
        CustomerDetails customerDetails = customerWithDetails.get(customerId);
        if (customerDetails == null ) {
            customerDetails = CustomerDetails.builder()
                                .customerId(customerId)
                                .loyaltyPoints(loyaltyPoints).build();
        } else {
            customerDetails = CustomerDetails.builder()
                    .customerId(customerId)
                    .loyaltyPoints(getPoints(customerId) + loyaltyPoints).build();
        }
        customerWithDetails.put(customerId, customerDetails);
    }

    //add loyaltypoints
    public static void addRewards(String customerId, RewardType rewardType) {
        CustomerDetails customerDetails = getCustomer(customerId);
        customerDetails.setRewardType(rewardType);
    }

    // Optionally, a method to get the whole CustomerDetails object
    public static CustomerDetails getCustomer(String customerId) {
        return customerWithDetails.get(customerId);
    }
}
