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
        int[] bubbleTeas = new int[n];
        for(int i = 0; i < n; i++)
        {
            bubbleTeas[i] = ip.nextInt();
        }
        int m = ip.nextInt();
        int[] toppings = new int[m + 1];
        for(int i = 1;i <= m;i++)
        {
            toppings[i] = ip.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            int k = ip.nextInt();
            for(int j = 0; j < k; j++)
            {
                int ith = ip.nextInt();
                int price = bubbleTeas[i] + toppings[ith];
                if(price < min)
                {
                    min = price;
                }
            }
        }
        long money = ip.nextLong();
        long students = money / min;
        if(students >= 1)
        {
            System.out.println(students - 1);
        }
        else
        {
            System.out.println("0");
        }
    }
    
}
