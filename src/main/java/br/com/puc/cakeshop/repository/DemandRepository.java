package br.com.puc.cakeshop.repository;

import br.com.puc.cakeshop.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand,Long> {

    public Demand findByClient_Cpf(String cpf);
}
