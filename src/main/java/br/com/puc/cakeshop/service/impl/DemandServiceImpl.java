package br.com.puc.cakeshop.service.impl;

import br.com.puc.cakeshop.model.Demand;
import br.com.puc.cakeshop.model.Request;
import br.com.puc.cakeshop.repository.DemandRepository;
import br.com.puc.cakeshop.repository.RequestRepository;
import br.com.puc.cakeshop.service.ClientService;
import br.com.puc.cakeshop.service.DemandService;
import br.com.puc.cakeshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DemandServiceImpl implements DemandService {

    DemandRepository demandRepository;
    RequestRepository requestRepository;
    ClientService clientService;
    ProductService productService;

    public DemandServiceImpl(DemandRepository demandRepository, RequestRepository requestRepository,
                             ClientService clientService, ProductService productService) {
        this.demandRepository = demandRepository;
        this.requestRepository = requestRepository;
        this.clientService = clientService;
        this.productService = productService;
    }

    public ResponseEntity<String>createDemand(Demand request) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado");
    }

    public Demand getDemand(String cpf){
        return  demandRepository.findByClient_Cpf(cpf);
    }
}
