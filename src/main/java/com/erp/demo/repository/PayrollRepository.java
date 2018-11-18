package com.erp.demo.repository;

import com.erp.demo.domain.Payroll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll, Integer> {

    Payroll getByEmployeeId(int employeeId);
}
