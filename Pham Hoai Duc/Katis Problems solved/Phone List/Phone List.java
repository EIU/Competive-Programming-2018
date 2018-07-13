/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
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
        int t = ip.nextInt();
        for(int test = 0; test < t; test++ )
        {
            int n = ip.nextInt();
            String[] s = new String[n];
            for(int i = 0; i < n; i++)
            {
                s[i] = ip.next();
            }
            Arrays.sort(s);
            boolean tag = false;
            for(int i = 0; i <  n - 1; i++)
            {
                if(s[i + 1].startsWith(s[i])){
                    System.out.println("NO");
                    tag = true;
                    break;
                };
            }
            if(tag == false)
            {
                System.out.println("YES");
            }
            
        }

    }
    
}
