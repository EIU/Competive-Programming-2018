
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] listNumbers = new int[N];
        for (int i = 0; i < N; i++) {
            listNumbers[i] = input.nextInt();
        }
        ArrayList<String> listResult = new ArrayList<String>();
        Arrays.sort(listNumbers);
        int i = 0, j = i + 1;
        while (i < listNumbers.length) {
            if (j < listNumbers.length && listNumbers[j] == listNumbers[i] + j - i) {
                j++;
                continue;
            }
            if (j - i == 2) {
                listResult.add(listNumbers[i] + " ");
                listResult.add(listNumbers[j - 1] + " ");
            } else if (j - i == 1) {
                listResult.add(listNumbers[i] + " ");
            } else {
                listResult.add(listNumbers[i] + "-" + listNumbers[j - 1] + " ");

            }

            i = j;
            j = i + 1;
        }
        for (int index = 0; index < listResult.size(); index++) {
            System.out.print(listResult.get(index));
        }
    }
}
