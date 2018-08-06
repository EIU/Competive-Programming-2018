
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
        int rooms = scan.nextInt();
        int bookedRooms = scan.nextInt();
        boolean[] list = new boolean[rooms+1];
        for (int i=0;i<bookedRooms;i++){
            list[scan.nextInt()] = true;
        }
        if (rooms == bookedRooms){
            System.out.println("too late");
        } else {
            for (int i=1;i<rooms +1;i++){
                if (!list[i]){
                    System.out.println(i);
                    break;
                }
            }
        }
        
    }
    
}
