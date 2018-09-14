import java.util.Scanner;

public class Commercial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int sum=0;
		int max=0,max1=0;
		for (int i = 0; i < n; i++) {
			int a=sc.nextInt()-k;
			max=Math.max(0, a+max);
			max1=Math.max(max1, max);
			
		}
		System.out.println(max1);

	}

}
