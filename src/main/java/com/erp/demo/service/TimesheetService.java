package com.erp.demo.service;

import com.erp.demo.domain.Timesheet;
import com.erp.demo.repository.EmployeeInfoRepository;
import com.erp.demo.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService {

    @Autowired
    TimesheetRepository timesheetRepository;

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    public List<Timesheet> getAllByEmployeeIdAndMonthAndFinancialYear(int employeeId, String month, int financialYear){
        return timesheetRepository.getAllByEmployeeIdAndMonthAndFinancialYear(employeeId, month, financialYear);
    }

    public List<Timesheet> sendIntimation(){

    }
}
