package learn.app.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import learn.app.library.management.model.Product;
import learn.app.library.management.model.PromotionType;
import learn.app.library.management.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "API for promotion engine")
@RequestMapping("/promotion")
public class PromotionController {

    private final PromotionService service;

    @Autowired
    public PromotionController(PromotionService service) {
        this.service = service;
    }

    @PostMapping("/apply/{type}")
    ResponseEntity<List<Product>> apply(@RequestBody List<Product> products, @PathVariable PromotionType type ) {
        return ResponseEntity.ok(service.applyPromotion(products, type));
    }

    @GetMapping("/promotionType")
    ResponseEntity<List<String>> getPromotionType() {
        return ResponseEntity.ok(service.getPromotionType());
    }

    @GetMapping("/promotionType/{name}")
    ResponseEntity<Map<String,String>> getPromotionByName(@PathVariable final String name) {
        return ResponseEntity.ok(service.getPromotionDetails(name));
    }
}
