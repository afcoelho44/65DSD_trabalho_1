package udesc.dsd.Model;

public class Employee extends Person{

    private String periodo;


    public Employee(String cpf, String name, String address, String periodo) {
        super(cpf, name, address);
        this.periodo=periodo;
    }
}
