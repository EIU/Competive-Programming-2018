
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
        int day = scan.nextInt();
        int[] snow = new int[day];
        int[] heat = new int[day];
        for (int i=0;i<day;i++){
            snow[i]=scan.nextInt();
        }
        int last=0;
        for (int i=0;i<day;i++){
            heat[i]=scan.nextInt();
            int index=i;long sum=0;
            for (int k=last;k<=index;k++){
                if (snow[k]>heat[i]){
                    snow[k]-=heat[i];
                    sum+=heat[i];
                }else{
                    last=k;
                    
                    sum+=snow[k];
                    snow[k]=0;
                }
            }
            System.out.print(sum+" ");
        }
        
    }
    
}
