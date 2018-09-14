import java.util.Scanner;
 class ants {
 
	static long maxLoot(long hval[], int n) {
 
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return hval[0];
		}
 
		long[] dp = new long[n];
		dp[0] = hval[0];
		if (dp[0] < 0) {
			dp[0] = 0;
		}
		dp[1] = Math.max(hval[0], hval[1]);
		if (n == 2) {
			return dp[1];
		}
		dp[2] = Math.max(dp[1], hval[2]);
		if (n == 3) {
			return dp[2];
		}
		for (int i = 3; i < n; i++)
			dp[i] = Math.max(hval[i] + dp[i - 3], dp[i - 1]);
		return dp[n - 1];
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		long hval[] = new long[m];
		for (int i = 0; i < m; i++) {
			hval[i] = sc.nextLong();
			if (hval[i] < 0) {
				hval[i]=0;
			}
		}
		int n = hval.length;	
		System.out.println(maxLoot(hval, n));
 
	}
 
}
 