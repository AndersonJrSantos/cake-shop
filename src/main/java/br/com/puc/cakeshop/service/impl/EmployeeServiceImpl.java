package br.com.puc.cakeshop.service.impl;


import br.com.puc.cakeshop.model.Employee;
import br.com.puc.cakeshop.repository.EmployeeRepository;
import br.com.puc.cakeshop.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ResponseEntity<String> createEmployee(Employee employee) {

        employeeRepository.save(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario Criado");
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


}
