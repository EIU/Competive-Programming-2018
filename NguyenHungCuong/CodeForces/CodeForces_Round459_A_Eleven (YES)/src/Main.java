import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int ans = 0;
        char c[] = scan.nextLine().toCharArray();

        for (int i = 0; i < c.length; i++) {
            int open = 0;
            int close = 0;
            int question = 0;

            for (int j = i; j < c.length; j++) {
                if (c[j] == '(') open++;
                if (c[j] == ')') close++;
                if (c[j] == '?') {
                    if (open == close) open++;
                    else question++;
                }

                if (open + question < close) break;

                if (open < close + question) {
                    open++;
                    question--;
                }
                if (open == close + question) ans++;
            }
        }
        System.out.println(ans);
    }
}