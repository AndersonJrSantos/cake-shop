package br.com.puc.cakeshop.service.impl;

import br.com.puc.cakeshop.model.Client;
import br.com.puc.cakeshop.repository.ClientRepository;
import br.com.puc.cakeshop.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<String> createClient(Client client) {
        clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente Cadastrado");
    }

    public Client getClient(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void deleteClient(String cpf) {
        Client client = clientRepository.findByCpf(cpf);
        clientRepository.delete(client);
    }


}
