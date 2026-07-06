package service;
import dao.*;
import model.Employee;

import java.util.*;

public class EmployeeService {
    private Scanner input = new Scanner(System.in);
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public void addEmployee() {
        System.out.println("Enter Employee ID");
        int employeeID;
        while(true){
            employeeID = input.nextInt();
            if(employeeDAO.employeeExists(employeeID)){
                System.out.println("Employee ID already exists");
                System.out.println("Enter Employee ID");
            }else {
                input.nextLine();
                break;
            }
        }
        System.out.println("Enter Employee Name");
        String employeeName = input.nextLine();
        System.out.println("Enter the email address");
        String employeeEmail;
        while (true){
            employeeEmail = input.nextLine();
            if(employeeDAO.emailExists(employeeEmail) && employeeDAO.emailValid(employeeEmail)){
                System.out.println("Email already exists");
                System.out.println("Please enter a valid email address");
            }else  {
                break;
            }
        }
        System.out.println("Enter Employee Phone");
        String employeePhone;
        while (true){
            employeePhone = input.nextLine();
            if(employeeDAO.phoneExists(employeePhone) && employeeDAO.phoneValid(employeePhone)){
                System.out.println("Phone already exists or incorrect format");
                System.out.println("Please enter a valid phone number");
            }else   {
                break;
            }
        }
        System.out.println("Enter the Salary amount");
        Double salary = input.nextDouble();
        input.nextLine();
        System.out.println("Enter the Employee Designation");
        String designation = input.nextLine();
        System.out.println("Enter the Employee status");
        String status = input.nextLine();
        System.out.println("Enter the Department ID");
        int departmentid;
        while(true){
            departmentid = input.nextInt();
            if(!departmentDAO.isDepartmentExist(departmentid)){
                System.out.println("Department ID not exists");
                System.out.println("Please enter a valid department ID or Add the Department");
            }else  {
                break;
            }
        }
        Employee employee = new Employee(employeeID,employeeName,employeeEmail,employeePhone,salary,designation,status,departmentid);
        if(employeeDAO.addEmployee(employee)){
            System.out.println("Employee added successfully");
        }else{
            System.out.println("Employee not added successfully");
        }
    }

    public void updateEmployee() {
        System.out.println("Enter Employee ID");
        int employeeID= input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Name");
        String employeeName = input.nextLine();
        System.out.println("Enter Employee Email");
        String employeeEmail = input.nextLine();
        System.out.println("Enter Employee Phone");
        String employeePhone = input.nextLine();
        System.out.println("Enter Salary");
        Double salary = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Department ID");
        int departmentid = input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Designation");
        String designation = input.nextLine();
        System.out.println("Enter Employee status");
        String status = input.nextLine();
        Employee employee = new Employee(employeeID,employeeName,employeeEmail,employeePhone,salary,designation,status,departmentid);
        if(employeeDAO.updateEmployee(employee)){
            System.out.println("Employee updated successfully");
        }else {
            System.out.println("Employee not updated successfully");
        }
    }

    public void deleteEmployee() {
        System.out.println("Enter Employee ID");
        int employeeID= input.nextInt();
        input.nextLine();
        if(employeeDAO.deleteEmployee(employeeID)){
            System.out.println("Employee deleted successfully");
        }else  {
            System.out.println("Employee not deleted successfully");
        }
    }

    public void searchEmployee() {
        System.out.println("Enter Employee ID");
        int employeeID= input.nextInt();
        Employee employee = employeeDAO.getEmployee(employeeID);
        if(employee!=null){
            System.out.println("Employee found successfully");
            System.out.println(employee);
        }else  {
            System.out.println("Employee not found");
        }
    }

    public void displayEmployee() {
        List<Employee> employees =  employeeDAO.getAllEmployee();
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }




}
