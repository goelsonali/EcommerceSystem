package learn.app.library.management.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    Book book;
    Double price;

}
