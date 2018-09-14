
import java.util.Arrays;
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
        int numFriend = scan.nextInt();
        int maxDistance = scan.nextInt();
        friend[] myFriend = new friend[numFriend];
        for (int i = 0; i < myFriend.length; i++) {
            int money = scan.nextInt();
            int respect = scan.nextInt();
            myFriend[i] = new friend(money, respect);
        }
        Arrays.sort(myFriend, (n1, n2) -> {
            if (n1.money > n2.money) {
                return 1;
            }
            if (n1.money < n2.money) {
                return -1;
            }
            return 0;
        });
        int a, b = 1;
        long maxRespect = myFriend[0].respect, sum = myFriend[0].respect;
        for (a = 0; a < myFriend.length; a++) {
            for (; b < myFriend.length; b++) {
                if (myFriend[b].money - myFriend[a].money < maxDistance) {
                    sum += myFriend[b].respect;
                } else break;
            }
            maxRespect = Math.max(sum, maxRespect);
            sum -= myFriend[a].respect;
        }
        System.out.println(maxRespect);
//        for (friend friend1 : myFriend){
//            System.out.println(friend1.money+" "+friend1.respect);
//        }

    }

    static class friend {

        public int money;
        public int respect;

        public friend(int money, int respect) {
            this.money = money;
            this.respect = respect;
        }

    }
}
