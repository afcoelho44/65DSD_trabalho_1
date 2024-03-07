package Utils;

import org.junit.Assert;
import org.junit.Test;
import udesc.dsd.Utils.AccessKeyGenerator;
import udesc.dsd.Utils.Hasher256;

import static org.junit.Assert.assertEquals;

public class AccessKeyGeneratorTest {

    @Test
    public void encryptedKeyMustBeTheHashOfOriginalCode(){
        AccessKeyGenerator generator = new AccessKeyGenerator();

        String[] keys = generator.generateAccessCode();
        String decryptedKey = keys[0];
        String encryptedKey = keys[1];

        String encryptedTest = new Hasher256().toHash256(decryptedKey);

        assertEquals("Encrypted Key Must Be The Hash Of Original Key", encryptedKey, encryptedTest);
    }
}
