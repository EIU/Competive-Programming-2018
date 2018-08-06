
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

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }

        list.sort((a, b) -> (b - a));

        int max =0;
        for (int i=0;i<n;i++){
            int res = list.get(i);
            res += i+1;
            max = Math.max(max, res);
        }
        System.out.println(max+1);
    }

}
