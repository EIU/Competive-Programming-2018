
import java.util.ArrayList;
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
        int x = scan.nextInt();
        int y = scan.nextInt();
        if (y==0){
            System.out.println("No");
            return;
        }
        if (y==1){
            if (x==0){
                System.out.println("Yes");
            } else{
                System.out.println("No");
            }
            return;
        }
        y--;
        if (x>=y){
            if ((x-y)%2==0){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }
        
    }
    static boolean check(long a){
        for (int i=2;i<Math.sqrt(a);i++){
            if (a%i==0) return false;
        }
        return true;
    }

}
