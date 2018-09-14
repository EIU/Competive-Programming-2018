
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
        String a = scan.next();
        int numO=0;
        int numLink=0;
        for (int i=0;i<a.length();i++){
            if (a.charAt(i)=='o'){
                numO++;
            } else{
                numLink++;
            }
        }
       
        if (numO==0){
            System.out.println("YES");
        } else
        if (numLink%numO==0){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
}
