import java.util.Scanner;

public class Dividing {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int [n];
        int i=1;
        int count=0;
        while(i*2<=n) {
            arr[count]=i;
            i*=2;
            count++;
            
        }
        arr[count]=i;
        System.out.println(count+1);
        for(int j=0;j<count+1;j++) {
            System.out.println(arr[j]+" ");
        }
    }

}