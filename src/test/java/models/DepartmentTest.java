package models;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void getDepartmentName() {
        Department testDepartment= setUpDepartment();
        assertEquals("human resource", testDepartment.getDepartmentName());
    }

    @Test
    public void setDepartmentName() {
        Department testDepartment= setUpDepartment();
        testDepartment.setDepartmentName("finance");
        assertNotEquals("human resource", testDepartment.getDepartmentName());
    }

    @Test
    public void getDepartmentDescription() {
        Department testDepartment= setUpDepartment();
        assertEquals("recruit company workforce", testDepartment.getDepartmentDescription());
    }

    @Test
    public void setDepartmentDescription() {
        Department testDepartment= setUpDepartment();
        testDepartment.setDepartmentDescription("handle company finances");
        assertNotEquals("recruit company workforce", testDepartment.getDepartmentDescription());
    }

    @Test
    public void setDepartmentId() {
        Department testDepartment= setUpDepartment();
        testDepartment.setId(3);
        assertEquals(3, testDepartment.getId());
    }



    //helper
    public Department setUpDepartment(){
        return new Department("human resource","recruit company workforce");
    }
}