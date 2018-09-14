
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
       // System.out.println(a.substring(a.indexOf("z")));
       String res ="";
        while (a.length() >= 26) {
            if (a.contains("z") && a.indexOf("z") < 25 && a.length() - a.indexOf("z") < 25) {
                System.out.println("-1");
                return;
            } else {
                if (!a.contains("z")) {
                    System.out.println(res+"abcdefghijklmnopqrstuvwxyz" + a.substring(26));
                    return;
                } else if (a.length()-a.indexOf("z")>=26){
                    res=a.substring(0, a.indexOf("z")+1);
                    a=a.substring(a.indexOf("z")+1);
                }else {
                    break;
                }
            }
        }
        System.out.println("-1");
    }

}
