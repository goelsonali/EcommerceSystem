package learn.app.library.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import learn.app.library.management.exception.UnknownPromotionTypeException;
import learn.app.library.management.model.Product;
import learn.app.library.management.model.PromotionType;
import learn.app.library.management.promotion.FlatDiscount;
import learn.app.library.management.promotion.PercentageDiscount;
import learn.app.library.management.promotion.Promotion;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    private final Map<PromotionType, Promotion> promotionTypeToPromotion;

    public PromotionService(List<Promotion> promotions) {
        promotionTypeToPromotion = new HashMap<>();
        for (Promotion promo : promotions ) {
            if(promo instanceof PercentageDiscount) {
                promotionTypeToPromotion.put(PromotionType.PERCENTAGE_DISCOUNT, promo);
            } else if(promo instanceof FlatDiscount){
                promotionTypeToPromotion.put(PromotionType.FLAT_DISCOUNT, promo);
            }
        }
    }

    public List<Product> applyPromotion(List<Product> products, PromotionType promotionType) {
        Promotion promotion = promotionTypeToPromotion.get(promotionType);
        if (promotion != null ) {
            promotion.apply(products,promotionType);
        } else {
            throw new UnknownPromotionTypeException("Invalid promotion type" + promotionType);
        }
        return products;
    }

}
