package br.com.puc.cakeshop.controller;

import br.com.puc.cakeshop.model.Client;
import org.springframework.http.ResponseEntity;

public interface ClienteController {

    ResponseEntity<String> createClient(Client client);

    Client getClient(String cpf);

}
