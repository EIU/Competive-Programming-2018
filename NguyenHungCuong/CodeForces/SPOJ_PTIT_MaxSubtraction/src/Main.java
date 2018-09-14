
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
        int min=scan.nextInt();
        long maxSub=0;
        for (int i=1;i<n;i++){
            int a=scan.nextInt();
            if (a-min>maxSub) maxSub=a-min;
            if (a<min) min=a;
        }
        System.out.println(maxSub);
    }
    
}
