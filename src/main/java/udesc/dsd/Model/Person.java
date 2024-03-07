package udesc.dsd.Model;

public abstract class Person {

    protected String cpf;
    protected String name;
    protected String address;
    protected  Department department;

    public Person(String cpf, String name, String address, Department department) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
        this.department = department;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
