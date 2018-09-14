import java.util.ArrayList;
import java.util.Scanner;

public class avoidland {
    public static int process(int []arr){
        ArrayList<Integer> doubled=new ArrayList<>();
        ArrayList<Integer> missing=new ArrayList<>();
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 0) {
                missing.add(i);
            }

            for(int j = arr[i]; j > 1; j--) {
                doubled.add(i);
            }
        }
        int total=0;
        for(int i = 0; i < doubled.size(); i++) {
            total += Math.abs(doubled.get(i) - missing.get(i));
        }
        return total;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]a=new int[n+1];
        int[]b=new int[n+1];
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            a[x]++;
            b[y]++;
        }
        int total=0;
        total+=process(a);
        total+=process(b);
        System.out.println(total);
    }
}
