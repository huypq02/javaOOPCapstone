package vn.edu.cybersoft;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vn.edu.cybersoft.humanResourceValidator;
import vn.edu.cybersoft.validator.humanResourceValidator;

public abstract class Employee {
    private String id;
    private String name;
    private String phoneNumber;
    private int workingDays;
    private BigDecimal salaryOneDay;

    public Employee(String id, String name, String phoneNumber, int workingDays, BigDecimal salaryOneDay) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.workingDays = workingDays;
        this.salaryOneDay = salaryOneDay;
    }

    public Employee(){}

    public void addInformation(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so nhan vien: ");
        this.id = sc.nextLine();
        if (!humanResourceValidator.isId(this.id)) {
            System.out.println("Ma so nhan vien khong hop le");
            return;
        }
        System.out.print("Nhap ten nhan vien: ");
        this.name = sc.nextLine();
        if (!humanResourceValidator.isName(this.name)) {
            System.out.println("Ten nhan vien khong hop le");
            return;
        }
        System.out.print("Nhap so dien thoai: ");
        this.phoneNumber = sc.nextLine();
        if (!humanResourceValidator.isPhoneNumber(this.phoneNumber)) {
            System.out.println("So dien thoai khong hop le");
            return;
        }
        System.out.print("Nhap so ngay lam viec: ");
        this.workingDays = sc.nextInt();
        if (!humanResourceValidator.isWorkingDays(this.workingDays)) {
            System.out.println("So ngay lam viec khong hop le");
            return;
        }
    }

    public void displayInformation(){
        System.out.println("Ma so nhan vien: " + id);
        System.out.println("Ten nhan vien: " + name);
        System.out.println("So dien thoai: " + phoneNumber);
        System.out.println("So ngay lam viec: " + workingDays);
    }

    public void work() {
        System.out.println("Employee is working");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public BigDecimal getSalaryOneDay() {
        return salaryOneDay;
    }

    public void setSalaryOneDay(BigDecimal salaryOneDay) {
        this.salaryOneDay = salaryOneDay;
    }
}
