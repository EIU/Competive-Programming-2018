
import java.text.DecimalFormat;
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
        int numPeople = scan.nextInt();
        int[] property = new int[numPeople];
        double maxProperty = 0;
        for (int i = property.length - 1; i >= 0; i--) {
            property[i] = scan.nextInt();
            maxProperty += property[i];
        }
        double maxNum = 0;
        double numA = 0;
        double numB = 0;
        for (int j = 1; j <= numPeople; j++) {
            double sum = 0;
            for (int k = 0; k < j; k++) {
                sum += property[k];
            }
            sum /= maxProperty;
            double percenPeople = j / Double.parseDouble(Integer.toString(numPeople));
            if (Math.abs(sum - percenPeople) > maxNum) {
                maxNum = Math.abs(sum - percenPeople);
                numA = sum;
                numB = percenPeople;
            }
        }
        if ((numB * 10000) % 10 > 5) {
            numB = numB * 100 + 0.1 - 0.05;
        } else {
            numB *= 100;
        }
        if ((numA * 10000) % 10 > 5) {
            numA = numA * 100 + 0.1 - 0.05;
        } else {
            numA *= 100;
        }
        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println(df.format(numB) + " " + df.format(numA));
    }
}
