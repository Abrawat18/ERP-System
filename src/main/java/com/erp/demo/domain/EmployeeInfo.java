package com.erp.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@SqlResultSetMapping(
        name="incrementFactors",
        columns = {
                @ColumnResult(name = "totalHoursPunched"),
                @ColumnResult(name = "monthlyHours"),
                @ColumnResult(name = "joiningDate"),
                @ColumnResult(name = "monthlyLeaves"),
                @ColumnResult(name = "totalLeavesTaken"),
                @ColumnResult(name = "ratingByManager")
        }
)

@NamedNativeQuery(name="EmployeeInfo.getTotalHoursPunched", query = "select t.totalHoursPunched as totalHoursPunched, ps.monthlyHours as monthlyHours, h.joiningDate as joiningDate, ps.monthlyLeaves as monthlyLeaves, t.totalLeavesTaken as totalLeavesTaken, t.ratingByManager as ratingByManager " +
        "from Timesheet t, PositionSalary ps, HiringInfo h, EmployeeInfo e " +
        "where e.employeeId = 1 and ps.department = e.department and ps.position = e.jobTitle " +
        "and t.employeeId = e.employeeId and h.employeeId = e.employeeId", resultSetMapping = "incrementFactors")
@Entity
@Table(name = "EmployeeInfo")
public class EmployeeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private String emailId;
    private Date dateOfBirth;
    private char gender;
    private int phoneNo;
    private String department;
    private String jobTitle;
    private int managerId;
    private char activeFlag;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public char getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(char activeFlag) {
        this.activeFlag = activeFlag;
    }
}
