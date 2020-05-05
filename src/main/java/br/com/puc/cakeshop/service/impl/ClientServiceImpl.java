package br.com.puc.cakeshop.service.impl;

import br.com.puc.cakeshop.model.Client;
import br.com.puc.cakeshop.repository.ClientRepository;
import br.com.puc.cakeshop.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Client> getClientById(Long id){
        return  clientRepository.findById(id);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

}
