package learn.app.library.management.config;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("promotionConfig")
@ConfigurationProperties(prefix = "promotions")
public class PromotionConfig {
    Map<String, String> discounts;

    public Map<String, String> discounts() {
        return discounts;
    }

    public void setDiscounts(Map<String, String> discounts) {
        this.discounts = discounts;
    }

}
