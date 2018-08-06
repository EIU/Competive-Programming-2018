import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);//Somehow InputReader did not work

        int n = scan.nextInt();
        int[] horizontal = new int[n + 1];
        int[] vertical = new int[n + 1];

        int x, y;
        for (int i = 0; i < n; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            horizontal[x]++;
            vertical[y]++;
        }
        
        long count = 0;
        
        count += processing(horizontal);
        count += processing(vertical);
        
        System.out.println(count);
    }
    
    static long processing(int[] arr){
        ArrayList<Integer> miss = new ArrayList<>();
        ArrayList<Integer> taken = new ArrayList<>();
        
        for (int i=1;i<arr.length;i++){
            if (arr[i] == 0){
                miss.add(i);
            }
            
            for (int j=arr[i];j>1;j--){
                taken.add(i);
            }
        }
        long res=0;
        for (int i=0;i<taken.size();i++){
            res+= Math.abs(taken.get(i)-miss.get(i));
        }
        return res;
    }
}