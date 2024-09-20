package learn.app.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import learn.app.library.management.model.Product;
import learn.app.library.management.model.PromotionType;
import learn.app.library.management.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "API for promotion engine")
@RequestMapping("/promotion")
public class PromotionController {

    private final PromotionService service;

    @Autowired
    public PromotionController(PromotionService service) {
        this.service = service;
    }

    @GetMapping("/apply/{type}")
    ResponseEntity<List<Product>> apply(final List<Product> products, @PathVariable PromotionType type ) {
        return ResponseEntity.ok(service.applyPromotion(products, type));
    }
}
