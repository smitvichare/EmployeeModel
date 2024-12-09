package com.eg.employeemodel.service;

import com.eg.employeemodel.dto.RequestDTO;
import com.eg.employeemodel.model.Employee;

import java.util.List;

public interface EmpServ {
    RequestDTO addEmployee(RequestDTO requestDTO);
    Employee findEmployee(int id);
    List<Employee> allEmployees();
    void deleteEmployee(int id);
    Employee updateEmployee(int id, RequestDTO requestDTO);
}
