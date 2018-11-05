package com.erp.demo.repository;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.PositionSalary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalPromCalcRepository extends CrudRepository<PositionSalary, Integer> {

    int getBaseSalaryByPositionAndEmploymentType(String position, char employmentType);
    //List<Integer> getEmployeeIdByActiveFlag(char activeFlag);
}
