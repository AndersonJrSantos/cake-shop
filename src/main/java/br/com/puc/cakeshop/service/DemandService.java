package br.com.puc.cakeshop.service;

import br.com.puc.cakeshop.model.Demand;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DemandService {

    ResponseEntity<String> createDemand(Demand request);

    Demand getDemand(String cpf);

    void deleteDemand(Long id);

    List<Demand> getDemands();

}
