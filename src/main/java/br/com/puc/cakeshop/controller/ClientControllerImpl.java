package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Client;
import br.com.puc.cakeshop.repository.ClientRepository;
import br.com.puc.cakeshop.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ClientControllerImpl {

    private ClientService clientService;

    public ClientControllerImpl(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
    }

    @CrossOrigin
    @PostMapping("/clients")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/clients/{cpf}")
    public Client getClient(@PathVariable String cpf){
        return clientService.getClient(cpf);
    }


}
