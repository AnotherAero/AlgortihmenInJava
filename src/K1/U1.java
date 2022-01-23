package K1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class U1 {
    public static void main(String[] args) {
        fib5 f = new fib5();
        f.stream().limit(41).forEachOrdered(System.out::println);
    }

    //Stack Overflow
    private static int fib1(int n){
        return fib1( n -1 ) + (n - 2);
    }
    //Inefficient
    private static int fib2(int n){
        if (n < 2) return n;
        return fib2(n - 1) + fib2( n - 2);
    }
    //Hashmap
    static Map<Integer, Integer> memo = new HashMap<>(Map.of(0,0,1,1));
    private static int fib3(int n){
        if (!memo.containsKey(n)) {
            memo.put(n, fib3(n-1) + fib3(n-2));
        }
        return memo.get(n);
    }
    //Iterativ
    private static int fib4(int n){
        int last = 0, next = 1; //fib(0), fib(1)
        for (int i = 0; i < n; i++){
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
