package K1;

import java.util.BitSet;
public class U2 {
    public static void main(String[] args) {
        String s = "ACGT";
        CompressedGene g = new CompressedGene(s);
        System.out.println(g.decompress());
    }
}
class CompressedGene{
    private BitSet bitSet;
    private int length;
    //Konstruktor
    public CompressedGene(String gene){
        compress(gene);
    }
    //Methoden
    private void compress(String gene){
        length = gene.length();
        bitSet = new BitSet(length * 2);
        final String upperGene = gene.toUpperCase();

        for (int i = 0; i < length; i++){
            final int firstLocation = 2 * i;
            final int secondLocation = 2 * i + 1;
            switch (upperGene.charAt(i)){
                case 'A'://00
                    bitSet.set(firstLocation,false);
                    bitSet.set(secondLocation,false);
                    break;
                case 'C'://01
                    bitSet.set(firstLocation,false);
                    bitSet.set(secondLocation,true);
                    break;
                case 'G'://10
                    bitSet.set(firstLocation,true);
                    bitSet.set(secondLocation,false);
                    break;
                case 'T'://11
                    bitSet.set(firstLocation,true);
                    bitSet.set(secondLocation,true);
                    break;
            }
        }
    }

    public String decompress(){
        if (bitSet == null){
            return null;
        }
        StringBuilder s = new StringBuilder(length * 2);
        for (int i = 0; i < (length * 2); i = i + 2){
            final int firstBit;
            if (bitSet.get(i)) firstBit = 1;
            else firstBit = 0;
            final int secondBit = (bitSet.get(i + 1) ? 1 : 0);
            final int lastBit = firstBit << 1 | secondBit;
            // fb = 0, sb = 1 --> 01
            //fb << 1 -> 01
            // fb 01 OR (|) sb 1 (01) -> 01
            switch (lastBit){
                case 0b00:
                    s.append('A');
                    break;
                case 0b01:
                    s.append('C');
                    break;
                case 0b10:
                    s.append('G');
                    break;
                case 0b11:
                    s.append('T');
                    break;
            }
        }
        return s.toString();
    }
}