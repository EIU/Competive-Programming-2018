import java.math.BigInteger;
import java.util.Scanner;

public class Pseudoprime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int p = sc.nextInt();
            int a = sc.nextInt();
            if (p == 0 && a == 0) {
                break;
            }
            BigInteger p1 = BigInteger.valueOf(p);
            BigInteger a1 = BigInteger.valueOf(a);
            if (!p1.isProbablePrime(1) && a1.modPow(p1, p1).equals(a1)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
