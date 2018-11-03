package com.erp.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "HiringInfo")
public class HiringInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hiringId;
    private int applicationid;
    private char employmentType;
    private Date joiningDate;
    private Date leavingDate;
    private Date trainingDate;
    private char docSubmitted;

    public int getHiringId() {
        return hiringId;
    }

    public void setHiringId(int hiringId) {
        this.hiringId = hiringId;
    }

    public int getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(int applicationid) {
        this.applicationid = applicationid;
    }

    public char getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(char employmentType) {
        this.employmentType = employmentType;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public char getDocSubmitted() {
        return docSubmitted;
    }

    public void setDocSubmitted(char docSubmitted) {
        this.docSubmitted = docSubmitted;
    }
}
