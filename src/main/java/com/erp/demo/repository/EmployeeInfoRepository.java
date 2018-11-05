package com.erp.demo.repository;

import com.erp.demo.domain.EmployeeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInfoRepository extends CrudRepository<EmployeeInfo, Integer> {

    List<EmployeeInfo> getAllByEmployeeIdAndDepartmentAndJobTitle(int employeeId, String department, String jobTitle);
    List<Integer> getEmployeeIdByActiveFlag(char activeFlag);
}
