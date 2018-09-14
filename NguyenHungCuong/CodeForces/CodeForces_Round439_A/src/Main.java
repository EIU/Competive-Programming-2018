
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
        int numSong = scan.nextInt();
        int duaration = scan.nextInt();
        int ans = 0;
        int time=0;
        while (numSong>0){
            time+=scan.nextInt();
            if (numSong!=1){
                ans+=2;
                time+=10;
            }
            if (time>duaration){
                System.out.println("-1");
                return;
            }
            numSong--;
        }
        ans+=(duaration-time)/5;
        
        System.out.println(ans);
    }
}
