
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
        int number = scan.nextInt();
        int up=0;
        int down=0;
        for (int i=0;i<number;i++){
            int a = scan.nextInt();
            if (a>0){
                up+=a;
            }else{
                down+=a;
            }
        }
        System.out.println(up-down);
    }
    
}
