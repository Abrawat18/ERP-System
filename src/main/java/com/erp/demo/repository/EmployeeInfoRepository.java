package com.erp.demo.repository;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.IncrementFactors;
import com.erp.demo.domain.Payroll;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInfoRepository extends CrudRepository<EmployeeInfo, Integer> {

    List<EmployeeInfo> getAllByEmployeeIdAndDepartmentAndJobTitle(int employeeId, String department, String jobTitle);
    List<Integer> getEmployeeIdByActiveFlag(char activeFlag);
    String getEmailIdByEmployeeId(int employeeId);
    List<EmployeeInfo> getAllByEmployeeId(int employeeId);
    List<EmployeeInfo> getAllByDepartmentAndJobTitle(String department, String jobTitle);
    IncrementFactors calcPromInc();
}
