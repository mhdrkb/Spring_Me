package com.mhd.autowire2.bean.scope.request;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class EmployeeDetails {
    private Employee employee;
    private int lastYearSalary;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getLastYearSalary() {
        return lastYearSalary;
    }

    public void setLastYearSalary(int lastYearSalary) {
        this.lastYearSalary = lastYearSalary;
    }
}
