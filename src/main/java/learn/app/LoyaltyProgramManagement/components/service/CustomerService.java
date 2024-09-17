package learn.app.LoyaltyProgramManagement.components.service;

import learn.app.LoyaltyProgramManagement.components.model.CustomerDetails;
import learn.app.LoyaltyProgramManagement.components.data.CustomerRepository;
import learn.app.LoyaltyProgramManagement.components.model.RewardType;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public void addPointsToCustomer(String customerId, int points) {
        CustomerRepository.addPoints(customerId, points);
    }

    public int getCustomerPoints(String customerId) {
        return CustomerRepository.getPoints(customerId);
    }

    public void addCustomerRewards(String customerId, RewardType rewardType) {
        CustomerRepository.addRewards(customerId, rewardType);
    }
    public CustomerDetails getCustomer(String customerId) {
        return CustomerRepository.getCustomer(customerId);
    }
}
