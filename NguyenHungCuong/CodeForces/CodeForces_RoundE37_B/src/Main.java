
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        int numTest = scan.nextInt();
        for (int i = 0; i < numTest; i++) {
            int numStudent = scan.nextInt();
            pair[] student = new pair[numStudent];
            for (int j=0;j<numStudent;j++){
                int come = scan.nextInt();
                int leave = scan.nextInt();
                student[j]=new pair( come, leave,j);
            }
            Arrays.sort(student);
            int current=0;
            for (int j=0;j<numStudent;j++){
                if (student[j].right>=current){
                    current=Math.max(current, student[j].left);
                    System.out.print(current+" ");
                    current++;
                } else {
                    System.out.print(0+" ");
                }
            }
            
            System.out.println("");
        }
    }
    static class pair implements Comparable<pair>{

            private int left;
            private int right;
            private int index;

        public pair(int left, int right, int index) {
            this.left = left;
            this.right = right;
            this.index = index;
        }
        @Override
        public int compareTo(pair t) {
            if (left>t.left) return left-t.left;
            return index-t.index;
        }
        
    }
    

}
