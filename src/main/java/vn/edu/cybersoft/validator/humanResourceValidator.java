package vn.edu.cybersoft.validator;

import vn.edu.cybersoft.Company;

import java.util.List;

public class humanResourceValidator {
    public static boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("0\\d{9}");
    }

    public static boolean isTaxCode(String taxCode) {
        return taxCode.matches("\\d{10}");
    }

    public static boolean isWorkingDays(int workingDays) {
        return workingDays >= 0 && workingDays <= 31;
    }

    public static boolean isShareRate(double shareRate) {
        return shareRate >= 0 && shareRate <= 100;
    }

    public static boolean isSalaryOneDay(String salaryOneDay) {
        return salaryOneDay.matches("\\d+");
    }

    public static boolean isDepartmentHeadId(String departmentHeadId) {
        return departmentHeadId.matches("TP\\d{3}");
    }

    public static boolean isId(String id) {
        return id.matches("\\d{3}");
    }

    public static boolean isName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    public static boolean isWorkingDays(String workingDays) {
        return workingDays.matches("\\d+");
    }
}
