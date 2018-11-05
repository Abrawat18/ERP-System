package com.erp.demo.controller;

import com.erp.demo.domain.HiringInfo;
import com.erp.demo.domain.PositionSalary;
import com.erp.demo.service.HiringService;
import com.erp.demo.service.SalPromCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/salPromCalc")
public class SalPromCalcController {

    @Autowired
    private SalPromCalcService salPromCalcService;

    @GetMapping("/joineesal")
    public int getNewJoineeSal(@RequestParam(value = "position") String position,
                                                @RequestParam(value = "employmentType") char employmentType) {
        int newJoineeSal = salPromCalcService.getBaseSalaryByPositionAndEmploymentType(position, employmentType);
        return newJoineeSal;
    }
}
