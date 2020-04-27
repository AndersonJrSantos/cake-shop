package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Demand;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DemandController {

    ResponseEntity<String> createDemand(Demand demand);

    List<Demand> getDemands();
}
