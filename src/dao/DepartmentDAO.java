package dao;
import database.DBConnection;
import model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO {
    public void addDepartment(Department department) {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO department VALUES(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.setString(3, department.getLocation());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Department added successfully");
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepartment(Department department) {
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("Database connection failed");
            return;
        }
        String query = "UPDATE department SET department_name = ?, location = ?  WHERE department_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,department.getDepartmentName());
            ps.setString(2,department.getLocation());
            ps.setInt(3,department.getDepartmentId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Department Updated successfully");
            }else{
                System.out.println("Department Not found.");
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartment(int departmentId) {
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("Database connection failed");
            return;
        }
        String query = "DELETE FROM department WHERE department_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, departmentId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Department Deleted Successfully");
            }else{
                System.out.println("Department Not found.");
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchDepartment(int departmentId) {
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("Database connection failed");
            return;
        }
        String query = "SELECT * FROM department WHERE department_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,departmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("Department Found");
                System.out.println("-------------------------");

                System.out.println("Department ID   : "
                        + rs.getInt("department_id"));

                System.out.println("Department Name : "
                        + rs.getString("department_name"));

                System.out.println("Location        : "
                        + rs.getString("location"));
            }else{
                System.out.println("Department Not Found");
            }
            rs.close();
            ps.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayAllDepartments() {
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("Database connection failed");
            return;
        }
        String query = "SELECT * FROM department";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("---------------------------------------------------");
            System.out.printf("%-15s %-20s %-15s%n",
                    "Department ID", "Department Name", "Location");
            System.out.println("---------------------------------------------------");
            while (rs.next()){
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                String location = rs.getString("location");
                System.out.printf("%-15s %-20s %-15s%n",
                        departmentId, departmentName, location);
            }
            rs.close();
            ps.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isDepartmentExist(int departmentId) {
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("Database connection failed");
            return false;
        }
        String query = "SELECT * FROM department WHERE department_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
