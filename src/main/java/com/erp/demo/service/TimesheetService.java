package com.erp.demo.service;

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
        List<Integer> activeEmployees = employeeInfoRepository.getEmployeeIdByActiveFlag('Y');
        for(int id: activeEmployees){
            if(!timesheetRepository.existsById(id)) {
                String email = employeeInfoRepository.getEmailIdByEmployeeId(id);
                missingTimesheetEmpDetails.put(id, email);
                emailIds.add(email);
            }
        }

        emailService.sendEmail(emailIds);

        return missingTimesheetEmpDetails;
    }
}
