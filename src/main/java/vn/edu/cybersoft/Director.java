package vn.edu.cybersoft;

import java.math.BigDecimal;
import java.util.Scanner;

public class Director extends Employee implements Policy {
    final private BigDecimal salaryOneDay = new BigDecimal(300);
    private double shareRate;

    public Director(String id, String name, String phoneNumber, int workingDays, BigDecimal salaryOneDay, double shareRate) {
        super(id, name, phoneNumber, workingDays, salaryOneDay);
        this.shareRate = shareRate;
    }

    public Director(){
    }

    @Override
    public void addInformation(){
        super.addInformation();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ty le co phan trong cong ty (%): ");
        this.shareRate = sc.nextDouble();
    }

    @Override
    public void displayInformation(){
        super.displayInformation();
        System.out.println("Ty le co phan trong cong ty (%): " + shareRate);
    }

    @Override
    public void work() {
        System.out.println("Director is working");
    }

    public BigDecimal calculateSalary() {
        return salaryOneDay.multiply(new BigDecimal(super.getWorkingDays()));
    }

    @Override
    public BigDecimal getSalaryOneDay() {
        return salaryOneDay;
    }

    public double getShareRate() {
        return shareRate;
    }

    public void setShareRate(double shareRate) {
        this.shareRate = shareRate;
    }
}
