package com.eg.employeemodel.repo;

import com.eg.employeemodel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
