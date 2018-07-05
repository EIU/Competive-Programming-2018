/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaw2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Duc PC
 */
public class ProblemAW2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++)
        {
            list[i] = ip.nextInt();
        }
        Arrays.sort(list);
        int i = 0, j = 0;
        int count = 0;
        while(i < n)
        {
            if(j + 1 < n)
            {
                if(list[j + 1] == list[j] + 1)
                {
                    j++;
                    count++;
                }
                else
                {
                    if(count >= 2)
                    {
                        System.out.print(list[i]+"-"+list[j]+" ");
                    }
                    else if(count == 1)
                    {
                        System.out.print(list[i]+" "+list[j] + " ");
                    }
                    else
                    {
                        System.out.print(list[i]+" ");
                    }
                    count = 0;
                    i = j + 1;
                    j++;

                }
            }
            else
            {         
                 if(count >= 2)
                 {
                     System.out.print(list[i]+"-"+list[j]+" ");
                     count = 0;
                     i = j + 1;
                     j++;
                 }
                 else
                 {
                      System.out.print(list[i] + " ");                
                        i++;
                 }
                
            }
        }
        
    }
    
}
