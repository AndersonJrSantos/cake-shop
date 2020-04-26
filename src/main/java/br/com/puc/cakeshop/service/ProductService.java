package br.com.puc.cakeshop.service;

import br.com.puc.cakeshop.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<String> createProduct(Product product);

    Product getProduct(String name);
}
