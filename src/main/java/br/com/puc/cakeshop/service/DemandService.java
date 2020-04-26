package br.com.puc.cakeshop.service;

import br.com.puc.cakeshop.model.Demand;
import org.springframework.http.ResponseEntity;

public interface DemandService {
;
    ResponseEntity<String>createDemand(Demand request);

    Demand getDemand(String cpf);
}
