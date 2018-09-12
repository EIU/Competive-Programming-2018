
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
        long n=scan.nextLong();
        long k= scan.nextLong();
        for (long i=1;i<=k;i++){
            if (n%i!=i-1){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
    
}
