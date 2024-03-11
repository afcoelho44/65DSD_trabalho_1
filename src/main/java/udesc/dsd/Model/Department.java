package udesc.dsd.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Department {

    private String name;
    private final long numberID;
    private Manager manager; //nullable
    public final Map<String, Person> employees = new HashMap<>();

    private static long numberIdGenerator = 0L;

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

    public long getNumberID() {
        return numberID;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        if (this.manager != null){
            removeEmployee(this.manager.getCpf());
        }

        this.manager = manager;
    }

    public List<Person> getEmployees() {
        return new ArrayList<>(employees.values());
    }

    public void addEmployee(String cpf, Person person){
        if (person instanceof Manager){
            setManager(manager);
        }
        else this.employees.put(cpf, person);
    }

    public void removeEmployee(String cpf){
        this.employees.remove(cpf);
    }

    @Override
    public String toString() {
        return "Department:\n{\n" +
                "\tname: " + name + ", \n" +
                "\tnumberID: " + numberID + ", \n" +
                "\tmanager: " + manager + ", \n" +
                "\temployees: " + getEmployees() + ", \n" +
                '}';
    }

    public String toResponseString(){
        return getNumberID() + "; " + getName();
    }
}
