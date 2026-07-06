package service;

import dao.DepartmentDAO;
import model.Department;


import java.util.*;

public class DepartmentService {
    private Scanner input = new Scanner(System.in);
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public void addDepartment() {

        System.out.println("Please enter the department ID");
        int departmentId;
        while(true) {
            departmentId = input.nextInt();
            input.nextLine();
            if(departmentDAO.isDepartmentExist(departmentId)){
                System.out.println("Department already exist");
                System.out.println("Please enter the department ID");
            }else{
                break;
            }
        }
        System.out.println("Please enter the name of the department");
        String departmentName = input.nextLine();
        System.out.println("Please enter the location of the department");
        String location = input.nextLine();

        Department department = new Department(departmentId, departmentName, location);
        departmentDAO.addDepartment(department);
    }

    public void updateDepartment() {
        System.out.println("Please enter the department ID");
        int departmentId = input.nextInt();
        input.nextLine();
        System.out.println("Please enter the name of the department");
        String departmentName = input.nextLine();
        System.out.println("Please enter the location of the department");
        String location = input.nextLine();
        Department department = new Department(departmentId, departmentName, location);
        departmentDAO.updateDepartment(department);
    }


    public void deleteDepartment() {
        System.out.println("Please enter the department ID");
        int departmentId = input.nextInt();
        input.nextLine();
        departmentDAO.deleteDepartment(departmentId);
    }

    public void searchDepartment() {
        System.out.println("Please enter the department ID");
        int departmentId = input.nextInt();
        input.nextLine();
        departmentDAO.searchDepartment(departmentId);
    }

    public void displayDepartment() {
        departmentDAO.displayAllDepartments();
    }


}
