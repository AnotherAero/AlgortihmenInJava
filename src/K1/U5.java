package K1;

import java.util.Stack;

public class U5 {
    public static void main(String[] args) {
        Hanoi h = new Hanoi(5);
        h.solve();
        System.out.println(h);
    }
}
//https://de.khanacademy.org/computing/computer-science/algorithms/towers-of-hanoi/a/towers-of-hanoi-continued
class Hanoi{
    private final int numDiscs;
    public final Stack<Integer> towerA = new Stack<>();
    public final Stack<Integer> towerB = new Stack<>();
    public final Stack<Integer> towerC = new Stack<>();

    public Hanoi(int discs){
        numDiscs = discs;
        for (int i = 1; i <= discs; i++){
            towerA.push(i);
        }
    }
    public void solve(){
        move(towerA,towerC,towerB,numDiscs);
    }
    private void move(Stack<Integer> A, Stack<Integer> C, Stack<Integer> B,int n){
        if (n == 1){
            C.push(A.pop());
        }else {
            move(A,B,C,n-1);
            move(A,C,B,1);
            move(B,C,A,n-1);
        }
    }
    public String toString(){
        return towerC.toString();
    }
}
