package K1;

import java.util.Stack;

public class U5 {
    public static void main(String[] args) {
        Hanoi h = new Hanoi(4);
        h.solve();
        System.out.println(h);
    }
}
//https://de.khanacademy.org/computing/computer-science/algorithms/towers-of-hanoi/a/towers-of-hanoi-continued
//https://youtu.be/YstLjLCGmgg
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
            move(A,B,C,n-1);//n-1 Scheiben von A nach B mit C als Zwischenschritt
            move(A,C,B,1);//Unterste SCheibe von A nach C
            move(B,C,A,n-1);//n-1 Schiben von B nach C mit A als Zwischenschritt
            //Diese 3 Schritte sind wichtig. Diese werden hier nur abstrakt betrachtet
        }
    }
    public String toString(){
        return towerC.toString();
    }
}
