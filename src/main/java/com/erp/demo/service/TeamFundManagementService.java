package com.erp.demo.service;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.Projects;
import com.erp.demo.repository.EmployeeInfoRepository;
import com.erp.demo.repository.TeamFundManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamFundManagementService {

    @Autowired
    TeamFundManagementRepository teamFundManagementRepository;

    public List<Projects> getByProjectIdAndManagerIdAndTeamBuildingActivity(int projectId, String managerId, char teamBuildingActivityFlag){
        return teamFundManagementRepository.getByProjectIdAndManagerIdAndTeamBuildingActivity(projectId, managerId,teamBuildingActivityFlag);
    }

}
