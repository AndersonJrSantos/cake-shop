package br.com.puc.cakeshop.service;

import br.com.puc.cakeshop.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployee();

    ResponseEntity<String> createEmployee(Employee employee);
}
