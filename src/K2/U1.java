package K2;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class U1 {
    public static void main(String[] args) {

    }
}
class Gene{
    //https://www.w3schools.com/java/java_enums.asp
    //Nucleotide kann nur die Werte A,C,G oder T annehmen
    public enum Nucleotide{
        A, C, G, T
    }

    //https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
    //https://www.geeksforgeeks.org/comparator-interface-java/
    public static class Codon implements Comparable<Codon>{
        public final Nucleotide first, second, third;
        private final Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.second).thenComparing((Codon c) -> c.third);

        public Codon(String codonStr){
            first = Nucleotide.valueOf(codonStr.substring(0,1));
            second = Nucleotide.valueOf(codonStr.substring(1,2));
            third = Nucleotide.valueOf(codonStr.substring(2,3));
        }
        @Override
        public int compareTo(Codon other){
            return comparator.compare(this,other);
        }
    }
    //https://www.w3schools.com/java/java_arraylist.asp
    private ArrayList<Codon> codons = new ArrayList<>();
    public Gene(String geneStr){
        for (int i = 0; i < geneStr.length() - 3; i += 3){
            codons.add(new Codon(geneStr.substring(i , i + 3 )));
        }
    }
}



