package vn.edu.cybersoft;

import java.math.BigDecimal;
import java.util.*;

public class HumanResourceManagementApplication {

    public static void main(String[] args) {
        try {
            HumanResourceManagementApplication app = new HumanResourceManagementApplication();
            List<Employee> employees = new ArrayList<>();
            Company company = new Company();
            while (true) app.menu(employees, company);
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("Lua chon khong hop le");
            }
            e.printStackTrace();
        }

    }

    public void menu(List<Employee> lists, Company company) {
        System.out.println("0. Thoat");
        System.out.println("1. Nhap thong tin cong ty");
        System.out.println("2. Phan bo Nhan vien vao Truong phong");
        System.out.println("3. Them, xoa thong tin mot nhan su");
        System.out.println("4. Xuat ra thong tin toan bo nguoi trong cong ty");
        System.out.println("5. Tinh va xuat tong luong cho toan bo cong ty");
        System.out.println("6. Tim Nhan vien thuong co luong cao nhat");
        System.out.println("7. Tim Truong phong co so nhan vien duoi quyen nhieu nhat");
        System.out.println("8. Sap xep nhan vien theo thu tu tang dan cua ten");
        System.out.println("9. Sap xep nhan vien theo thu tu giam dan cua luong");
        System.out.println("10. Tim Giam doc co so luong co phieu nhieu nhat");
        System.out.println("11. Tim va Xuat tong THU NHAP cua tung giam doc");
        System.out.println("Lua chon cua ban: ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Goodbye! See you again!");
                System.exit(0);
            case 1:
                System.out.println("Nhap thong tin cong ty");
                companyInfo(company);
                break;
            case 2:
                System.out.println("Phan bo Nhan vien vao Truong phong");
                addRegularStaffToDepartmentHead(lists);
                break;
            case 3:
                System.out.println("Them, xoa thong tin mot nhan su");
                System.out.println("1. Them thong tin mot nhan su");
                System.out.println("2. Xoa thong tin mot nhan su");
                int childChoice = sc.nextInt();
                switch (childChoice){
                    case 1:
                        System.out.println("Them thong tin mot nhan su");
                        addEmployee(lists);
                        break;
                    case 2:
                        System.out.println("Xoa thong tin mot nhan su");
                        removeEmployee(lists);
                        break;
                    default:
                        System.out.println("Lua chon khong hop le");
                        break;
                }
                break;
            case 4:
                System.out.println("Xuat ra thong tin toan bo nguoi trong cong ty");
                displayAllEmployee(lists);
                break;
            case 5:
                System.out.println("Tinh va xuat tong luong cho toan bo cong ty");
                System.out.println("Tong luong toan bo cong ty la: " + calculateTotalSalaryAMonth(lists));
                break;
            case 6:
                System.out.println("Tim Nhan vien thuong co luong cao nhat");
                findEmployeeHasHighestSalary(lists);
                break;
            case 7:
                System.out.println("Tim Truong phong co so nhan vien duoi quyen nhieu nhat");
                findDepartmentHeadHasMostStaff(lists);
                break;
            case 8:
                System.out.println("Sap xep nhan vien theo thu tu tang dan cua ten");
                rearrangeEmployeeByName(lists);
                break;
            case 9:
                System.out.println("Sap xep nhan vien theo thu tu giam dan cua luong");
                rearrangeEmployeeBySalary(lists);
                break;
            case 10:
                System.out.println("Tim Giam doc co so luong co phieu nhieu nhat");
                findDirectorHasMostStock(lists);
                break;
            case 11:
                System.out.println("Tim va Xuat tong THU NHAP cua tung giam doc");
                calculateTotalIncomeOfDirector(lists, company);
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }

    // Nhap thong tin cong ty
    public void companyInfo(Company company) {
        company.addInformation();
//        company.displayInformation();
    }

    // Phan bo Nhan vien vao Truong phong
    public void addRegularStaffToDepartmentHead(List<Employee> lists) {
        System.out.println("Nhap ma so nhan vien cua Truong phong");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        for (Employee employee : lists) {
            if (employee.getId().equals(id)) {
                if (employee instanceof DepartmentHead) {
                    DepartmentHead departmentHead = (DepartmentHead) employee;
                    System.out.println("Nhap ma so nhan vien cua Nhan vien thuong");
                    String id2 = sc.nextLine();
                    for (Employee employee1 : lists) {
                        if (employee1.getId().equals(id2)) {
                            if (employee1 instanceof RegularStaff && ((RegularStaff) employee1).getDepartmentHead() == null) {
                                RegularStaff regularStaff = (RegularStaff) employee1;
                                departmentHead.addStaff(regularStaff);
                                regularStaff.setDepartmentHead(departmentHead);
                                System.out.println("Da them nhan vien thuong vao Truong phong");
                                return;
                            }
                        }
                    }
                    System.out.println("Nhan vien thuong da co Truong phong quan ly hoac " +
                            "khong ton tai nhan vien thuong, voi ma so: " + id2);
                    return;
                }
            }
        }
        System.out.println("Khong tim thay truong phong co ma so: " + id);
    }

    // Them thong tin mot nhan su
    public void addEmployee(List<Employee> lists) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chuc vu nhan vien: ");
        System.out.println("1. Giam Doc");
        System.out.println("2. Truong Phong");
        System.out.println("3. Nhan vien thuong");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                Director director = new Director();
                director.addInformation();
                for (Employee employee : lists) {
                    if (employee.getId().equals(director.getId())) {
                        System.out.println("Ma so nhan vien da ton tai");
                        return;
                    }
                }
                lists.add(director);
                break;
            case 2:
                DepartmentHead departmentHead = new DepartmentHead();
                departmentHead.addInformation();
                for (Employee employee : lists) {
                    if (employee.getId().equals(departmentHead.getId())) {
                        System.out.println("Ma so nhan vien da ton tai");
                        return;
                    }
                }
                lists.add(departmentHead);
                break;
            case 3:
                RegularStaff regularStaff = new RegularStaff();
                regularStaff.addInformation();
                for (Employee employee : lists) {
                    if (employee.getId().equals(regularStaff.getId())) {
                        System.out.println("Ma so nhan vien da ton tai");
                        return;
                    }
                }
                lists.add(regularStaff);
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }
    // Xoa thong tin mot nhan su
    public void removeEmployee(List<Employee> lists) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma so nhan vien can xoa: ");
        String id = sc.nextLine();
        for (Employee employee : lists) {
            if (employee.getId().equals(id)) {
                lists.remove(employee);
                if (employee instanceof DepartmentHead) {
                    DepartmentHead departmentHead = (DepartmentHead) employee;
                    departmentHead.removeAllStaffs();
                }
                if (employee instanceof RegularStaff) {
                    RegularStaff regularStaff = (RegularStaff) employee;
                    regularStaff.getDepartmentHead().removeStaff(regularStaff);
                }
                System.out.println("Da xoa nhan vien co ma so: " + id);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma so: " + id);
    }

    // Xuat ra thong tin toan bo nguoi trong cong ty
    public void displayAllEmployee(List<Employee> lists) {
        for (Employee employee : lists) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                director.displayInformation();
            } else if (employee instanceof DepartmentHead) {
                DepartmentHead departmentHead = (DepartmentHead) employee;
                departmentHead.displayInformation();
            } else {
                RegularStaff regularStaff = (RegularStaff) employee;
                regularStaff.displayInformation();
            }
        }
    }

    // Tinh va xuat tong luong cho toan bo cong ty
    public BigDecimal calculateTotalSalaryAMonth(List<Employee> lists) {
        BigDecimal totalSalary = BigDecimal.valueOf(0);
        for (Employee employee : lists) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                totalSalary = totalSalary.add(director.calculateSalary());
//                System.out.println("Luong cua " + director.getName() + " la: " + director.calculateSalary());
            } else if (employee instanceof DepartmentHead) {
                DepartmentHead departmentHead = (DepartmentHead) employee;
                totalSalary = totalSalary.add(departmentHead.calculateSalary());
//                System.out.println("Luong cua " + departmentHead.getName() + " la: " + departmentHead.calculateSalary());
            } else {
                RegularStaff regularStaff = (RegularStaff) employee;
                totalSalary = totalSalary.add(regularStaff.calculateSalary());
//                System.out.println("Luong cua " + regularStaff.getName() + " la: " + regularStaff.calculateSalary());
            }
        }
        return totalSalary;
    }

    // Nhan vien thuong co luong cao nhat
    public void findEmployeeHasHighestSalary(List<Employee> lists) {
        BigDecimal maxSalary = BigDecimal.valueOf(0);
        List <RegularStaff> regularStaffWithMaxSalaryList = new ArrayList<>();
        for (Employee employee : lists) {
            if (employee instanceof RegularStaff) {
                RegularStaff regularStaff = (RegularStaff) employee;
                if (regularStaff.calculateSalary().compareTo(maxSalary) > 0){
                    maxSalary = regularStaff.calculateSalary();
                }
            }
        }
        if (maxSalary.compareTo(BigDecimal.valueOf(0)) == 0) {
            System.out.println("Khong co nhan vien thuong nao trong cong ty co luong");
            return;
        }

        for (Employee employee : lists) {
            if (employee instanceof RegularStaff) {
                RegularStaff regularStaff = (RegularStaff) employee;
                if (Objects.equals(regularStaff.calculateSalary(), maxSalary)) {
                    regularStaffWithMaxSalaryList.add(regularStaff);
                }
            }
        }

        for (RegularStaff regularStaff : regularStaffWithMaxSalaryList) {
            System.out.println("Nhan vien thuong co luong cao nhat la: " + regularStaff.getName());
        }
    }

    // Truong phong co so luong nhan vien duoi quyen nhieu nhat
    public void findDepartmentHeadHasMostStaff(List<Employee> lists) {
        int maxStaff = 0;
        List <DepartmentHead> departmentHeadWithMostStaffList = new ArrayList<>();
        for (Employee employee : lists) {
            if (employee instanceof DepartmentHead) {
                DepartmentHead departmentHead = (DepartmentHead) employee;
                if (departmentHead.getNumberOfStaff() > maxStaff) {
                    maxStaff = departmentHead.getNumberOfStaff();
                }
            }
        }
        if (maxStaff == 0) {
            System.out.println("Khong co truong phong nao trong cong ty co nhan vien duoi quyen");
            return;
        }

        for (Employee employee : lists) {
            if (employee instanceof DepartmentHead) {
                DepartmentHead departmentHead = (DepartmentHead) employee;
                if (departmentHead.getNumberOfStaff() == maxStaff) {
                    departmentHeadWithMostStaffList.add(departmentHead);
                }
            }
        }

        for (DepartmentHead departmentHead : departmentHeadWithMostStaffList) {
            System.out.println("Truong phong co so nhan vien duoi quyen nhieu nhat la: " + departmentHead.getName());
        }
    }

    //  Sap xep nhan vien theo thu tu tang dan cua ten (abc)
    public void rearrangeEmployeeByName(List<Employee> lists) {
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                if (lists.get(i).getName().compareTo(lists.get(j).getName()) > 0) {
                    Employee temp = lists.get(i);
                    lists.set(i, lists.get(j));
                    lists.set(j, temp);
                }
            }
        }
        System.out.println("Danh sach nhan vien sau khi sap xep theo ten: ");
        for (Employee employee : lists) {
            System.out.println(employee.getName());
        }
    }

    // Sap xep nhan vien theo thu tu giam dan cua luong
    public void rearrangeEmployeeBySalary(List<Employee> lists) {
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                if (lists.get(i) instanceof RegularStaff regularStaff) {
                    if (lists.get(j) instanceof RegularStaff regularStaff2) {
                        if (regularStaff.calculateSalary().compareTo(regularStaff2.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    } else if (lists.get(j) instanceof DepartmentHead departmentHead) {
                        if (regularStaff.calculateSalary().compareTo(departmentHead.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    } else {
                        Director director = (Director) lists.get(j);
                        if (regularStaff.calculateSalary().compareTo(director.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    }
                }
                else if (lists.get(i) instanceof DepartmentHead departmentHead) {
                    if (lists.get(j) instanceof RegularStaff regularStaff) {
                        if (departmentHead.calculateSalary().compareTo(regularStaff.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    } else if (lists.get(j) instanceof DepartmentHead departmentHead2) {
                        if (departmentHead.calculateSalary().compareTo(departmentHead2.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    } else {
                        Director director = (Director) lists.get(j);
                        if (departmentHead.calculateSalary().compareTo(director.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    }
                }
                else {
                    Director director = (Director) lists.get(i);
                    if (lists.get(j) instanceof RegularStaff regularStaff) {
                        if (director.calculateSalary().compareTo(regularStaff.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    } else if (lists.get(j) instanceof DepartmentHead departmentHead) {
                        if (director.calculateSalary().compareTo(departmentHead.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    } else {
                        Director director2 = (Director) lists.get(j);
                        if (director.calculateSalary().compareTo(director2.calculateSalary()) < 0) {
                            Employee temp = lists.get(i);
                            lists.set(i, lists.get(j));
                            lists.set(j, temp);
                        }
                    }
                }
            }
        }
        System.out.println("Danh sach nhan vien sau khi sap xep theo luong: ");
        for (Employee employee : lists) {
            System.out.println(employee.getName());
        }
    }

    // Tim Giam doc co so luong co phieu nhieu nhat
    public void findDirectorHasMostStock(List<Employee> lists) {
        double maxStock = 0;
        List <Director> directorWithMostStockList = new ArrayList<>();
        for (Employee employee : lists) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                if (director.getShareRate() > maxStock) {
                    maxStock = director.getShareRate();
                }
            }
        }
        if (maxStock == 0) {
            System.out.println("Khong co giam doc nao trong cong ty co so luong co phieu");
            return;
        }

        for (Employee employee : lists) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                if (director.getShareRate() == maxStock) {
                    directorWithMostStockList.add(director);
                }
            }
        }

        for (Director directorWithMostStock : directorWithMostStockList) {
            System.out.println("Giam doc co so luong co phieu nhieu nhat la: " + directorWithMostStock.getName());
        }
    }

    // Tinh va Xuat tong THU NHAP cua tung giam doc
    // Thu nhap = Luong + so co phan * Loi nhuan cong ty
    // Loi nhuan cong ty = Doanh thu thang - Tong luong cua toan bo nhan vien
    public void calculateTotalIncomeOfDirector(List<Employee> lists, Company company) {
        if (company.getRevenuePerMonth() == null) {
            System.out.println("Chua nhap thong tin cong ty");
            return;
        }
        if (lists.isEmpty()) {
            System.out.println("Chua co nhan vien nao trong cong ty");
            return;
        }

        BigDecimal totalSalary = calculateTotalSalaryAMonth(lists);
        BigDecimal profit = company.getRevenuePerMonth().subtract(totalSalary);
        for (Employee employee : lists) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                BigDecimal salary = director.calculateSalary();
                BigDecimal stock = BigDecimal.valueOf(director.getShareRate()/100);
                BigDecimal income = salary.add(stock.multiply(profit));
                System.out.println("Thu nhap cua " + director.getName() + " la: " + income);
            }
        }
    }
}