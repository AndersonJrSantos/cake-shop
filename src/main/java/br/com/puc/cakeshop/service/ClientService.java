package br.com.puc.cakeshop.service;

import br.com.puc.cakeshop.model.Client;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ClientService {

    ResponseEntity<String> createClient(Client client);

    Client getClient(String cpf);

    Optional<Client> getClientById(Long id);
}
