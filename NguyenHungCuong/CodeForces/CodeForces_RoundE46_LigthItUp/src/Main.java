
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
        int m = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for (int i = 1; i < n + 1; i++) {
            arr.add(scan.nextInt());
        }
        arr.add(m);

        int time = 0;
        for (int i = 0; i < n + 1; i += 2) {
            time += (arr.get(i + 1) - arr.get(i));
        }
        //System.out.println(time);

        ArrayList<Integer> list = arr;
        ArrayList<Integer> list2 = arr;
        int res1, res2;
        //int res1;
        for (int i = 1; i < arr.size(); i++) {
            res1 = 0;
            res2 = 0;
            if (arr.get(i) == arr.get(i - 1) + 1 || i != arr.size() - 1 && arr.get(i) + 1 == arr.get(i + 1)) {
                continue;
            }
            list.add(i, list.get(i) - 1);
            list2.add(i + 1, list.get(i) + 1);
            for (int j = 0; j < list.size() - 1; j += 2) {
                res1 += (list.get(j + 1) - list.get(j));
                res2 += (list2.get(j + 1) - list2.get(j));
            }
            time = Math.max(time, res1);
            list.remove(i);
        }
        System.out.println(time);
    }

}
