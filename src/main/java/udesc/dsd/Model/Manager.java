package udesc.dsd.Model;

import static udesc.dsd.Commons.Constants.TYPE_MANAGER;

public class Manager extends Person{

    private final String accessKey;

    public Manager(String cpf, String name, String address, Department department, String accessKey) {
        super(cpf, name, address, department);
        this.accessKey = accessKey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    @Override
    public String toString(){
        return super.toString()
                + ";" + accessKey + ";" + TYPE_MANAGER + ";" + getDepartment().getNumberID();
    }
}
