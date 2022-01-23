package K1;

public class U4 {
    public static void main(String[] args) {
        System.out.println(calculatePi(1000));
    }
    public static double calculatePi(int nTerms){
        final double numerator = 4;
        double denominator = 1;
        double operation = 1;
        double pi = 0;
        for (int x = 0; x < nTerms; x++){
            pi = pi + (operation * (numerator/denominator));
            operation = operation * (-1);
            denominator = denominator + 2;
        }
        return pi;
    }
}
