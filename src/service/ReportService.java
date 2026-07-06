package service;
import model.Employee;
import dao.ReportDAO;

import java.util.List;
import java.util.Scanner;

public class ReportService {
    ReportDAO reportDAO = new ReportDAO();
    Employee employee = new Employee();
    Scanner input = new Scanner(System.in);
    public void totalEmployees() {
        System.out.println("Total Employees: " + reportDAO.totalEmployeesCount());
    }
    public void highestSalary() {
        System.out.println(reportDAO.highestSalaryEmployee());
    }
    public void lowestSalary() {
        System.out.println(reportDAO.lowestSalaryEmployee());
    }
    public void averageSalary() {
        System.out.println("The Average Salary : " + reportDAO.averageSalaryEmployee());
    }
    public void employeesByDepartment() {
        System.out.println("Enter The department ID");
        int department_id = input.nextInt();
        input.nextLine();
        List<Employee> employees = reportDAO.employeesByDepartment(department_id);
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
}
