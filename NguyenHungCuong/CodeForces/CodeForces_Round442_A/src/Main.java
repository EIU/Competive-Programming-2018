
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = {"Danil", "Olya", "Slava", "Ann", "Nikita"};
        String res = scan.next();
        int count = 0;
        for (String i : str) {
            while (count <= 1) {
                String temp = res.replaceFirst(i, "*");
                if (!temp.equals(res)) {
                    count++;
                    res=temp;
                } else break;
            }
        }
        if (count == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
