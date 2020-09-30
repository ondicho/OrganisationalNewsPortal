package models;

import java.util.Objects;

public class Department {
    private int id;
    private String departmentName;
    private String departmentDescription;

    public Department(String departmentName,String departmentDescription){
        this.departmentName=departmentName;
        this.departmentDescription=departmentDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(departmentDescription, that.departmentDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, departmentDescription);
    }
}
