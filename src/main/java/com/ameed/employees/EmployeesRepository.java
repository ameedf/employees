package com.ameed.employees;

import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employee, Integer> {
}
