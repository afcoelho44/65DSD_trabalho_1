package udesc.dsd.Model;

import udesc.dsd.Utils.Hasher256;

import java.util.Random;

public class Manager extends Person{

    private String accessKey;

    public Manager(String cpf, String name, String address, Department department) {
        super(cpf, name, address, department);
        accessKey = generateCode();
    }

    public String getAccessKey() {
        return accessKey;
    }

    private String generateCode(){
        Random random = new Random();
        Hasher256 hasher = new Hasher256();
        StringBuilder builder = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
        int length = alphabet.length() - 1;

        String code = "";
        do {
            for (int i = 0; i < 10; i++){
                builder.append(alphabet.charAt(random.nextInt(length)));
            }

            code = hasher.toHash256(builder.toString());
        } while (IsCodeRepeated(code));

        return builder.toString();
    }

    private boolean IsCodeRepeated(String code){

        return false;
    }
}
