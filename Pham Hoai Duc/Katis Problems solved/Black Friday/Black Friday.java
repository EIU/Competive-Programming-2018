/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

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
        int[] outCome = new int[n];
        int[] unique = new int[7];
        for(int i = 0; i < n; i++)
        {
            outCome[i] = ip.nextInt();
            unique[outCome[i]]++;
        }
        int max = 0;
        int index = -1;
        for(int i = 0; i < n; i++)
        {
            if(unique[outCome[i]] == 1)
            {
                if(outCome[i] > max)
                {
                    max = outCome[i];
                    index = i;
                }
            }
        }
        if(index == -1)
        {
            System.out.println("none");
        }
        else
            System.out.println(index + 1);
    }
    
}
