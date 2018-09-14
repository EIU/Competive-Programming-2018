
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
        int num0 = 0;
        int[] myList = new int[number];
        for (int i = 0; i < myList.length; i++) {
            myList[i] = scan.nextInt();
            if (myList[i] == 0) {
                num0++;
            }
        }
        int sum=myList[0];
        if (num0 == number) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 1; i < myList.length; i++) {
                int index =i;
                if (sum+myList[i]==0){
                    System.out.println("");
                }
            }
        }

    }
}
