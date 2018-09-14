
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
        String res = scan.next();
        if (res.length() >= 26) {

            for (int i = 0; i < res.length() - 26; i++) {
                String a = res.substring(i, 26+i);
                int countQues=0;
                boolean[] check = new boolean[26];
                for (int j = 0; j < 26; j++) {
                    char mychar = a.charAt(j);
                    if ((int)mychar>=65&&(int)mychar<=90&&a.contains(mychar)){
                        
                    }
                    
                }
                
            }
        }
    }

}
