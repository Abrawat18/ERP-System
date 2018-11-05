package com.erp.demo.controller;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.Projects;
import com.erp.demo.service.EmployeeService;
import com.erp.demo.service.TeamFundManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TeamFund")
public class TeamFundController {

    @Autowired
    TeamFundManagementService teamFundManagementService;

    @GetMapping("/{projectId}")
    public int getAvailablePartyFund(@PathVariable int projectId,
                                          @RequestParam(value = "managerId") String managerId,
                                          @RequestParam(value = "teamBuildingActFlag") char teamBuildingActivityFlag){
        return teamFundManagementService.getByProjectIdAndManagerIdAndTeamBuildingActivityFlag(projectId,
                managerId, teamBuildingActivityFlag);

    }
}
