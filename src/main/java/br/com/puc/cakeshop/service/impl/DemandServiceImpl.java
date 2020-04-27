package br.com.puc.cakeshop.service.impl;

import br.com.puc.cakeshop.model.Client;
import br.com.puc.cakeshop.model.Demand;
import br.com.puc.cakeshop.model.Product;
import br.com.puc.cakeshop.repository.DemandRepository;
import br.com.puc.cakeshop.service.ClientService;
import br.com.puc.cakeshop.service.DemandService;
import br.com.puc.cakeshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandServiceImpl implements DemandService {

    DemandRepository demandRepository;
    ClientService clientService;
    ProductService productService;

    public DemandServiceImpl(DemandRepository demandRepository, ClientService clientService, ProductService productService) {
        this.demandRepository = demandRepository;
        this.clientService = clientService;
        this.productService = productService;
    }

    public ResponseEntity<String> createDemand(Demand demand) {

        try {
            Client client = clientService.getClient(demand.getClient().getCpf());;
            if (client == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado");
            }
            List<Product> products = new ArrayList<>();
            for (int i = 0; i < demand.getProducts().size(); i++) {
                Product product = productService.getProduct(demand.getProducts().get(i).getName());
                if (product != null) {
                    products.add(product);
                }else {
                    if (product == null && products.size()<0){
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produtos não encontrados");
                    }else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar solicitação");
                    }
                }
            }
            demand.setClient(client);
            demand.setProducts(products);
            demandRepository.save(demand);

            return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public List<Demand> getDemands() {
        return demandRepository.findAll();
    }
}
