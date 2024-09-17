package learn.app.LoyaltyProgramManagement.components.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import learn.app.LoyaltyProgramManagement.components.model.OrderDetails;
import learn.app.LoyaltyProgramManagement.components.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@Tag(name = "APIs relevant to loyalty program")
public class LoyaltyProgramController {

    private final LoyaltyProgramService loyaltyProgramService;
    @Autowired
    LoyaltyProgramController(LoyaltyProgramService loyaltyProgramService) {
        this.loyaltyProgramService = loyaltyProgramService;
    }

    @PostMapping("/process-order")
    public ResponseEntity<String> processOrder(@RequestBody OrderDetails order){
        return ResponseEntity.ok(loyaltyProgramService.processOrder(order));
    }

    @GetMapping("/customers/{customerId}/points")
    public ResponseEntity<Integer> getPoints(@PathVariable String customerId){
        return ResponseEntity.ok(loyaltyProgramService.getPoints(customerId));
    }

    @GetMapping("/customers/{customerId}/rewards")
    public ResponseEntity<String> getRewards(@PathVariable String customerId){
        return ResponseEntity.ok(loyaltyProgramService.getRewards(customerId));
    }


}
