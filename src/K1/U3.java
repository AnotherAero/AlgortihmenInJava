package K1;

import java.util.Random;

public class U3 {
    public static void main(String[] args) {
        String s = "ABC";
        KeyPair kp = UnbreakableEncryption.encrypt(s);
        System.out.println(UnbreakableEncryption.decrypt(kp));
    }
}
class KeyPair{
    public final byte[] key1;//Pseudodaten
    public final byte[] key2;//Produkt von Pseudodaten mit Originaldaten
    KeyPair(byte[] key1, byte[] key2){
        this.key1 = key1;
        this.key2 = key2;
    }
}

class UnbreakableEncryption{
    private static byte[] randomKey(int length){
        byte[] dummy = new byte[length];
        Random r = new Random();
        r.nextBytes(dummy);
        return dummy;
    }
    public static KeyPair encrypt(String original){
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = randomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];
        for (int i = 0; i < originalBytes.length; i++){
            //XOR JEDES BYTE 01,10 -> 1, 00,11 -> 0
            encryptedKey[i] =(byte) (originalBytes[i] ^ dummyKey[i]);
        }
        return new KeyPair(dummyKey,encryptedKey);
    }
    public static String decrypt(KeyPair kp){
        byte[] decrypted = new byte[kp.key1.length];
        for(int i = 0; i < kp.key1.length; i++){
            decrypted[i] = (byte) (kp.key1[i] ^ kp.key2[i]);
        }
        return new String(decrypted);
    }
}