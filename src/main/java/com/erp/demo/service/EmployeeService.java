package com.erp.demo.service;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.IncrementFactors;
import com.erp.demo.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    SalPromCalcService salPromCalcService;

    public List<EmployeeInfo> getAllByEmployeeIdAndDepartmentAndJobTitle(int employeeId, String department, String jobTitle){
        return employeeInfoRepository.getAllByEmployeeIdAndDepartmentAndJobTitle(employeeId, department, jobTitle);
    }

    public List<EmployeeInfo> getAllByEmployeeId(int employeeId){
        return employeeInfoRepository.getAllByEmployeeId(employeeId);
    }

    public List<EmployeeInfo> getAllByDepartmentAndJobTitle(String department, String jobTitle){
        return employeeInfoRepository.getAllByDepartmentAndJobTitle(department, jobTitle);
    }

    public int addNewJoinee(char gender, String department, String jobTitle,
                                int managerId, char activeFlag){

            EmployeeInfo employeeInfo = new EmployeeInfo();

            employeeInfo.setGender(gender);
            employeeInfo.setDepartment(department);
            employeeInfo.setJobTitle(jobTitle);
            employeeInfo.setManagerId(managerId);
            employeeInfo.setActiveFlag(activeFlag);
            return employeeInfoRepository.save(employeeInfo).getEmployeeId();
    }

    public boolean updateSalaryIncrement(int employeeId) {
        IncrementFactors incrementFactors = employeeInfoRepository.calcPromInc(employeeId);
        if(incrementFactors!=null){
            System.out.println("this is my result: "+incrementFactors.getRatingByManager());
            if(salPromCalcService.calcPromInc(incrementFactors))
                return true;
        }

        return false;
    }
}
