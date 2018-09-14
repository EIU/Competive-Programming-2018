
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
        Scanner scan = new  Scanner(System.in);
        int n = scan.nextInt();
        int k=n;
        boolean[] list = new boolean[n+1];
        while (k-->0){
            list[scan.nextInt()]=true;
        }
        
        boolean[] a = list;
        if (a[1]==false){
            for (int i=1;i<n;i+=2){
                for (int j=i+1;j<=n;j++){
                if (a[i]==true){
                    a[1]=true;
                    a[i]=false;
                }
            }
            }
            
           
        } else {
            
        }
        
        
        
    }
    
}
