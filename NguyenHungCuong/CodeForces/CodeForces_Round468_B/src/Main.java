
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
        int a = scan.nextInt();
        int b = scan.nextInt();
        int round=1;
        a--;b--;
        a/=2;b/=2;
        while (a!=b){
            n/=2;
            a/=2;
            b/=2;
            round++;
        }
        if (n==2){
            System.out.println("Final!");
        } else {
            System.out.println(round);
        }
    }

}
