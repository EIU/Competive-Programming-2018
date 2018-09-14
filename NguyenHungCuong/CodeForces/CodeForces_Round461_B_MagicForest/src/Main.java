
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
        int num = scan.nextInt();
        int count=0;
        for (int i=0;i<num;i++){
            for (int j=i;j<num;j++){
                int k = i^j;
                if (k>j&&i+j>k&&k<=num){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
