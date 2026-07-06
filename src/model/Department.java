package model;

public class Department {
    private int departmentid;
    private String departmentname;
    private String location;

    public Department(){

    }
    public Department(int departmentid,
                      String departmentname,
                      String location) {
        this.departmentid = departmentid;
        this.departmentname = departmentname;
        this.location = location;
    }

    // getter
    public int getDepartmentId() {
        return departmentid;
    }
    public String getDepartmentName() {
        return departmentname;
    }
    public String getLocation() {
        return location;
    }

    //setter
    public void setDepartmentId(int departmentid) {
        this.departmentid = departmentid;
    }
    public void setDepartmentName(String departmentname) {
        this.departmentname = departmentname;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department Detail {" +
                "department ID=" + departmentid+
                ", departmentname=" + departmentname+
                ", location=" + location+
                "}";
    }
}
