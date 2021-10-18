package com.ameed.employees;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class EmployeesController {
    private final EmployeesRepository employeesRepository;

    public EmployeesController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable Integer employeeId) {
        Optional<Employee> result = employeesRepository.findById(employeeId);
        return result.orElse(null);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeesRepository.save(newEmployee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable Integer employeeId) {
        employeesRepository.deleteById(employeeId);
    }

    @GetMapping("/{empid}/update-age/10")

    @PutMapping("/{employeeId}")
    public Employee updateEmployeeById(@RequestBody Employee employee,
                                       @PathVariable Integer employeeId) {
        Employee employeeInDb = findEmployeeById(employeeId);
        if (employeeInDb == null) {
            employee.setId(null);
        }
        return employeesRepository.save(employee);
    }
}
