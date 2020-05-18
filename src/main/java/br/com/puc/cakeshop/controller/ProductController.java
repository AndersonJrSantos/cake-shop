package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Product;
import br.com.puc.cakeshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @GetMapping("/}")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getProduct(name);
    }

    @DeleteMapping("/{id}")
    public void deleteDemand(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
