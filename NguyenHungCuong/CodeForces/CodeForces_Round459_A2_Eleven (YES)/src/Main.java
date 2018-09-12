
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TOSHIBA
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] fibo = new int[16];
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        int number = scan.nextInt();
        String name = "";
        for (int i = 1; i <= number; i++) {
            if (check(fibo, i)) {
                name += "O";
            } else {
                name += "o";
            }
        }
        System.out.println(name);
    }

    static boolean check(int[] fibo, int number) {
        for (int i : fibo) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

}
