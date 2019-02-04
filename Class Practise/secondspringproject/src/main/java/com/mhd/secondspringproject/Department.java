package com.mhd.secondspringproject;

public class Department {
    private int depId;
    private String deptName;

    public Department(int depId, String deptName) {
        this.depId = depId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
