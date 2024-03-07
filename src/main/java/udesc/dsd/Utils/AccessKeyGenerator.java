package udesc.dsd.Utils;

import udesc.dsd.Dao.ManagerAccessKeyDao;
import udesc.dsd.Dao.ManagerAccessKeyRepository;

import java.util.Random;

public class AccessKeyGenerator {

    private final ManagerAccessKeyRepository repository = new ManagerAccessKeyDao();

    public String GenerateAccessCode(){
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

        repository.add(code);
        return builder.toString();
    }

    private boolean IsCodeRepeated(String code){
        return repository.getAll().contains(code);
    }
}
