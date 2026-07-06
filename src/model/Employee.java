package model;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String email;
    private String phone;
    private double salary;
    private String designation;
    private String status;
    private int departmentId;

    //default constructor
    public Employee(){

    }

    public Employee(int employeeid,
                    String employeename,
                    String email,
                    String phone,
                    double salary,
                    String designation,
                    String status,
                    int departmentid) {
        this.employeeId = employeeid;
        this.employeeName = employeename;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.designation = designation;
        this.status = status;
        this.departmentId = departmentid;
    }

    //getter
    public int getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public double getSalary() {
        return salary;
    }
    public String getDesignation() {
        return designation;
    }
    public String getStatus() {
        return status;
    }
    public int getDepartmentId() {
        return departmentId;
    }

    // setter
    public void setEmployeeId(int employeeid) {
        this.employeeId = employeeid;
    }
    public void setEmployeeName(String employeename) {
        this.employeeName = employeename;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {

        return String.format(
                "%-10d %-10s %-25s %-25s %-10.2f %-15s %-10s %-10d",
                employeeId,
                employeeName,
                email,
                phone,
                salary,
                designation,
                status,
                departmentId
        );
    }
}
