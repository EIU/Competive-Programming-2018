
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
        int num2 =0;
        for (int i=0;i<number;i++){
            if (scan.nextInt()==2){
                num2++;
            }
        }
        if (num2==0){
            System.out.println(number/3);
        } else {
            if (num2>number/2){
                System.out.println(number-num2);
            } else {
                System.out.println(num2+(number-num2*2)/3);
            }
        }
        
        
    }
}
