package dao;

import database.DBConnection;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    public int totalEmployeesCount(){
        String query = "select count(*) from employee";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return (rs.getInt(1));
                }return 0;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public Employee highestSalaryEmployee(){
        String query = "select * from employee order by salary DESC limit 1";
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Employee employee = new Employee( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                    return employee;
                }
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Employee lowestSalaryEmployee(){
        String query = "select * from employee order by salary ASC limit 1";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Employee employee = new Employee( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                    return employee;
                }
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public double averageSalaryEmployee(){
        String query = "Select avg(salary) from employee";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return (rs.getDouble(1));
                }
            }
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return 0;
    }

    public List<Employee> employeesByDepartment( int departmentId){
        String query = "select * from employee where department_id=?";
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,departmentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int employeeId = rs.getInt(1);
                String employeeName = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                double salary = rs.getDouble(5);
                String designation = rs.getString(6);
                String status = rs.getString(7);
                int deptId = rs.getInt(8);
                Employee employee = new Employee(employeeId,employeeName,email,phone,salary,designation,status,deptId);
                employees.add(employee);
            }
            return employees;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
