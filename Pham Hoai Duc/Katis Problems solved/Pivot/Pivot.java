/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2problemd;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Duc PC
 */
public class W2ProblemD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        long[]list = new long[n];
        long[]leftMax = new long[n];
        long[]rightMin = new long[n];
        for(int i = 0; i < n; i++)
        {
            list[i] = ip.nextLong();        
        }
        leftMax[0] = list[0];
        for(int i = 1; i < n; i++)
        {
            if(list[i] < leftMax[i - 1])
            {
                leftMax[i] = leftMax[i - 1];
            }
            else
            {
                leftMax[i] = list[i];
            }
        }
        rightMin[n - 1] = list[n - 1];
        for(int i = n - 2; i >=0; i--)
        {
            if(list[i] > rightMin[i + 1])
            {
                rightMin[i] = rightMin[i + 1];
            }
            else
            {
                rightMin[i] = list[i];
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(leftMax[i] <= list[i] && list[i] <= rightMin[i]){
                count++;
            }
        }
        System.out.println(count);

     
    }
}
