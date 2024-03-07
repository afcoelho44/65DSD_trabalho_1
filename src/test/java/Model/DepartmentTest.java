package Model;

import org.junit.Test;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Manager;
import udesc.dsd.Utils.AccessKeyGenerator;

import static org.junit.Assert.*;

public class DepartmentTest {
    @Test
    public void mustCreateDepartment(){

        String departmentName = "Security";

        Department department = new Department(departmentName);

        assertNotNull("Department cannot be null", department);
        assertNull("Department manager must be null when creating a department", department.getManager());

        assertNotEquals("Department sequential Id must be not equals 0", 0, department.getNumberID());
        assertEquals("Department's name must be the same as the one entered in the input", departmentName, department.getName());

        assertTrue("Department sequential Id must be greater than 0", department.getNumberID() > 0);
        assertTrue("Number of employees in the department must be 0 when created", department.getEmployees().isEmpty());
    }

    @Test
    public void mustHaveASequentialId(){
        Department department = new Department("Department 0");

        int initialIdOfLoop = (int)department.getNumberID();
        int numberOfDepartmentsCreated = initialIdOfLoop + 100;

        //Assert
        for (int i = initialIdOfLoop; i <= numberOfDepartmentsCreated; i++ ){
            assertEquals(department.getName() + " Id must be sequential!", i, (int)department.getNumberID());
            department = new Department("Department " + (i + 1));
        }
    }

    @Test
    public void mustIncludeTheManagerInTheListOfEmployeesWhenFacingTheHeadOfTheDepartment(){
        String cpf = "123456789";
        String name = "Ana";
        String address = "Rua x";
        String departmentName = "security";
        String uniqueAccessKey = new AccessKeyGenerator().generateAccessCode()[1];
        Department department = new Department(departmentName);
        Manager manager = new Manager(cpf, name, address, department, uniqueAccessKey);

        department.setManager(manager);

        assertNotNull("Manager cannot be null", department.getManager());
        assertFalse("Department employees cannot be empty", department.getEmployees().isEmpty());
    }
}
