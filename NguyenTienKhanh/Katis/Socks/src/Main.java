
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long S = input.nextInt();
        long C = input.nextInt();
        long K = input.nextInt();
        ArrayList<Long> listSocks = new ArrayList<>();
        for (int i = 0; i < S; i++) {
            listSocks.add(input.nextLong());
        }
        Collections.sort(listSocks);
        long index = 0, j = 1, machine = 0;
        while (index < S) {
            if (j - index < C && j < S && listSocks.get((int) j) - listSocks.get((int) index) <= K) {
                j++;
            } else {
                machine++;
                index = j;
                j = index + 1;
            }
        }
        System.out.println(machine);

    }

}
