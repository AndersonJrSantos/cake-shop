package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Product;
import br.com.puc.cakeshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductControllerImpl{

    private ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("products/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getProduct(name);
    }
}
