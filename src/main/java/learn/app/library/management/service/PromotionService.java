package learn.app.library.management.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import learn.app.library.management.exception.UnknownPromotionTypeException;
import learn.app.library.management.model.Product;
import learn.app.library.management.model.PromotionType;
import learn.app.library.management.promotion.PromotionStrategy;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    private final Map<String, PromotionStrategy> strategyMap;


    public PromotionService(List<PromotionStrategy> promotionStrategies) {
        strategyMap = promotionStrategies.stream().collect(Collectors.toMap(PromotionStrategy::promotionType, promo-> promo));
    }

    public List<Product> applyPromotion(List<Product> products, PromotionType promotionType) {
        PromotionStrategy promotion = strategyMap.get(promotionType.toString());
        if (promotion != null ) {
            promotion.apply(products);
        } else {
            throw new UnknownPromotionTypeException("Invalid promotion type" + promotionType);
        }
        return products;
    }

    public List<String> getPromotionType() {
        return strategyMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }
    public Map<String,String> getPromotionDetails(String name) {
        return strategyMap.entrySet().stream().filter(es -> name.equalsIgnoreCase(es.getKey())).collect(Collectors.toMap(Map.Entry::getKey, es -> es.getValue().discount()));

    }
}
