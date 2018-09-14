import java.util.Scanner;
 
class EIUCONS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long count = 0;
		for (int i = 0; i < t; i++) {
			long n = sc.nextLong();
			long a = sc.nextLong();
			long b = sc.nextLong();
			long[] arr = new long[(int) n + 1];
			arr[0] = a % b;
			long max = 0;
			max = Math.max(max, arr[0]);
			for (int j = 1; j < n; j++) {
				arr[j] = (a * arr[j - 1]) % b;
				max = Math.max(max, arr[j]);
			}
			count += max;
		}
		System.out.println(count);
	}
 
}