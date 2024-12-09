package com.eg.employeemodel.controller;

import com.eg.employeemodel.dto.RequestDTO;
import com.eg.employeemodel.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/msg",method = RequestMethod.GET)
    public String message(){
        return "Test Controller";
    }
}
