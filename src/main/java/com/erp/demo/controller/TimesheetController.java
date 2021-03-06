package com.erp.demo.controller;

import com.erp.demo.domain.Timesheet;
import com.erp.demo.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    TimesheetService timesheetService;

    @GetMapping("/{employeeId}")
    public List<Timesheet> getTimesheetInfo(@PathVariable int employeeId,
                                            @RequestParam(value = "month") String month,
                                            @RequestParam(value = "year") int financialYear){
        return timesheetService.getAllByEmployeeIdAndMonthAndFinancialYear(employeeId, month, financialYear);
    }

    @GetMapping("/sendIntimation")
    public HashMap<Integer, String> sendIntimation(){
        return timesheetService.sendIntimation();
    }
}
