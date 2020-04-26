package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductController {
    ResponseEntity<String> createProduct(Product product);

    Product getProduct(String name);

}
