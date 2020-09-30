package models;

import java.util.Objects;

public class User {
    private int id;
    private String userName;
    private String userPosition;
    private String userRole;
    private String userDepartment;

    public User(String userName,String userPosition,String userRole,String userDepartment){
        this.userName=userName;
        this.userPosition=userPosition;
        this.userRole=userRole;
        this.userDepartment=userDepartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPosition, user.userPosition) &&
                Objects.equals(userRole, user.userRole) &&
                Objects.equals(userDepartment, user.userDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPosition, userRole, userDepartment);
    }
}
