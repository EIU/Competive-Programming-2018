import java.util.Scanner;

public class Guess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 1000;
        int n = 500;
        System.out.println(n);
        for (int i = 0; i < 9; i++) {
            String repose = sc.nextLine();
            if (repose.equals("correct")) {
                break;
            }
            if (repose.equals("higher")) {
                a=n+1;
                n=((b + a) / 2);
            }
            if (repose.equals("lower")) {
                b=n-1;
                n=((a + n) / 2);
            }
            System.out.println(n);
        }
    }

}