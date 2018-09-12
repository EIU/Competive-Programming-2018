
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
        int turn = scan.nextInt();
        String kuro = scan.next();
        String shiro = scan.next();
        String katie = scan.next();
        int[] list = new int[123];
        for (int i=0;i<kuro.length();i++){
            list[(int)kuro.charAt(i)]++;
            System.out.println((int)kuro.charAt(i));
        }
        int max1=list[0];
        for (int i:list){
            if (list[i]>max1){
                max1=list[i];
            }
        }
        list = new int[123];
        for (int i=0;i<shiro.length();i++){
            list[(int)shiro.charAt(i)]++;
            System.out.println((int)shiro.charAt(i));
        }
        int max2 = list[0];
        for (int i:list){
            if (list[i]>max2){
                max2=list[i];
            }
        }
        list = new int[123];
        for (int i=0;i<katie.length();i++){
            list[(int)katie.charAt(i)]++;
            System.out.println((int)katie.charAt(i));
        }
        int max3 = list[0];
        for (int i:list){
            if (list[i]>max3){
                max3=list[i];
            }
        }
        if (max1>max2&&max1>max3){
            System.out.println("Kuro");
        } else if (max2>max1&&max2>max3){
            System.out.println("Shiro");
        } else if (max3>max1&&max3>max2){
            System.out.println("Katie");
        } else {
            System.out.println("Draw");
        }
    }
    
}
