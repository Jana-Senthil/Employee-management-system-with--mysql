import java.util.*;
import service.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeService employeeservice = new EmployeeService();
        DepartmentService departmentservice = new DepartmentService();
        ReportService reportservice = new ReportService();
        do{
            int mainchoice;
            System.out.println("""
                    Enter the Choice 
                    1. Employee Management 
                    2. Department Management
                    3. Reports
                    4. Exit""");
            mainchoice = input.nextInt();
            int subChoice;
            switch (mainchoice) {
                case 1:
                    System.out.println("""
                            EMPLOYEE_MANAGEMENT
                            1. Add Employee
                            2. Update Employee
                            3. Delete Employee
                            4. Search Employee
                            5. Display Employees
                            6. Back
                            """);
                    subChoice = input.nextInt();
                    switch (subChoice) {
                        case 1:
                            employeeservice.addEmployee();
                            break;
                        case 2:
                            employeeservice.updateEmployee();
                            break;
                        case 3:
                            employeeservice.deleteEmployee();
                            break;
                        case 4:
                            employeeservice.searchEmployee();
                            break;
                        case 5:
                            employeeservice.displayEmployee();
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Invalid Choice!");
                    }
                    break;
                case 2:
                    System.out.println("""
                            DEPARTMENT_MANAGEMENT
                            1. Add Department
                            2. Update Department
                            3. Delete Department
                            4. Search Department
                            5. Display Departments
                            6. Back""");
                    subChoice = input.nextInt();
                    switch (subChoice) {
                        case 1:
                            departmentservice.addDepartment();
                            break;
                        case 2:
                            departmentservice.updateDepartment();
                            break;
                        case 3:
                            departmentservice.deleteDepartment();
                            break;
                        case 4:
                            departmentservice.searchDepartment();
                            break;
                        case 5:
                            departmentservice.displayDepartment();
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Invalid Choice!");

                    }
                    break;
                case 3:
                    System.out.println("""
                            REPORTS
                            1. Total Employees
                            2. Highest Salary Employee
                            3. Lowest Salary Employee
                            4  Average salary
                            5  Employees By Department
                            6. Back""");
                    subChoice = input.nextInt();
                    switch (subChoice) {
                        case 1:
                            reportservice.totalEmployees();
                            break;
                        case 2:
                            reportservice.highestSalary();
                            break;
                        case 3:
                            reportservice.lowestSalary();
                            break;
                        case 4:
                            reportservice.averageSalary();
                            break;
                        case 5:
                            reportservice.employeesByDepartment();
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Invalid Choice!");
                    }
                    break;
                case 4:
                    System.out.println("Thank You ...!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }while (true);
    }
}