package br.com.puc.cakeshop.controller;


import br.com.puc.cakeshop.model.Employee;
import br.com.puc.cakeshop.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @CrossOrigin
    @PostMapping("employee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @CrossOrigin
    @GetMapping("employee")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployee();
    }

    @CrossOrigin
    @GetMapping("employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

}
