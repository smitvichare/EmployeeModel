package com.eg.employeemodel.dto;

import com.eg.employeemodel.model.Address;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO {

    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Pattern mismatch Min 3 characters eg= Sam")
    public String fName;
    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Pattern mismatch Min 3 characters eg= Sam")
    public String lName;
    @Min(value = 1000,message = "Salary must be more than Rs.1000")
    public double salary;
    @Min(value = 18,message = "Age must be 18+")
    @Max(value = 50, message = "Age limit less then 50")
    public int age;
    public String profilepic;
    @NotEmpty(message = "Note should not be empty")
    public String notes;
    @NotEmpty(message = "Gender should not be empty")
    @Pattern(regexp = "^[A-Z]$", message = "Pattern mismatch Max 1 characters eg=M")
    public String gender;
    public List<Address> address;
    public List<String> department;
    private String email;
}
