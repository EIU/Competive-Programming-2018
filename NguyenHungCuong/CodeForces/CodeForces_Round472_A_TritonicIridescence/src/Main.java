
import java.util.ArrayList;
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
        int num = scan.nextInt();
        String a = scan.next();
        char[] b = a.toCharArray();
        int count=0;
        for (int i=0;i<num;i++){
            if (b[i]=='?'){
                count++;
            }
        }
        if (count==0){
            System.out.println("No");
        } else {
            if (num<=2){
                System.out.println("Yes");
                return;
            }
            boolean check=true;
            for (int i=0;i<num-1;i++){
                if (b[i]!='?'&&b[i+1]!='?'){
                    if (b[i]==b[i+1]){
                        check=false;
                        break;
                    }
                }
            }
            if (check){
                if (b[num-2]!='?'&&b[num-1]!='?'){
                    if (b[num-2]==b[num-1]){         
                    System.out.println("No");
                    }
                }else{
                    System.out.println("Yes");
                }
            } else {
                System.out.println("No");
            }
        }
    }

}
