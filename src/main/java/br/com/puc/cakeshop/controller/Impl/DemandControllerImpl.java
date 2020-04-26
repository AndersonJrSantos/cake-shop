package br.com.puc.cakeshop.controller.Impl;

import br.com.puc.cakeshop.controller.DemandController;
import br.com.puc.cakeshop.model.Demand;
import br.com.puc.cakeshop.service.DemandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemandControllerImpl implements DemandController {

    private DemandService demandService;

    public DemandControllerImpl(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping("demands")
    public ResponseEntity<String> createDemand(@RequestBody String cpf, String product, Integer qtd) {
        return null;
    }

    @GetMapping("demands/{cpf}")
    public Demand getDemandClient(@PathVariable String cpf) {
        return demandService.getDemand(cpf);
    }
}
