
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
        long n = scan.nextLong();
        long m = scan.nextLong();
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        long mod = n%m;
        //System.out.println(mod);
        if (mod == 0) {
            
            System.out.println("0");
        } else {
            long res = Long.MAX_VALUE;
            if (n>m){
                res = Math.min(res, (m-mod)*a);
                res = Math.min(res, mod * b);
            } else {
                res = Math.min(res, (m-n)*a);
                res = Math.min(res, n * b);
                
            }
            System.out.println(res);
        }
    }
    
}
