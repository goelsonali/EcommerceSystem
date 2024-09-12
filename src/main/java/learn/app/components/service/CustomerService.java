package learn.app.components.service;

import learn.app.components.model.CustomerDetails;
import learn.app.components.data.CustomerRepository;
import learn.app.components.model.RewardType;
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
