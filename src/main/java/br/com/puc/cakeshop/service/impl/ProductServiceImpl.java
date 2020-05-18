package br.com.puc.cakeshop.service.impl;

import br.com.puc.cakeshop.model.Product;
import br.com.puc.cakeshop.repository.ProductRepository;
import br.com.puc.cakeshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<String> createProduct(Product product) {
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Cadastrado");
    }

    public Product getProduct(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
