package dao;


import models.Department;
import models.DB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {

    private Sql2oDepartmentDao departmentDao;
    private static Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_news_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "ondicho", "1234");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After //run after every test
    public void tearDown() throws Exception {  //I have changed
        System.out.println("clearing database");
        departmentDao.clearAll(); //clear all restaurants after every test
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("clearing database");
    }

    @Test
    public void addingDepartmentSetsId() throws Exception{
        Department testDepartment=setUpDepartment();
        int originalDepartmentId=testDepartment.getDepartmentId();
        departmentDao.add(testDepartment);
        assertNotEquals(originalDepartmentId,testDepartment.getDepartmentId());
    }

    //helper
    public Department setUpDepartment(){
        return new Department("human resource","recruit company workforce");
    }

}