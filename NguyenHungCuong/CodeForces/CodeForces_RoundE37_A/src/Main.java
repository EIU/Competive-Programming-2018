
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
        int numTest = scan.nextInt();
        for (int i = 0; i < numTest; i++) {
            int numBeds = scan.nextInt();
            int numTaps = scan.nextInt();
            int maxDistance = scan.nextInt() - 1;
            int lastBed = maxDistance + 1;
            for (int j = 1; j < numTaps; j++) {
                int res = scan.nextInt();
                maxDistance = Math.max(maxDistance, (res - lastBed) / 2);
                lastBed = res;
            }
            maxDistance = Math.max(maxDistance, numBeds - lastBed);
            System.out.println(maxDistance + 1);
        }
    }

}
