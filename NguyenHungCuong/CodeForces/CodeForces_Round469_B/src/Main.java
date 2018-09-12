
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
        int a=scan.nextInt();
        int b=scan.nextInt();
        int[] x = new int[a];
        int[] y = new int[b];
        for (int i=0;i<a;i++){
            x[i]=scan.nextInt();
        }
        for (int i=0;i<b;i++){
            y[i]=scan.nextInt();
        }
        int count=0;
        int indexA=0;
        int indexB=0;
        int sumA=0;
        int sumB=0;
        while (indexA<a||indexB<b){
            sumA+=x[indexA];
            sumB+=y[indexB];
            while (sumA!=sumB){
                if (sumA>sumB){
                    sumB+=y[++indexB];
                }else{
                    sumA+=x[++indexA];
                }
            }
            count++;
            indexA++;
            indexB++;
        }
        System.out.println(count);
    }
    
}
