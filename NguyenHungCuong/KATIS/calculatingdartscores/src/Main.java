
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
        int n = scan.nextInt();
        boolean[] arr = new boolean[61];
        for (int i=1;i<=20;i++){
            for (int j=1;j<=3;j++){
                arr[i*j] = true;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=60;i>=1;i--){
            if (arr[i]){
                list.add(i);
            }
        }

        for (int i=0;i<list.size();i++){
            if (list.contains(n)){
                System.out.println(makeDice(n));
                return;
            }
            for (int j=0;j<list.size();j++){
                int res = list.get(i) + list.get(j);
                if (res == n){
                    System.out.println(makeDice(list.get(i)));
                    System.out.println(makeDice(list.get(j)));
                    return;
                }
                res = n - res;
                if (list.contains(res)){
                    System.out.println(makeDice(list.get(i)));
                    System.out.println(makeDice(list.get(j)));
                    System.out.println(makeDice(res));
                    return;
                }
                
            }
        }
        System.out.println("impossible");
    }
    public static String makeDice(int a){
        if (a%3==0){
            return "triple "+a/3;
        }
        if (a%2==0){
            return "double "+a/2;
        }
        return "single "+a;
    }
}
