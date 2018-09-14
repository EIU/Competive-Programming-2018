
import java.util.Scanner;

public class Main {

    static char[] temp = {'a', 'o', 'i', 'e', 'u', 'y'};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String str = scan.next();
        char[] res = str.toCharArray();
        int index = 0;
        while (index != num - 1 && index < str.length()) {
            if (check(res[index])) {
                if (check(res[index+1])) {
                    char[] tam = new char[res.length-1];
                    for (int i=0;i<=index;i++){
                        tam[i]=res[i];
                    }
                    for (int i=index+1;i<tam.length;i++){
                        tam[i]=res[i+1];
                    }
                } else {
                    index += 2;
                }
            } else {
                index++;
            }
        }
        System.out.println(str);

    }

    static boolean check(char a) {
        for (int i = 0; i < 6; i++) {
            if (a == temp[i]) {
                return true;
            }
        }
        return false;
    }

}
