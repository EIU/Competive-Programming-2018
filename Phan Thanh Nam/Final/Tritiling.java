import java.util.Scanner;

public class Tritiling {
	public static long count(int n) {
		long[]dp=new long[31];
		dp[0]=1;
		dp[2]=3;
		for(int i=4;i<31;i++) {
			dp[i]=4*dp[i-2]-dp[i-4];
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=sc.nextInt();
			if(n<0) {
				break;
			}
			System.out.println(count(n));
		}
	}

}
