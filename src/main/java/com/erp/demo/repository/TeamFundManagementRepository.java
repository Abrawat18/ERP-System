package com.erp.demo.repository;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.Projects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamFundManagementRepository extends CrudRepository<Projects, Integer> {

    int getByProjectIdAndManagerIdAndTeamBuildingActivityFlag(int projectId, String managerId, char teamBuildingActivityFlag);
}
