package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Demand;
import br.com.puc.cakeshop.service.DemandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemandController {

    private DemandService demandService;

    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @CrossOrigin
    @PostMapping("demands")
    public ResponseEntity<String> createDemand(@RequestBody Demand demand) {
        return demandService.createDemand(demand);
    }

    @CrossOrigin
    @GetMapping("demands")
    public List<Demand> getDemands() {
        return demandService.getDemands();
    }
}
