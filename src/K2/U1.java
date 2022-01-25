package K2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class U1 {
    public static void main(String[] args) {
        Gene g = new Gene("AGTCGTACT");
        System.out.println(g.getArrayList());
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
    //Für Suche und Sortierungen (Mit der Standardbibliothek) müssen die Objekte miteinander vergleichbar sein.
    //Bei primitiven Datentypen ist das bereits vorhanden. Bei eigenen Klassen aber nicht.
    //Hier muss deshalb Comparable und dessen Methode compareTo() implementiert werden.
    public static class Codon implements Comparable<Codon>{
        public final Nucleotide first, second, third;
        //https://www.happycoders.eu/de/java/comparator-comparable-compareto/
        //Zuerst wird das erste Nuc verglichen. Wenn das stimmt wird das zweite verglichen. Und wenn das stimmt dann das dritte
        private final Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.first).thenComparing((Codon c) -> c.second).thenComparing((Codon c) -> c.third);

        //Konstruiert ein Codon aus einem 3 stelligen String
        public Codon(String codonStr){
            first = Nucleotide.valueOf(codonStr.substring(0,1));
            second = Nucleotide.valueOf(codonStr.substring(1,2));
            third = Nucleotide.valueOf(codonStr.substring(2,3));
        }
        //OWN
        @Override
        public String toString(){
            return first.toString() + second.toString() + third.toString();
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
    //OWN
    public String getArrayList(){
        String s = "";
        for (int i = 0; i < codons.size(); i++){
            s = s + codons.get(i).toString() + " ";
        }
        return s;
    }
}



