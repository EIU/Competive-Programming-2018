
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
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int[] myChar = new int[10];
        int i=0;
        while (number>26){
            if (myChar[i]<26){
            myChar[i]++;
            } else 
            {
                i++;
                myChar[i]++;
            }
            number-=26;
        }
        String myString="";
        for (int j=0;j<i;j++){
            myString += (char)(myChar[j]+64);
        }
        myString+=(char)(number+64);
        System.out.println(myString);
    }
    
}
