
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
        String input = scan.next();
        int[] result = new int[3];
        if (input.charAt(0)!='a'){
            System.out.println("NO");
            return;
        }else{
            result[0]++;
        }
        char pivot = 'a';
        int index=1;
        while (index<input.length()){
            char res = input.charAt(index);
            if (res-pivot==2||res-pivot<0){
                System.out.println("NO");
                return;
            }
            if (res!=pivot){
                pivot=res;
            }
            result[res-97]++;
            index++;
        }
        if (result[2]!=0 && (result[2]==result[0]||result[2]==result[1])){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
    
}
