package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Client;
import br.com.puc.cakeshop.repository.ClientRepository;
import br.com.puc.cakeshop.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
    }

    @CrossOrigin
    @PostMapping("/clients")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @CrossOrigin
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{cpf}")
    public Client getClient(@PathVariable String cpf){
        return clientService.getClient(cpf);
    }


}
