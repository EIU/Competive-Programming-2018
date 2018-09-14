
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
        Scanner sc = new Scanner(System.in);
        String firstName = sc.next();
        String lastName = sc.next();
        String nickName = "" + firstName.charAt(0);
        int firstIndex = 1;
        int lastIndex = 0;
        while (nickName.length() < 20) {
            if (firstIndex < firstName.length() && firstName.charAt(firstIndex) < lastName.charAt(lastIndex)) {
                nickName += firstName.charAt(firstIndex++);
            } else {
                nickName += lastName.charAt(lastIndex++);
                break;
            }

        }
        System.out.println(nickName);
    }
}
