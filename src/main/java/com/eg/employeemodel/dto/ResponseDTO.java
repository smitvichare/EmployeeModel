package com.eg.employeemodel.dto;


import com.eg.employeemodel.model.Address;
import com.eg.employeemodel.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class ResponseDTO {

    public List<Address> address;
    public String fName;
    public String lName;
    public double salary;
    public int age;
    public String profilepic;
    public String notes;
    public String gender;
    public List<String> department;
    public String email;

    public ResponseDTO(Employee employee){
        this.fName=employee.getFName();
        this.lName=employee.getLName();
        this.salary=employee.getSalary();
        this.department=employee.getDepartment();
        this.profilepic=employee.getProfilepic();
        this.notes=employee.getNotes();
        this.age=employee.getAge();
        this.gender=employee.getGender();
        this.address=employee.getAddress();
        this.email=employee.getEmail();
    }
}
