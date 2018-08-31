
import java.util.Scanner;
import java.util.Arrays;

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
        int stringLength = scan.nextInt();
        int num_Keyword = scan.nextInt();
        int keywordLength = scan.nextInt();
        int resultLocation = scan.nextInt();
        String theString = scan.next();
        String[] stringArray = new String[num_Keyword];
        for (int i = 0; i < num_Keyword; i++) {
            String myString = scan.next();
            char[] myChar = myString.toCharArray();
            Arrays.sort(myChar);
            stringArray[i] = new String(myChar);
        }
        char[] temp = theString.toCharArray();
        for (int j=stringLength-1;j>=0;j--){
            if (temp[j]=='#'){
                if (resultLocation%keywordLength==0){
                    temp[j]=stringArray[num_Keyword-1].charAt(keywordLength-1);
                    resultLocation/=keywordLength;
                } else {
                    temp[j]=stringArray[num_Keyword-1].charAt(resultLocation%keywordLength-1);
                    resultLocation = resultLocation/keywordLength+1;
                }
                num_Keyword--;
            }
        }
        theString = new String(temp);
        System.out.println(theString);
    }
}
