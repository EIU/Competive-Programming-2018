import java.util.Scanner;

public class tutorial {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        StringBuilder strBuilder = new StringBuilder();
        int m = reader.nextInt();
        int n = reader.nextInt();
        int p = reader.nextInt();
        switch (p) {
        case 1: {
            if (n >= 20)
                System.out.println("TLE");
            else
                System.out.println(gt(n) > m ? "TLE" : "AC");
            break;
        }
        case 2: {
            if (n > 32)
                System.out.println("TLE");
            else
                System.out.println(Math.pow(2, n) > m ? "TLE" : "AC");
            break;
        }
        case 3: {
            System.out.println(Math.pow(n, 4) > m ? "TLE" : "AC");
            break;
        }
        case 4: {
            System.out.println(Math.pow(n, 3) > m ? "TLE" : "AC");
            break;
        }
        case 5: {
            System.out.println(Math.pow(n, 2) > m ? "TLE" : "AC");
            break;
        }
        case 6: {
            System.out.println(n * log2(n) > m ? "TLE" : "AC");
            break;
        }
        case 7: {
            System.out.println(n > m ? "TLE" : "AC");
            break;
        }
        }
    }

    public static double logb(double a, double b) {
        return Math.log(a) / Math.log(b);
    }

    public static double log2(double a) {
        return logb(a, 2);
    }

    static int gt(int n) {
        if (n > 1) {
            return n * gt(n - 1);
        }
        return n;
    }
}

