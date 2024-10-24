package learn.app.product.management.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

    private String sellingPrice;
    private String wasPrice;

}
