package K1;
import java.util.BitSet;
//Unterklasse von BitSet welche eine Variable length besitzt um die Länge des Bitsets zu speichern
//Wenn ein Index außerhalb der zuerst gewählten Größe gewählt wird, dann wird die Variable aktualisiert
//in playground_K1.java getestet
public class BitSetExtended extends BitSet {
    private int length = 0;
    BitSetExtended(int length){
        this.length = length;
    }

    @Override
    public void set(int bitIndex, boolean value){
        if (bitIndex >= length){
            length = bitIndex + 1;
        }
        super.set(bitIndex,value);
    }
    public int getLength(){
        return length;
    }
}
