package K1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class U1 {
    //static int fib1C = 0;
    static int fib2C = 0; //Wie viele Schritte
    static int fib3C = 0;
    static int fib4C = 0;
    public static void main(String[] args) {
        System.out.println(fib2(10));
        System.out.println("Schritte:" + fib2C);
        System.out.println();
        System.out.println(fib3(10));
        System.out.println("Schritte:" + fib3C);
        System.out.println();
        System.out.println(fib4(10));
        System.out.println("Schritte:" + fib4C);
        /*
        fib5 f = new fib5();
        f.stream().limit(41).forEachOrdered(System.out::println);
        */
    }

    //Stack Overflow
    private static int fib1(int n){
        return fib1( n -1 ) + (n - 2);
    }
    //Inefficient
    private static int fib2(int n){
        fib2C++;
        if (n < 2) return n;
        return fib2(n - 1) + fib2( n - 2);
    }
    //Hashmap
    static Map<Integer, Integer> memo = new HashMap<>(Map.of(0,0,1,1));
    private static int fib3(int n){
        fib3C++;
        if (!memo.containsKey(n)) {
            memo.put(n, fib3(n-1) + fib3(n-2));
        }
        return memo.get(n);
    }
    //Iterativ
    private static int fib4(int n){
        int last = 0, next = 1; //fib(0), fib(1)
        for (int i = 0; i < n; i++){
            fib4C++;
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }
}
//Stream
//https://youtu.be/FWoYpM-E3EQ
class fib5{
    private int last = 0, next = 1;
    public IntStream stream(){
        return IntStream.generate(() ->
        {
            int oldLast = last;
            last = next;
            next = oldLast + next;
            return oldLast;
        }
        );
    }
}
