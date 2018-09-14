import java.util.Scanner;

public class rank {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int g1 = reader.nextInt();
		int g2 = reader.nextInt();
		int g3 = reader.nextInt();
		int g4 = reader.nextInt();
		int max = g1 + g2 + g3 + g4;
		int rank=1;
		for (int i = 0; i < n - 1; i++) {
			g1 = reader.nextInt();
			g2 = reader.nextInt();
			g3 = reader.nextInt();
			g4 = reader.nextInt();
			int temp = g1 + g2 + g3 + g4;
			rank=max<temp?rank+1:rank;
		}
		System.out.println(rank);
	}

}
