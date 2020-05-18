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
import java.util.Optional;


@Service
public class DemandServiceImpl implements DemandService {

    DemandRepository demandRepository;
    ClientService clientService;
    ProductService productService;

    public DemandServiceImpl(DemandRepository demandRepository,
                             ClientService clientService, ProductService productService) {
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
            List<Integer> qtdRequest = new ArrayList<>();
            for (int i = 0; i < demand.getProducts().size(); i++) {
                Product product = productService.getProduct(demand.getProducts().get(i).getName());

                if (product != null) {

                    int stock = product.getStock();
                    qtdRequest.add(demand.getQtd(i));


                    if (qtdRequest.get(i) > stock){
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quantidade não disponivel");

                    }else {
                        product.setStock(stock - qtdRequest.get(i));
                        products.add(product);
                    }

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

    public Demand getDemand(String cpf) {
        return demandRepository.findByClient_Cpf(cpf);
    }

    public void deleteDemand(Long id){
        Demand demand =demandRepository.findById(id).get();
        demandRepository.delete(demand);
    }
}
