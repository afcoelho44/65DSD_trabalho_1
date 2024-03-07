package udesc.dsd.Model;

import udesc.dsd.Utils.AccessKeyGenerator;

public class Manager extends Person{

    private final String accessKey;

    public Manager(String cpf, String name, String address, Department department) {
        super(cpf, name, address, department);
        accessKey = new AccessKeyGenerator().GenerateAccessCode();
    }

    public String getAccessKey() {
        return accessKey;
    }


}
