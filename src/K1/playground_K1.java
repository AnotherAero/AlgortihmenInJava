package K1;

import java.util.*;

public class playground_K1 {
    public static void main(String[] args) {
        //TODO HASHMAP
        //https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
        HashMap m = new HashMap();
        //HashMap<Integer, String> m = new HashMap(); Key muss Int sein, Value muss String sein
        m.put(1,"Eins");
        m.put(true,"trueS");
        m.put(0,"null");
        m.put(false,"falseS");
        //m.put(true,"newTrueS");
        System.out.println(m.keySet());
        System.out.println(m.values());
        System.out.println("----------------------");
        //TODO BITSET
        //https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html
        BitSetExtended bit = new BitSetExtended(3);
        bit.set(0,false);
        bit.set(1,true);
        bit.set(4,true);
        System.out.println(bit.getLength());
        System.out.println(bit);
        System.out.println("----------------------");
        //TODO BYTE[]
        String s = "Test";
        byte[] by = s.getBytes(); //Alle Buchstaben werden als UTF 16 Dezimal Zahl gespeichert
        //https://asecuritysite.com/coding/asc2
        System.out.println(Arrays.toString(by));
        String sNew = new String(by);//Die UTF 16 Dezimal Zahl wird wieder zu einem String konvertiert
        System.out.println(sNew);
        System.out.println("----------------------");
        //EnCrypt = Raw ^ Fake
        //Raw = EnCrypt ^ Fake
        String rawString = "RawD";
        byte[] rawStringBytes = rawString.getBytes();
        System.out.println("Raw: " + Arrays.toString(rawStringBytes));
        String fakeString = "Fake";
        byte[] fakeStringBytes = fakeString.getBytes();
        System.out.println("Fake: " + Arrays.toString(fakeStringBytes));
        //EnCrypt = Raw ^ Fake
        byte[] encryBytes = new byte[rawString.length()];
        for (int x = 0;x < rawString.length();x++){
            encryBytes[x] = (byte) (rawStringBytes[x] ^ fakeStringBytes[x]);
        }
        System.out.println("Encry: " + Arrays.toString(encryBytes));
        //Raw = EnCrypt ^ Fake
        byte[] decryBytes = new byte[rawString.length()];
        for (int x = 0;x < rawString.length();x++){
            decryBytes[x] = (byte) (encryBytes[x] ^ fakeStringBytes[x]);
        }
        System.out.println("Decrypt: " + Arrays.toString(decryBytes));
        System.out.println("----------------------");
        //TODO STACK
        Stack<Integer> a = new Stack<>();
        a.push(1);
        a.push(5);
        a.push(3);
        System.out.println(a.pop());
        System.out.println(a);
    }
}
