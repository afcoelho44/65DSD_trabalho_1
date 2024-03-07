package udesc.dsd.Utils;

import udesc.dsd.Exception.CodeGeneratingTimeoutException;
import udesc.dsd.Dao.ManagerAccessKeyDao;
import udesc.dsd.Dao.ManagerAccessKeyRepository;

import java.util.Random;

public class AccessKeyGenerator {

    private final ManagerAccessKeyRepository repository = new ManagerAccessKeyDao();

    public String[] generateAccessCode(){
        Random random = new Random();
        Hasher256 hasher = new Hasher256();
        StringBuilder builder = new StringBuilder();

        String encryptedCode = generateRandomSequence(builder, random, hasher);
        String originalCode = builder.toString();

        for (int i = 0; i < 10 && isCodeRepeated(encryptedCode); i++){
            encryptedCode = generateRandomSequence(builder, random, hasher);
            originalCode = builder.reverse().toString();

            if (i == 9) throw new CodeGeneratingTimeoutException();
        }

        repository.add(encryptedCode);
        return new String[]{originalCode, encryptedCode};
    }

    private boolean isCodeRepeated(String code){
        return repository.getAll().contains(code);
    }

    private String generateRandomSequence(StringBuilder builder, Random random, Hasher256 hasher){
        String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
        int length = alphabet.length() - 1;
        builder.delete(0, builder.length());

        for (int j = 0; j < 10; j++){
            builder.append(alphabet.charAt(random.nextInt(length)));
        }

        String originalCode = builder.reverse().toString();

        return hasher.toHash256(originalCode);
    }

}
