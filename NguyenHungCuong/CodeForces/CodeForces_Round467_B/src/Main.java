
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
        int mid = scan.nextInt();
        int top = scan.nextInt();
        if (top % 2 == 0) {
            top--;
        }
        boolean flag;
        while (top > mid) {
            flag=true;
            for (int i = 3; i <= Math.min(mid, Math.sqrt(top)); i += 2) {
                if (top % i == 0) {
                    top -= 2;
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println(top);
                return;
            }
        }
        System.out.println("-1");
    }

}
