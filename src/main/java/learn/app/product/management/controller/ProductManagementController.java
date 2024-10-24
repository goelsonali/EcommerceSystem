package learn.app.product.management.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import learn.app.product.management.action.Type;
import learn.app.product.management.model.ProductOnLine;
import learn.app.product.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "API for managing the products")
@RequestMapping("/api/v1/product")
public class ProductManagementController {

    private final ProductService productService;

    @Autowired
    ProductManagementController(ProductService productService) {
        this.productService = productService;
    }
    
    @PostMapping("/add")
    ResponseEntity<String> addProduct(@RequestBody ProductOnLine product) {
        return ResponseEntity.ok(productService.performAction(product, Type.ADD_PRODUCT));
    }

    @PostMapping("/remove")
    ResponseEntity<String> removeProduct(@RequestBody ProductOnLine product) {
        return ResponseEntity.ok(productService.performAction(product, Type.REMOVE_PRODUCT));
    }

}
