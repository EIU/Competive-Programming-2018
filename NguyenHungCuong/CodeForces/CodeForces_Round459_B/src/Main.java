
import java.util.HashMap;
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        HashMap<String, String> myHM = new HashMap<>();
        while (n-- > 0) {
            String a = scan.next();
            String b = scan.next();
            myHM.put(b+";"," #"+a);
        }
        while (m-->0){
            String a = scan.next();
            String b = scan.next();
            System.out.println(a+" "+b+myHM.get(b));
        }
    }
}
