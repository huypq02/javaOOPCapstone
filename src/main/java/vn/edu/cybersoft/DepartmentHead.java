package vn.edu.cybersoft;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class DepartmentHead extends Employee implements Policy {
    final private BigDecimal salaryOneDay = new BigDecimal(200);
    final private BigDecimal bonus = new BigDecimal(100);
    private int numberOfStaffManaged;
    private List<RegularStaff> staffManaged;

    public DepartmentHead(String id, String name, String phoneNumber, int workingDays, BigDecimal salaryOneDay) {
        super(id, name, phoneNumber, workingDays, salaryOneDay);
        this.numberOfStaffManaged = 0;
        this.staffManaged = new ArrayList<>();
    }

    public DepartmentHead(){
        this.numberOfStaffManaged = 0;
        this.staffManaged = new ArrayList<>();
    }

    @Override
    public void addInformation(){
        super.addInformation();
    }

    @Override
    public void displayInformation(){
        super.displayInformation();
        System.out.println("So nhan vien quan ly: " + numberOfStaffManaged);
    }

    public int getNumberOfStaff() {
        return numberOfStaffManaged;
    }

    public void setDepartmentManaged(int numberOfStaffManaged) {
        this.numberOfStaffManaged = numberOfStaffManaged;
    }

    @Override
    public void work() {
        System.out.println("Department head is working");
    }

    public BigDecimal calculateSalary() {
        BigDecimal salaryForDaysWorked = salaryOneDay.multiply(new BigDecimal(super.getWorkingDays()));
        BigDecimal bonusForStaff = bonus.multiply(new BigDecimal(this.numberOfStaffManaged));
        return salaryForDaysWorked.add(bonusForStaff);
    }

    public void addStaff(RegularStaff regularStaff) {
        this.staffManaged.add(regularStaff);
        this.numberOfStaffManaged++;
        regularStaff.setDepartmentHead(this);
    }

    public void removeStaff(RegularStaff regularStaff) {
        this.staffManaged.remove(regularStaff);
        this.numberOfStaffManaged--;
    }

    public void removeAllStaffs() {
        for (RegularStaff staff : this.staffManaged) {
            staff.setDepartmentHead(null);
        }
        this.staffManaged.clear();
    }
}
