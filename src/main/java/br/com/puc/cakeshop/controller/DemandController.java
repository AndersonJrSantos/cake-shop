package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Demand;
import br.com.puc.cakeshop.service.DemandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demands")
public class DemandController {

    private DemandService demandService;

    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping("")
    public ResponseEntity<String> createDemand(@RequestBody Demand demand) {
        return demandService.createDemand(demand);
    }

    @GetMapping("")
    public List<Demand> getAllDemands() {
        return demandService.getAllDemands();
    }

    @GetMapping("client/{cpf}")
    public Demand getDemandClient(@PathVariable String cpf) {
        return demandService.getDemand(cpf);
    }

    @DeleteMapping("/{id}")
    public void deleteDemand(@PathVariable Long id) {
        demandService.deleteDemand(id);
    }
}
