import java.util.Arrays;
import java.util.Scanner;
class EIUCOL {
	public static int count(int P[], int n) {
		int dp[] = new int[n*10];
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] != 0||i==0) {
				dp[i + P[0]] = Math.max(dp[i + P[0]], dp[i] + 1);
				dp[i + P[1]] = Math.max(dp[i + P[1]], dp[i] + 1);
				dp[i + P[2]] = Math.max(dp[i + P[2]], dp[i] + 1);
			}
		}
		return dp[n];
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] P = new int[3];
		for (int i = 0; i < 3; i++) {
			P[i] = sc.nextInt();
		}
		System.out.println(count(P, n));
	}
 
}
 