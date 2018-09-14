
import java.util.Arrays;
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
           int[] size = new int[n];
           int[] cost = new int[n];
           int[] next = new int[n];
           Arrays.fill(next, (int)1e9);
           
           for (int i=0;i<n;i++) {
               
               size[i] = scan.nextInt();
           }
           
           for (int i=0;i<n;i++) {
               
               cost[i] = scan.nextInt();
           }
           
           for (int i=0; i<n;i++) {
               
               for (int j=i+1;j<n;j++) {
                   
                   if (size[j]>size[i]) {
                       
                       next[i] = Math.min(next[i], cost[j]);
                   }
               }
           }
           
           long min = Long.MAX_VALUE;
           for (int i=0; i<n;i++) {
               
               for (int j=i+1;j<n;j++) {
                   
                   if (size[j]>size[i]) {
                       
                       min = Math.min(min, cost[i] + cost[j] + next[j]);
                   }
               }
           }
           
           System.out.println((min >= (int)1e9)?-1:min);
           
    }
    
}
