package dao;
import database.*;
import java.sql.*;
import java.util.ArrayList;
import model.Employee;
import java.util.*;

public class EmployeeDAO {

    public boolean addEmployee(Employee employee){
        String query = "Insert into employee values(?,?,?,?,?,?,?,?)";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,employee.getEmployeeId());
            ps.setString(2,employee.getEmployeeName());
            ps.setString(3,employee.getEmail());
            ps.setString(4,employee.getPhone());
            ps.setDouble(5,employee.getSalary());
            ps.setString(6,employee.getDesignation());
            ps.setString(7,employee.getStatus());
            ps.setInt(8,employee.getDepartmentId());
            int row = ps.executeUpdate();
            if(row > 0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateEmployee(Employee employee){
        if(!employeeExists(employee.getEmployeeId())){
            System.out.println("Employee doesn't exist");
            return false;
        }
        String query = "UPDATE employee SET employee_name = ?, email = ?,phone = ?,salary = ?,designation = ?,status = ?,department_id = ? WHERE employee_id = ?;";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,employee.getEmployeeName());
            ps.setString(2,employee.getEmail());
            ps.setString(3,employee.getPhone());
            ps.setDouble(4,employee.getSalary());
            ps.setString(5,employee.getDesignation());
            ps.setString(6,employee.getStatus());
            ps.setInt(7,employee.getDepartmentId());
            ps.setInt(8,employee.getEmployeeId());
            int row = ps.executeUpdate();
            if(row > 0){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployee(int employeeID){
        if(!employeeExists(employeeID)){
            System.out.println("Employee doesn't exist");
            return false;
        }
        String query = "DELETE FROM employee WHERE employee_id = ?;";
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,employeeID);
            int row = ps.executeUpdate();
            if(row > 0){
                return true;
            }else {
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Employee getEmployee(int employeeID){
        String query = "SELECT * FROM employee WHERE employee_id = ?;";
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,employeeID);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Employee employee = new Employee( rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                    return employee;
                }
            }
            return  null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Employee> getAllEmployee(){
        ArrayList<Employee> employees = new ArrayList<>();
        String query = "Select * from employee";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    int employeeId = rs.getInt("employee_id");
                    String employeeName = rs.getString("employee_name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    double salary = rs.getDouble("salary");
                    String designation = rs.getString("designation");
                    String status = rs.getString("status");
                    int departmentId = rs.getInt("department_id");
                    Employee employee = new Employee(
                            employeeId,
                            employeeName,
                            email,
                            phone,
                            salary,
                            designation,
                            status,
                            departmentId
                    );

                    employees.add(employee);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  employees;
    }

// Checker
    public boolean employeeExists(int employeeId){
        String query = "select 1 from employee where employee_id = ?";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,employeeId);
            try (ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean emailValid(String email){
        if(email.contains("@")){
            return true;
        }else {
            return false;
        }
    }

    public boolean phoneValid(String phone){
        return phone.matches("\\d{10}");
    }

    public boolean emailExists(String email){
        String query = "select 1 from employee where email = ?";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,email);
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean phoneExists(String phone){
        if(phone.length() !=  10) {
            return true;
        }
        String query = "select 1 from employee where phone = ?";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,phone);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
