
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
        int number = scan.nextInt();
        int a = 0;
        for (int i = 0; i < number; i++) {
            a++;
            while (!check(a)) {
                a++;
            }
        }
        System.out.println(a);
    }

    static boolean check(int a) {
        int temp = 0;
        while (a != 0) {
            if (temp <= 10) {
                temp += a % 10;
                a /= 10;
            } else {
                break;
            }
        }
        return temp == 10;
    }
}
