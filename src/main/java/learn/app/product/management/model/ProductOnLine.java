package learn.app.product.management.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductOnLine {

    private String name;

    private List<String> attributes;

    private Price price;

    private String quantity;

}
