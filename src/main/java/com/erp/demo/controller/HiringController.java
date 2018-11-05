package com.erp.demo.controller;

import com.erp.demo.domain.HiringInfo;
import com.erp.demo.service.HiringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/hiring")
public class HiringController {

    @Autowired
    private HiringService hiringService;

    @GetMapping("/joinees")
    public List<HiringInfo> getJoineeDetails(@RequestParam(value = "training") Date trainingDate,
                                             @RequestParam(value = "docs") char documentsSubmitted,
                                             @RequestParam(value = "joining") Date joiningDate) {
        List<HiringInfo> newJoineeList = hiringService.getJoineeDetails(trainingDate, documentsSubmitted, joiningDate);
        return newJoineeList;
    }

    @PutMapping("/{hiringId}")
    public String updateJoineeDetails(@PathVariable int hiringId,
                                      @RequestParam(value = "training") Date trainingDate,
                                      @RequestParam(value = "docs") char documentsSubmitted) {
        if(hiringId < 0)
            return "Employee not found";

        boolean ifUpdate = hiringService.updateHireeDetails(hiringId, trainingDate, documentsSubmitted);

        if(ifUpdate)
            return "Details updated successfully";
        else
            return "Details could not be updated";
    }
}
