package com.erp.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Projects")
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String teamId;
    private String managerId;
    private int alloatedPartyFunds;
    private boolean teamBuildingActivityFlag;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public int getAlloatedPartyFunds() {
        return alloatedPartyFunds;
    }

    public void setAlloatedPartyFunds(int alloatedPartyFunds) {
        this.alloatedPartyFunds = alloatedPartyFunds;
    }

    public boolean isTeamBuildingActivityFlag() {
        return teamBuildingActivityFlag;
    }

    public void setTeamBuildingActivityFlag(boolean teamBuildingActivityFlag) {
        this.teamBuildingActivityFlag = teamBuildingActivityFlag;
    }
}
