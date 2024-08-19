package vn.edu.cybersoft;

import java.math.BigDecimal;
import java.util.Scanner;

public class RegularStaff extends Employee implements Policy {
    final private BigDecimal salaryOneDay = new BigDecimal(100);
    private String departmentHeadId;
    private DepartmentHead departmentHead;

    public RegularStaff(String id, String name, String phoneNumber, int workingDays, BigDecimal salaryOneDay) {
        super(id, name, phoneNumber, workingDays, salaryOneDay);
        this.departmentHead = departmentHead;
    }

    public RegularStaff(){
    }

    @Override
    public void addInformation(){
        super.addInformation();
    }

    @Override
    public void displayInformation(){
        super.displayInformation();
        System.out.println("Ma so truong phong quan ly: " + departmentHeadId);
    }

    public DepartmentHead getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(DepartmentHead departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getDepartmentHeadId() {
        return departmentHeadId;
    }

    public void setDepartmentHeadId(String departmentHeadId) {
        this.departmentHeadId = departmentHeadId;
    }

    @Override
    public void work() {
        System.out.println("Regular staff is working");
    }

    public BigDecimal calculateSalary() {
        return salaryOneDay.multiply(new BigDecimal(super.getWorkingDays()));
    }
}
