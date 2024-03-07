package Model;

import org.junit.Test;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void mustCreateEmployee(){

        String cpf = "123456789";
        String name = "Ana";
        String address = "Rua x";
        String workShift = "morning";
        String departmentName = "security";

        Department department = new Department(departmentName);
        Employee employee = new Employee( cpf, name, address, department, workShift );

        assertNotNull("Employee cannot be null", employee);
        assertNotNull("Employee's department cannot be null", employee.getDepartment());
        assertEquals("Employee's cpf must be the same as the one entered in the input", cpf, employee.getCpf());
        assertEquals("Employee's name must be the same as the one entered in the input", name, employee.getName());
        assertEquals("Employee's address must be the same as the one entered in the input", address, employee.getAddress());
        assertEquals("Employee's turn must be the same as the one entered in the input", workShift, employee.getWorkShift());
        assertEquals("Employee's department must be the same as the one entered in the input", department, employee.getDepartment());
    }

    @Test
    public void mustUpdateEmployeeData(){
        String oldCpf = "123456789";
        String oldName = "Ana";
        String oldAddress = "Rua x";
        String oldWorkShift = "morning";
        String oldDepartmentName = "security";
        Department oldDepartment = new Department(oldDepartmentName);

        //the cpf is not changeable
        String newName = "Ana Fábia";
        String newAddress = "Rua y";
        String newWorkShift = "afternoon";
        String newDepartmentName = "Software Engineering";
        Department newDepartment = new Department(newDepartmentName);

        Employee employee = new Employee( oldCpf, oldName, oldAddress, oldDepartment, oldWorkShift );

        employee.setName(newName);
        employee.setAddress(newAddress);
        employee.setWorkShift(newWorkShift);
        employee.setDepartment(newDepartment);

        assertNotEquals("Employee's name must be different from the previous", oldName, employee.getName());
        assertNotEquals("Employee's address must be different from the previous", oldAddress, employee.getAddress());
        assertNotEquals("Employee's turn must be different from the previous", oldWorkShift, employee.getWorkShift());
        assertNotEquals("Employee's department must be different from the previous", oldDepartment, employee.getDepartment());

        assertEquals("Employee's new name must be the same as the one entered in the input", newName, employee.getName());
        assertEquals("Employee's new address must be the same as the one entered in the input", newAddress, employee.getAddress());
        assertEquals("Employee's new turn must be the same as the one entered in the input", newWorkShift, employee.getWorkShift());
        assertEquals("Employee's department must be different from the previous", newDepartment, employee.getDepartment());
    }

}
