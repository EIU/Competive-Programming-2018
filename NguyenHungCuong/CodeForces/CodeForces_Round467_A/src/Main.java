
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
        int[] res = new int[601];
        int number = scan.nextInt();
        while (number-->0){
            int a = scan.nextInt();
            res[a]++;
        }
        int result=0;
        for (int i=1;i<res.length;i++){
            if (res[i]!=0){
                result++;
            }
        }
        System.out.println(result);
    }
    
}
