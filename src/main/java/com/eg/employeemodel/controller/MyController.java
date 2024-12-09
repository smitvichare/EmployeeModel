package com.eg.employeemodel.controller;

import com.eg.employeemodel.dto.RequestDTO;
import com.eg.employeemodel.dto.ResponseDTO;
import com.eg.employeemodel.model.Employee;
import com.eg.employeemodel.service.EmpService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/home")
public class MyController {

    @Autowired
    public EmpService empService;

    @PostMapping(value = "/add")
    public RequestDTO addEmp(@Valid @RequestBody RequestDTO requestDTO){
        return empService.addEmployee(requestDTO);
    }


    @GetMapping("/{id}")
    public ResponseDTO findEmpByID(@PathVariable int id){
        Employee emp=empService.findEmployee(id);
        return new ResponseDTO(emp);
    }

    @GetMapping
    public List<ResponseDTO> readAllEmp(){
        List<Employee> emp=empService.allEmployees();
        return emp.stream().map(ResponseDTO::new).toList();
    }

    @PutMapping("/{id}")
    public ResponseDTO updateEmployee(@PathVariable int id,@Valid @RequestBody RequestDTO requestDTO){
        Employee emp=empService.updateEmployee(id,requestDTO);
        return new ResponseDTO(emp);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        empService.deleteEmployee(id);
    }
}
