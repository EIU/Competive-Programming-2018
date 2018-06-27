
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
        int[][] list = new int[1001][1001];
        for (int i=1;i<1001;i++){
            for (int j=1;j<1001;j++){
                list[i][j] = i+j;
            }
        }
        boolean[][] check = new boolean[1001][1001];
        
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
        
        for (int i=0;i<numTea;i++){
            int k=scan.nextInt();
            for (int j=0;j<k;j++){
                int topping = scan.nextInt();
                check[listTea[i]][topping] = true;
            }
        }
        int money = scan.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i=0;i<numTea;i++){
            for (int j=0;j<numTopping;j++){
                if (check[listTea[i]][listTopping[j]]){
                    int temp = list[listTea[i]][listTopping[j]];
                    if (temp<min){
                        min = temp;
                    }
                }
            }
        }
        System.out.println((money/min) -1);
        
    }
    
}
