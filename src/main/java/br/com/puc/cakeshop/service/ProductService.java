package br.com.puc.cakeshop.service;

import br.com.puc.cakeshop.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    ResponseEntity<String> createProduct(Product product);

    Product getProduct(String name);

    void deleteProduct(Long id);

    List<Product> getProducts();

}
