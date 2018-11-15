package com.erp.demo.service;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.PositionSalary;
import com.erp.demo.repository.EmployeeInfoRepository;
import com.erp.demo.repository.SalPromCalcRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SalPromCalcService {

    @Autowired
    SalPromCalcRepository salPromCalcRepository;

    public int getBaseSalaryByPositionAndDepartment(String position, char department){
        return salPromCalcRepository.getBaseSalaryByPositionAndDepartment(position, department);
    }
}
