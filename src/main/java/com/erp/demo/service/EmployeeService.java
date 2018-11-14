package com.erp.demo.service;

import com.erp.demo.domain.EmployeeInfo;
import com.erp.demo.domain.IncrementFactors;
import com.erp.demo.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    public List<EmployeeInfo> getAllByEmployeeIdAndDepartmentAndJobTitle(int employeeId, String department, String jobTitle){
        return employeeInfoRepository.getAllByEmployeeIdAndDepartmentAndJobTitle(employeeId, department, jobTitle);
    }

    public List<EmployeeInfo> getAllByEmployeeId(int employeeId){
        return employeeInfoRepository.getAllByEmployeeId(employeeId);
    }

    public List<EmployeeInfo> getAllByDepartmentAndJobTitle(String department, String jobTitle){
        return employeeInfoRepository.getAllByDepartmentAndJobTitle(department, jobTitle);
    }

    public int addNewJoinee(char gender, String department, String jobTitle,
                                int managerId, char activeFlag){

            EmployeeInfo employeeInfo = new EmployeeInfo();

            employeeInfo.setGender(gender);
            employeeInfo.setDepartment(department);
            employeeInfo.setJobTitle(jobTitle);
            employeeInfo.setManagerId(managerId);
            employeeInfo.setActiveFlag(activeFlag);
            return employeeInfoRepository.save(employeeInfo).getEmployeeId();
    }

    public Object updateSalaryIncrement(int employeeId) {
        IncrementFactors incrementFactors = employeeInfoRepository.getTotalHoursPunched();
        if(incrementFactors!=null){
            /*Gson gson = new Gson();
            String jsonToString = gson.toJson(incrementFactors);
            Map<String, Object> map = gson.fromJson(jsonToString, new TypeToken<Map<String, Object>>(){}.getType());
            System.out.println("the object is:"+incrementFactors);
            float finalIncrementFactor = map.get("RatingByManager")*/
            System.out.println("this is my result: "+incrementFactors.getTotalHoursPunched());
            return incrementFactors;
        }

        return "failure";
    }
}
