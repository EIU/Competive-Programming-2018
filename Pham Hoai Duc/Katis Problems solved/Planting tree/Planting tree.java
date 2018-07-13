/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author Duc PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int[] trees = new int[n];
        for(int i = 0; i < n; i++)
        {
            trees[i] = ip.nextInt();
        }
        Arrays.sort(trees);
        int days = trees[0];
        int j = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            if(trees[i] + j > days)
            {
                days = trees[i] + j;
            }
            j++;
        }
        System.out.println(days + 2);
 
    }

}
