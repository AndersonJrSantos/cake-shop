package br.com.puc.cakeshop.repository;

import br.com.puc.cakeshop.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {

}
