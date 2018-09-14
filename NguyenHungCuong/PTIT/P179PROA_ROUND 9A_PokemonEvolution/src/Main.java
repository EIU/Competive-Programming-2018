
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_Poke = scan.nextInt();
        int numSumEvolved =0;
        int maxEvolved=0;
        String maxName = "";
        for (int i=0;i<num_Poke;i++){
            String temp = scan.next();
            int numGemsNeed = scan.nextInt();
            int numGems = scan.nextInt();
            int numEvolved =0;
            while (numGems>=numGemsNeed){
                numGems-=numGemsNeed;
                numGems+=2;
                numEvolved++;
            }
            numSumEvolved+=numEvolved;
            if (numEvolved>maxEvolved){
                maxEvolved=numEvolved;
                maxName=temp;
            }
        }
        
        System.out.println(numSumEvolved);
        System.out.println(maxName);
    }
}
