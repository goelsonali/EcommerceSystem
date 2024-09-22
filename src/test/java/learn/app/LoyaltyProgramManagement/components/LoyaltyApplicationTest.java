package learn.app.LoyaltyProgramManagement.components;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class LoyaltyApplicationTest {

    @Autowired private ApplicationContext applicationContext;

    @Test
    void contextLoads() {assertNotNull(applicationContext, "The application context should have loaded.");}
}
