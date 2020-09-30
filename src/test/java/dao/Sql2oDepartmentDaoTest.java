package dao;


import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;



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

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingDepartmentSetsId() throws Exception{
        Department testDepartment=setUpDepartment();
        assertEquals(1,testDepartment.getId());
    }

    @Test
    public void getAll() throws Exception{
        Department testDepartment=setUpDepartment();
        assertEquals(1,departmentDao.getAll().size());
    }

    @Test
    public void deleteById() throws Exception {
        Department testDepartment=setUpDepartment();
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment=setUpDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }

    //helper
    public Department setUpDepartment(){
        Department department= new Department("human resource","recruit company workforce");
        departmentDao.add(department);
        return department;
    }

}