package udesc.dsd;

import udesc.dsd.Model.Department;
import udesc.dsd.Model.Employee;
import udesc.dsd.Model.Manager;
import udesc.dsd.Socket.Server;
import udesc.dsd.Utils.AccessKeyGenerator;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {

        Server server = new Server(new ServerSocket(65000));

            server.serve();
//        var departments = new ArrayList<>(
//                Arrays.asList(
//                        CreateDepartmentTest(),
//                        CreateDepartmentTest(),
//                        CreateDepartmentTest(),
//                        CreateDepartmentTest(),
//                        CreateDepartmentTest()
//                ));
//
//        departments.forEach(System.out::println);
    }

    public static Department CreateDepartmentTest(){

        Department department = new Department("Test");
        String cpf1 = "1234567890";
        String cpf2 = "1234567891";
        String cpf3 = "1234567892";
        String cpf4 = "1234567893";
        String cpf5 = "1234567894";
        String cpf6 = "1234567895";
        String name = "testName";
        String address = "testAddress";
        String workShift = "morning";

        Employee employeeTest1 = new Employee(cpf1, name, address, department, workShift);
        Employee employeeTest2 = new Employee(cpf2, name, address, department, workShift);
        Employee employeeTest3 = new Employee(cpf3, name, address, department, workShift);
        Employee employeeTest4 = new Employee(cpf4, name, address, department, workShift);
        Employee employeeTest5 = new Employee(cpf5, name, address, department, workShift);

        department.addEmployee(employeeTest1.getCpf(), employeeTest1);
        department.addEmployee(employeeTest2.getCpf(), employeeTest2);
        department.addEmployee(employeeTest3.getCpf(), employeeTest3);
        department.addEmployee(employeeTest4.getCpf(), employeeTest4);
        department.addEmployee(employeeTest5.getCpf(), employeeTest5);

        String uniqueAccessKey = new AccessKeyGenerator().generateAccessCode()[1];
        Manager manager = new Manager(cpf6, name, address, department, uniqueAccessKey);
        department.setManager(manager);

        return department;
    }
}