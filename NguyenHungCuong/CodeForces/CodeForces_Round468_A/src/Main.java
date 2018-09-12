
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
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = Math.abs(a-b);
        int res =0;
        if (c%2==0){
            for (int i=1;i<=c/2;i++){
                res+=(i*2);
            }
        } else {
            for (int i=1;i<=c/2;i++){
                res+=(i*2);
            }
            res+=((c+1)/2);
        }
        System.out.println(res);
    }
    
}
