
import java.util.Hashtable;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        Hashtable<Integer,Integer> myHT = new Hashtable<>(p);
        int n = scan.nextInt();
        int result=-1;
        for (int i=1;i<=n;i++){
            int x = scan.nextInt();
            int index = x%p;
            if (myHT.put(index, x)!=null){
                if (result==-1){
                    result=i;
                }
            }
        }
        System.out.println(result);
    }
}
