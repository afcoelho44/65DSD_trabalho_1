package udesc.dsd.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department {

    private String name;
    private final Long numberID;
    private Manager manager; //nullable
    private final Map<String, Person> employees = new HashMap<>();

    private static Long numberIdGenerator = 0L;

    public Department(String name){
        this.name = name;
        this.numberID = ++numberIdGenerator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberID() {
        return numberID;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Person> getEmployees() {
        return new ArrayList<>(employees.values());
    }

    public void addEmployee(String cpf, Person person){
        this.employees.put(cpf, person);
    }

    public void removeEmployee(String cpf){
        this.employees.remove(cpf);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name: " + name + ", \n" +
                "numberID: " + numberID + ", \n" +
                "manager: " + manager + ", \n" +
                "employee: " + employees + ", \n" +
                '}';
    }
}
