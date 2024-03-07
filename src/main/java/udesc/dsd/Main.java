package udesc.dsd;

import udesc.dsd.Utils.Hasher256;

public class Main {
    public static void main(String[] args) {
        String hashDaNet = "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad";
        String testeDoHash = new Hasher256().toHash256("abc");

        boolean ehIgual = hashDaNet.equals(testeDoHash);
        System.out.println(hashDaNet);
        System.out.println(testeDoHash);
        System.out.println(ehIgual);


    }
}