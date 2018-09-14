
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
        int left = scan.nextInt();
        int right = scan.nextInt();
        int ambi = scan.nextInt();
        while (ambi != 0) {
            if (left >= right) {
                right++;
            } else {
                left++;
            }
            ambi--;
        }
        if (left==right){
            System.out.println(left+right);
        }else{
            System.out.println(left+right-Math.abs(left-right));
        }
    }

}
