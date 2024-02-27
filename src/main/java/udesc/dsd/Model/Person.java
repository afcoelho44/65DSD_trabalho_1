package udesc.dsd.Model;

public abstract class Person {

    private String cpf;
    private String name;
    private String address;

    public Person(String cpf, String name, String address) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
    }
}
