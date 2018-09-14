
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
        int length=scan.nextInt();
        int number = scan.nextInt();
        int[] collum = new int[length+1];
        int enough =0;
        int point=0;
        for (int i=0;i<number;i++){
            int n = scan.nextInt();
            if (collum[n]==0){
                enough++;
            }
            collum[n]++;
            if (enough==length){
                for (int j=1;j<length+1;j++){
                    collum[j]--;
                    if (collum[j]==0){
                        enough--;
                    }
                }
                point++;
            }
        }
        System.out.println(point);
    }
    
}
