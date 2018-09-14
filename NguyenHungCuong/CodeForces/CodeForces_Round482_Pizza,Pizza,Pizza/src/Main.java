
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
        if (n==0){
            System.out.println(n);
        }else
        if (n%2==0){
            System.out.println(n+1);
        } else{
            System.out.println((n+1)/2);
        }
    }
    
}
