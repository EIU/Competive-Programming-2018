
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

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
        int k = scan.nextInt();
        TreeSet<Integer> tree = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            int a = scan.nextInt();
            tree.add(a);
            list.add(a);
        }
        
        int count=0;
        for (int i=0;i<n;i++){
            Integer z = tree.higher(list.get(i));
            if (z == null || z -k > list.get(i)){
                count++;
            }
        }
        System.out.println(count);
    }

}
