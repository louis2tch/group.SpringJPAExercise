package com.example.group.SpringJPAExercise.repo;

import com.example.group.SpringJPAExercise.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
