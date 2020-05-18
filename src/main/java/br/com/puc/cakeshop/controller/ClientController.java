package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Client;
import br.com.puc.cakeshop.repository.ClientRepository;
import br.com.puc.cakeshop.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
    }

   
    @PostMapping("")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    
    @GetMapping("")
    public List<Client> getAllClients() {
        return clientService.getClients();
    }
    
    @GetMapping("/{cpf}")
    public Client getClient(@PathVariable String cpf){
        return clientService.getClient(cpf);
    }


}
