import java.util.Arrays;
import java.util.Scanner;

public class eight_queen {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int[] colum = new int[8];
		int[] row = new int[8];

		for (int i = 0; i < 8; i++) {
			String s = input.nextLine();
			if (s.indexOf("*") != s.lastIndexOf("*") || s.length() > 8) {
				System.out.println("invalid");
				return;
			}
			int temp = s.indexOf("*");
			colum[i] = i;
			row[i] = temp;
		}
		for (int i = 0; i < row.length - 1; i++) {
			for (int j = i + 1; j < row.length; j++) {
				if ((row[i] == row[j]) || (Math.abs(row[i] - row[j]) == Math.abs(colum[i] - colum[j]))||row[j]==-1) {
					System.out.println("invalid");
					return;
				}
			}
		}

		System.out.println("valid");
		return;

	}

}
