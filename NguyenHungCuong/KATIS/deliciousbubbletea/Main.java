
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
        
        int numTea = scan.nextInt();
        int[] listTea = new int[numTea];
        for (int i=0;i<numTea;i++){
           listTea[i] = scan.nextInt();
        }
        int numTopping = scan.nextInt();
        int[] listTopping = new int[numTopping];
        for (int i=0;i<numTopping;i++){
           listTopping[i] = scan.nextInt();
        }
        
        int min = Integer.MAX_VALUE,temp;
        for (int i=0;i<numTea;i++){
            int numTop = scan.nextInt();
            temp = Integer.MAX_VALUE;
            for (int j=0;j<numTop;j++){
                temp = Math.min(temp, listTopping[scan.nextInt()-1]);
            }
            min = Math.min(min, listTea[i]+temp);
        }
        //System.out.println(min);
        int res = (scan.nextInt()/min) - 1;
        
        System.out.println(Math.max(0,res));
        
    }
    
}
