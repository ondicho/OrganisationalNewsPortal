package dao;


import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {

    private Sql2oDepartmentDao departmentDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
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