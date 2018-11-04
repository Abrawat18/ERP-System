package com.erp.demo.controller;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public List<EmployeeInfo> getEmployeeInfo(@PathVariable int employeeId,
                                              @RequestParam(value = "dept") String department,
                                              @RequestParam(value = "jobTitle") String jobTitle){
        List<EmployeeInfo> employeeList = employeeService.getAllByEmployeeIdAndDepartmentAndJobTitle(employeeId,
                department, jobTitle);
        return employeeList;
    }
}
