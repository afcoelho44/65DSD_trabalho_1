package Model;

import org.junit.Test;
import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
import udesc.dsd.Model.Manager;
import udesc.dsd.Utils.AccessKeyGenerator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ManagerTest {
    @Test
    public void mustCreateManager(){

        String cpf = "123456789";
        String name = "Ana";
        String address = "Rua x";
        String departmentName = "security";
        String uniqueAccessKey = new AccessKeyGenerator().generateAccessCode()[1];

        Department department = new Department(departmentName);
        Manager manager = new Manager( cpf, name, address, department, uniqueAccessKey);

        assertNotNull("Manager cannot be null", manager);
        assertNotNull("Manager's department cannot be null", manager.getDepartment());
        assertNotNull("Manager's access code cannot be null", manager.getAccessKey());
        assertEquals("Manager's cpf must be the same as the one entered in the input", cpf, manager.getCpf());
        assertEquals("Manager's name must be the same as the one entered in the input", name, manager.getName());
        assertEquals("Manager's address must be the same as the one entered in the input", address, manager.getAddress());
        assertEquals("Manager's department must be the same as the one entered in the input", department, manager.getDepartment());
    }

    @Test
    public void mustUpdateManagerData(){
        String oldCpf = "123456789";
        String oldName = "Ana";
        String oldAddress = "Rua x";
        String oldDepartmentName = "security";
        String uniqueAccessKey = new AccessKeyGenerator().generateAccessCode()[1];
        Department oldDepartment = new Department(oldDepartmentName);

        //the cpf is not changeable
        //the accessKey is not changeable
        String newName = "Ana Fábia";
        String newAddress = "Rua y";
        String newDepartmentName = "Software Engineering";
        Department newDepartment = new Department(newDepartmentName);

        Manager manager = new Manager( oldCpf, oldName, oldAddress, oldDepartment, uniqueAccessKey);

        manager.setName(newName);
        manager.setAddress(newAddress);
        manager.setDepartment(newDepartment);

        assertNotEquals("Manager's name must be different from the previous", oldName, manager.getName());
        assertNotEquals("Manager's address must be different from the previous", oldAddress, manager.getAddress());
        assertNotEquals("Manager's department must be different from the previous", oldDepartment, manager.getDepartment());

        assertEquals("Manager's new name must be the same as the one entered in the input", newName, manager.getName());
        assertEquals("Manager's new address must be the same as the one entered in the input", newAddress, manager.getAddress());
        assertEquals("Manager's department must be different from the previous", newDepartment, manager.getDepartment());
    }
}
