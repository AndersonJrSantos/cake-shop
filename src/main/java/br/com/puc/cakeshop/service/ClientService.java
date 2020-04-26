package br.com.puc.cakeshop.service;

import br.com.puc.cakeshop.model.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    ResponseEntity<String> createClient(Client client);

    Client getClient(String cpf);

    Long getClientById(String id);
}
