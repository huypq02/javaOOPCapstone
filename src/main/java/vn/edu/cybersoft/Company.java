package vn.edu.cybersoft;

import java.math.BigDecimal;
import java.util.Scanner;

public class Company {
    private String name;
    private String taxCode;
    private BigDecimal revenuePerMonth;

    public Company(String name, String taxCode, BigDecimal revenuePerMonth) {
        this.name = name;
        this.taxCode = taxCode;
        this.revenuePerMonth = revenuePerMonth;
    }

    public Company() {
    }

    public void addInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten cong ty: ");
        name = sc.nextLine();
        System.out.print("Nhap ma so thue: ");
        taxCode = sc.nextLine();
        System.out.print("Nhap doanh thu thang: ");
        revenuePerMonth = sc.nextBigDecimal();
    }

    public void displayInformation() {
        System.out.println("Ten cong ty: " + name);
        System.out.println("Ma so thue: " + taxCode);
        System.out.println("Doanh thu thang: " + revenuePerMonth);
    }

//    public void paySalary(Employee employee) {
//        BigDecimal salary = employee.calculateSalary();
//        System.out.println("Salary of " + employee.getName() + " is " + salary);
//    }
//
//    public void payBonus(Employee employee) {
//        BigDecimal bonus = employee.calculateBonus();
//        System.out.println("Bonus of " + employee.getName() + " is " + bonus);
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public BigDecimal getRevenuePerMonth() {
        return revenuePerMonth;
    }

    public void setRevenuePerMonth(BigDecimal revenuePerMonth) {
        this.revenuePerMonth = revenuePerMonth;
    }
}
