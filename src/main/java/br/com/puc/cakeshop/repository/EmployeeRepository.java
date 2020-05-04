package br.com.puc.cakeshop.repository;

import br.com.puc.cakeshop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
