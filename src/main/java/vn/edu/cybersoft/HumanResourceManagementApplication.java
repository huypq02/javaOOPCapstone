package vn.edu.cybersoft;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanResourceManagementApplication {
    public static void main(String[] args) {
        HumanResourceManagementApplication app = new HumanResourceManagementApplication();
        List<Employee> employees = new ArrayList<>();
        while (true) app.menu(employees);
    }

    public void menu(List<Employee> lists) {
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
                companyInfo();
                break;
            case 2:
                // todo fix after
                System.out.println("Phan bo Nhan vien vao Truong phong");
                addRegularStaffToDepartmentHead();
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
                calculateTotalSalary(lists);
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

                break;
            case 11:
                System.out.println("Tim va Xuat tong THU NHAP cua tung giam doc");
                break;
            default:
                System.out.println("Lua chon khong hop le");
                break;
        }
    }

    // Nhap thong tin cong ty
    public void companyInfo() {
        Company company = new Company();
        company.addInformation();
//        company.displayInformation();
    }

    // Phan bo Nhan vien vao Truong phong
    public void addRegularStaffToDepartmentHead() {
        RegularStaff regularStaff = new RegularStaff();
        regularStaff.addInformation();
        DepartmentHead departmentHead = new DepartmentHead();
        departmentHead.addInformation();
        regularStaff.setDepartmentHead(departmentHead);
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
                lists.add(director);
                break;
            case 2:
                DepartmentHead departmentHead = new DepartmentHead();
                departmentHead.addInformation();
                lists.add(departmentHead);
                break;
            case 3:
                RegularStaff regularStaff = new RegularStaff();
                regularStaff.addInformation();
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
    public void calculateTotalSalary(List<Employee> lists) {
        for (Employee employee : lists) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                System.out.println("Luong cua " + director.getName() + " la: " + director.calculateSalary());
            } else if (employee instanceof DepartmentHead) {
                DepartmentHead departmentHead = (DepartmentHead) employee;
                System.out.println("Luong cua " + departmentHead.getName() + " la: " + departmentHead.calculateSalary());
            } else {
                RegularStaff regularStaff = (RegularStaff) employee;
                System.out.println("Luong cua " + regularStaff.getName() + " la: " + regularStaff.calculateSalary());
            }
        }
    }

    // Nhan vien thuong co luong cao nhat
    public void findEmployeeHasHighestSalary(List<Employee> lists) {
        BigDecimal maxSalary = BigDecimal.valueOf(0);
        RegularStaff regularStaffWithMaxSalary = new RegularStaff();
        for (Employee employee : lists) {
            if (employee instanceof RegularStaff) {
                RegularStaff regularStaff = (RegularStaff) employee;
                if (regularStaff.calculateSalary().compareTo(maxSalary) > 0){
                    maxSalary = regularStaff.calculateSalary();
                    regularStaffWithMaxSalary = regularStaff;
                }
            }
        }
        if (maxSalary.compareTo(BigDecimal.valueOf(0)) == 0) {
            System.out.println("Khong co nhan vien thuong nao trong cong ty co luong");
            return;
        }
        System.out.println("Nhan vien thuong co luong cao nhat la: " + regularStaffWithMaxSalary.getName());
    }

    // Truong phong co so luong nhan vien duoi quyen nhieu nhat
    public void findDepartmentHeadHasMostStaff(List<Employee> lists) {
        int maxStaff = 0;
        DepartmentHead departmentHeadWithMostStaff = new DepartmentHead();
        for (Employee employee : lists) {
            if (employee instanceof DepartmentHead) {
                DepartmentHead departmentHead = (DepartmentHead) employee;
                if (departmentHead.getNumberOfStaff() > maxStaff) {
                    maxStaff = departmentHead.getNumberOfStaff();
                    departmentHeadWithMostStaff = departmentHead;
                }
            }
        }
        if (maxStaff == 0) {
            System.out.println("Khong co truong phong nao trong cong ty co nhan vien duoi quyen");
            return;
        }
        System.out.println("Truong phong co so nhan vien duoi quyen nhieu nhat la: " + departmentHeadWithMostStaff.getName());
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
        Director directorWithMostStock = new Director();
        for (Employee employee : lists) {
            if (employee instanceof Director) {
                Director director = (Director) employee;
                if (director.getShareRate() > maxStock) {
                    maxStock = director.getShareRate();
                    directorWithMostStock = director;
                }
            }
        }
        if (maxStock == 0) {
            System.out.println("Khong co giam doc nao trong cong ty co so luong co phieu");
            return;
        }
        System.out.println("Giam doc co so luong co phieu nhieu nhat la: " + directorWithMostStock.getName());
    }
}