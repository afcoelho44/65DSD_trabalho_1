package Model;

import org.junit.Test;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
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
    public void mustUpdateDepartmentData(){
        AccessKeyGenerator generator = new AccessKeyGenerator();

        String oldDepartmentName = "HR";
        String oldManagerCpf = "123456789";
        String oldManagerName = "Ana";
        String oldManagerAddress = "Rua x";

        String newDepartmentName = "Human Resources";
        String newManagerCpf = "987654321";
        String newManagerName = "Nicolas";
        String newManagerAddress = "Rua y";

        String oldManagerUniqueAccessKey = generator.generateAccessCode()[1];
        String newManagerUniqueAccessKey = generator.generateAccessCode()[1];

        Department department = new Department(oldDepartmentName);

        Manager oldManager = new Manager(oldManagerCpf, oldManagerName, oldManagerAddress, department, oldManagerUniqueAccessKey);
        Manager newManager = new Manager(newManagerCpf, newManagerName, newManagerAddress, department, newManagerUniqueAccessKey);

        department.setManager(oldManager);
        department.setName(newDepartmentName);
        department.setManager(newManager);

        assertEquals("Department's name must be the same as the one entered in the input", newDepartmentName, department.getName());
        assertEquals("Department's manager must be the same as the one entered in the input", newManager, department.getManager());
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

    @Test
    public void mustRemoveEmployee(){
        String cpf = "1234567890";
        String name = "testName";
        String address = "testAddress";
        String workShift = "morning";

        Department department = new Department("Test");

        Employee employeeTest1 = new Employee(cpf, name, address, department, workShift);
        Employee employeeTest2 = new Employee(cpf, name, address, department, workShift);
        Employee employeeTest3 = new Employee(cpf, name, address, department, workShift);
        Employee employeeTest4 = new Employee(cpf, name, address, department, workShift);
        Employee employeeTest5 = new Employee(cpf, name, address, department, workShift);

        department.addEmployee(employeeTest1.getCpf(), employeeTest1);
        department.addEmployee(employeeTest1.getCpf(), employeeTest2);
        department.addEmployee(employeeTest1.getCpf(), employeeTest3);
        department.addEmployee(employeeTest1.getCpf(), employeeTest4);
        department.addEmployee(employeeTest1.getCpf(), employeeTest5);

        department.removeEmployee(employeeTest1.getCpf());
        department.removeEmployee(employeeTest2.getCpf());
        department.removeEmployee(employeeTest3.getCpf());
        department.removeEmployee(employeeTest4.getCpf());
        department.removeEmployee(employeeTest5.getCpf());

        assertTrue(department.getEmployees().isEmpty());
    }
}
