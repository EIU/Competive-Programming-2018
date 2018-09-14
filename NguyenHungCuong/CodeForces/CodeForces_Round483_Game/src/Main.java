
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
        int turns = scan.nextInt();
        int[] list = new int[turns+1];
        for (int i=1;i<=turns;i++){
            list[i]=scan.nextInt();
        }
        Arrays.sort(list);
        if (turns==1){
            System.out.println(list[1]);
        } else {
            System.out.println(list[((turns%2==0)?turns:turns+1)/2]);
        }
    }
    
}
