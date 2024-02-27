package udesc.dsd.Model;

import java.util.List;

public class Department {

    private String name;

    private Long numberID;

    private Manager manager;

    private List<Person> employees;

    public Department(String name, Long numberID){
        this.name=name;
        this.numberID=numberID;
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

    public void setNumberID(Long numberID) {
        this.numberID = numberID;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Person> getEmployees() {
        return employees;
    }
    public void addEmployee(Person person){
        this.employees.add(person);
    }
    public void removeEmployee(Person person){
        this.employees.remove(person);
    }


    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", numberID=" + numberID +
                ", manager=" + manager +
                ", employee=" + employees+
                '}';
    }
}
