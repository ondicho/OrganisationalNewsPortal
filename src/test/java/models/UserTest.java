package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getUserName() {
        User testUser= setUpUser();
        assertEquals("Ondicho", testUser.getUserName());
    }

    @Test
    public void setUserName() {
        User testUser= setUpUser();
        testUser.setUserName("Ondicho");
        assertNotEquals("Otwori", testUser.getUserName());
    }

    @Test
    public void getUserPosition() {
        User testUser= setUpUser();
        assertEquals("Software Developer", testUser.getUserPosition());
    }

    @Test
    public void setUserPosition() {
        User testUser= setUpUser();
        testUser.setUserPosition("IT Technician");
        assertNotEquals("Software Developer", testUser.getUserPosition());
    }

    @Test
    public void getUserRole() {
        User testUser= setUpUser();
        assertEquals("Develop android apps", testUser.getUserRole());
    }

    @Test
    public void setUserRole() {
        User testUser= setUpUser();
        testUser.setUserRole("Manage help desk");
        assertNotEquals("Develop Android apps", testUser.getUserRole());
    }

    @Test
    public void getUserDepartment() {
        User testUser= setUpUser();
        assertEquals("IT", testUser.getUserDepartment());
    }

    @Test
    public void setUserDepartment() {
        User testUser= setUpUser();
        testUser.setUserDepartment("Finance");
        assertNotEquals("IT", testUser.getUserDepartment());
    }

    @Test
    public void setUserId() {
        User testUser= setUpUser();
        testUser.setUserId(3);
        assertNotEquals(5, testUser.getUserId());
    }

    //helper
    public User setUpUser(){
        return new User("Ondicho","Software Developer","Develop android apps","IT");
    }
}