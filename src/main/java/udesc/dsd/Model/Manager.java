package udesc.dsd.Model;

import udesc.dsd.Utils.AccessKeyGenerator;

public class Manager extends Person{

    private final String accessKey;

    public Manager(String cpf, String name, String address, Department department, String accessKey) {
        super(cpf, name, address, department);
        this.accessKey = accessKey;
    }

    public String getAccessKey() {
        return accessKey;
    }


}
