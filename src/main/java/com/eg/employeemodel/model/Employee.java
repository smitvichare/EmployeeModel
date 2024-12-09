package com.eg.employeemodel.model;

import com.eg.employeemodel.dto.RequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Employee_Data")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int emp_id;
    private String fName;
    private String lName;
    private double salary;
    private int age;
    private String profilepic;
    @ElementCollection
    @CollectionTable(name="department_data",joinColumns = @JoinColumn(name = "employee_id"))
    private List<String> department;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Address> address;
    private LocalDate doj;
    private String notes;
    private String gender;
    private String email;

    public Employee(RequestDTO requestDTO){
        this.fName=requestDTO.fName;
        this.lName=requestDTO.lName;
        this.salary=requestDTO.salary;
        this.profilepic=requestDTO.profilepic;
        this.age=requestDTO.age;
        this.department=requestDTO.department;
        this.notes=requestDTO.notes;
        this.gender=requestDTO.gender;
        this.address=requestDTO.address;
        doj=LocalDate.now();

    }

}
