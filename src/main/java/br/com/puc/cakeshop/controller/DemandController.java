package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Demand;
import org.springframework.http.ResponseEntity;


public interface DemandController {

    ResponseEntity<String> createDemand(String cpf, String product, Integer qtd);

    Demand getDemandClient(String cpf);
}
