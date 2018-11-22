package com.erp.demo.service;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.Timesheet;
import com.erp.demo.repository.EmployeeInfoRepository;
import com.erp.demo.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TimesheetService {

    @Autowired
    TimesheetRepository timesheetRepository;

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    EmailService emailService;

    public List<Timesheet> getAllByEmployeeIdAndMonthAndFinancialYear(int employeeId, String month, int financialYear){
        return timesheetRepository.getAllByEmployeeIdAndMonthAndFinancialYear(employeeId, month, financialYear);
    }

    public HashMap<Integer, String> sendIntimation(){
        HashMap<Integer, String> missingTimesheetEmpDetails = new HashMap<>();
        List<String> emailIds = new ArrayList<>();
        List<EmployeeInfo> activeEmployees = employeeInfoRepository.getAllByActiveFlag('Y');
        for(EmployeeInfo employee: activeEmployees){
            if(!timesheetRepository.existsById(employee.getEmployeeId())) {
                missingTimesheetEmpDetails.put(employee.getEmployeeId(), employee.getEmailId());
                emailIds.add(employee.getEmailId());
            }
        }

        emailService.sendEmail(emailIds);

        return missingTimesheetEmpDetails;
    }
}
