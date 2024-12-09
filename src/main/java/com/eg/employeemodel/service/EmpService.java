package com.eg.employeemodel.service;

import com.eg.employeemodel.dto.RequestDTO;
import com.eg.employeemodel.exception.CustomException;
import com.eg.employeemodel.model.Address;
import com.eg.employeemodel.model.Employee;
import com.eg.employeemodel.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService implements EmpServ{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmailService emailService;
    public EmpService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }
    @Override
    public RequestDTO addEmployee(RequestDTO requestDTO) {
        Employee employee=new Employee(requestDTO);
        List<Address> addresses = requestDTO.getAddress();
        addresses.forEach(address -> address.setEmployee(employee));
        employee.setAddress(addresses);
        emailService.sendEmail(requestDTO.getEmail(),"You are fired!","Get out of bridgebalz!");
        return mapToDTO(employeeRepo.save(employee));
    }


    private RequestDTO mapToDTO(Employee employee) {
        RequestDTO requestDTO=new RequestDTO();
        requestDTO.setAge(employee.getAge());
        requestDTO.setFName(employee.getFName());
        requestDTO.setLName(employee.getLName());
        requestDTO.setSalary(employee.getSalary());
        requestDTO.setDepartment(employee.getDepartment());
        requestDTO.setProfilepic(employee.getProfilepic());
        requestDTO.setNotes(employee.getNotes());
        requestDTO.setGender(employee.getGender());
        requestDTO.setAddress(employee.getAddress());
        requestDTO.setEmail(employee.getEmail());
        return requestDTO;
    }
    @Override
    public Employee findEmployee(int id) {
        return employeeRepo.findById(id).orElseThrow(()->new CustomException("ID not found"));

    }
    @Override
    public List<Employee> allEmployees() {
        return employeeRepo.findAll();
    }


    @Override
    public void deleteEmployee(int id) {
        Employee emp=findEmployee(id);

        employeeRepo.deleteById(id);
    }
    @Override
    public Employee updateEmployee(int id, RequestDTO requestDTO) {
        Employee employee = findEmployee(id);

        employee.setFName(requestDTO.getFName());
        employee.setLName(requestDTO.getLName());
        employee.setSalary(requestDTO.getSalary());
        employee.setProfilepic(requestDTO.getProfilepic());
        employee.setDepartment(requestDTO.getDepartment());
        employee.setGender(requestDTO.getGender());
        employee.setNotes(requestDTO.getNotes());
        employee.setAge(requestDTO.getAge());
        employee.setAddress(requestDTO.getAddress());

        return employeeRepo.save(employee);


    }
}
