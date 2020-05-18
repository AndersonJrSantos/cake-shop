package br.com.puc.cakeshop.repository;

import br.com.puc.cakeshop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findByCpf(String cpf);

    Client findById(String id);
}
