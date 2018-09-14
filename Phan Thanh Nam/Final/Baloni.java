import java.util.Scanner;

public class Baloni {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count=n;
		int []arr=new int[n*10];
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			arr[num]++;
			if(arr[num+1]!=0) {
				count--;
				arr[num+1]--;
			}
		}
		System.out.println(count);
	}

}
