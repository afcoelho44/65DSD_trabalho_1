package Utils;

import org.junit.Test;
import udesc.dsd.Utils.Hasher256;

import static org.junit.Assert.assertEquals;

public class Hasher256Test {
    @Test
    public void mustEncryptInputUsingHash256(){

        //All hashes were generated in the following online tool: https://emn178.github.io/online-tools/sha256.html
        String originalWord_1 = "abc";
        String originalHash256_1  = "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad"; //hash 256 of "abc".

        String originalWord_2 = "A dog inside the poll.";
        String originalHash256_2  = "1efe43585b213d2343f56372ed1eacd30ed2bb3a044a88aea8eab61d52358cd9"; //hash 256 of "A dog inside the poll.".

        String originalWord_3 = "Ban@na9342923";
        String originalHash256_3  = "84fbc439b3ce385026ddeed945bf620a24ec3220212af0cdd1fa70ee8d41ba04"; //hash 256 of "Ban@na9342923".

        String originalWord_4 = "20061932";
        String originalHash256_4  = "2db467cecfab242aceb903d016bdf34be34b200d1e4c0091920c12a3f3ba3e06"; //hash 256 of "20061932".

        String originalWord_5 = "3fc4d029e80ff78fb7d1e26579c1e47d865c800f0409a7c6e0b85f96410d32be";
        String originalHash256_5  = "fbbc07143c48c627627f657a253af19f194a64695a8593ebb2542ce63c33c867"; //hash 256 of "3fc4d029e80ff78fb7d1e26579c1e47d865c800f0409a7c6e0b85f96410d32be".

        Hasher256 hasher256 = new Hasher256();

        String generatedHash_1 = hasher256.toHash256(originalWord_1);
        String generatedHash_2 = hasher256.toHash256(originalWord_2);
        String generatedHash_3 = hasher256.toHash256(originalWord_3);
        String generatedHash_4 = hasher256.toHash256(originalWord_4);
        String generatedHash_5 = hasher256.toHash256(originalWord_5);

        assertEquals("generated hash 1 must be equals original hash 1", originalHash256_1, generatedHash_1);
        assertEquals("generated hash 2 must be equals original hash 2", originalHash256_2, generatedHash_2);
        assertEquals("generated hash 3 must be equals original hash 3", originalHash256_3, generatedHash_3);
        assertEquals("generated hash 4 must be equals original hash 4", originalHash256_4, generatedHash_4);
        assertEquals("generated hash 5 must be equals original hash 5", originalHash256_5, generatedHash_5);
    }

}
