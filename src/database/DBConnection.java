package database;
import java.sql.*;
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "102003@Jana";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            System.out.println("Connected to database successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
