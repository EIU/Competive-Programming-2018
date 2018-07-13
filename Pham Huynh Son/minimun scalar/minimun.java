import java.util.*;

public class minimun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder strBuilder = new StringBuilder();
        int t = input.nextInt();
        
        int count=1;
        while (t > 0) {
            t--;
            List<Long> list1 = new ArrayList<Long>();
            List<Long> list2 = new ArrayList<Long>();
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                list1.add(input.nextLong());
            }
            for (int i = 0; i < n; i++) {
                list2.add(input.nextLong());
            }
            Collections.sort(list2);
            Collections.sort(list1);
            long sub = 0;
            for (int i = 0; i < n; i++) {
                sub += list1.get(i) * list2.get(n-i-1);
            }
            strBuilder.append("Case #"+count+":"+" "+sub).append("\n");
            count++;
        }
        System.out.println(strBuilder);
    }
}

