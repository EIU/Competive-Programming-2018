import java.util.Scanner;

public class Image {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] image = new int[H][W];
		int[][] kenel = new int[N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				image[i][j] = sc.nextInt();
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				kenel[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i + N <= H; i++) {
			for (int j = 0; j + M <= W; j++) {
				int sum = 0;
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < M; l++) {
						sum += kenel[k][l] * image[i + k][j + l];
					}
				}
				System.out.print(sum + " ");
			}
			System.out.println();
		}
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(image[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

}
