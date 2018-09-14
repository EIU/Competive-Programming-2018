
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < list.length; i++) {

            list[i] = scan.nextInt();

        }
        if (n ==1 ) {
            System.out.println("1");
            return;
        }

        int[] increasing = new int[n];
        int[] decreasing = new int[n];
        increasing[0] = 1;

        for (int i = 1; i < n; i++) {

            if (list[i] > list[i - 1]) {
                increasing[i] = increasing[i - 1] + 1;
            } else {
                increasing[i] = 1;
            }

        }

        decreasing[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {

            if (list[i] < list[i + 1]) {
                decreasing[i] = decreasing[i + 1] + 1;
            } else {
                decreasing[i] = 1;
            }

        }

        int result = 1;
        for (int i = 1; i < n - 1; i++) {
            if (list[i - 1] + 1 < list[i + 1]) {
                result = Math.max(result, increasing[i - 1] + decreasing[i + 1] + 1);
            } else {

                result = Math.max(result, increasing[i - 1] + 1);

                result = Math.max(result, decreasing[i + 1] + 1);
            }
        }

        result = Math.max(result, decreasing[1] + 1);

        result = Math.max(result, increasing[n -2] + 1);
        
        System.out.println(result);
    }

}
