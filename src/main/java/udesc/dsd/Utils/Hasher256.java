package udesc.dsd.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher256 {

    public String toHash256(String input){
        try{
            byte[] hash = getHash(input);
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e){
            System.out.println("Error generating access code hash");
            return null;
        }
    }

    private byte[] getHash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(input.getBytes());
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
