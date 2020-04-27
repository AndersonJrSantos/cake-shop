package br.com.puc.cakeshop.controller.Impl;

import br.com.puc.cakeshop.controller.DemandController;
import br.com.puc.cakeshop.model.Demand;
import br.com.puc.cakeshop.service.DemandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemandControllerImpl implements DemandController {

    private DemandService demandService;

    public DemandControllerImpl(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping("demands")
    public ResponseEntity<String> createDemand(@RequestBody Demand demand) {
        return demandService.createDemand(demand);
    }

    @GetMapping("demands")
    public List<Demand> getDemands() {
        return demandService.getDemands();
    }
}
