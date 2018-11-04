package com.erp.demo.service;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    public List<EmployeeInfo> getAllByEmployeeIdAndDepartmentAndJobTitle(int employeeId, String department, String jobTitle){
        return employeeInfoRepository.getAllByEmployeeIdAndDepartmentAndJobTitle(employeeId, department, jobTitle);
    }

}
