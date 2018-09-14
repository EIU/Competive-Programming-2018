import java.util.ArrayList;
import java.util.Scanner;

public class Queens {
	static class pos {
		public int x;
		public int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static boolean check(ArrayList<pos> arr, pos point, int yes, int no) {
		for (int i = 0; i < arr.size(); i++) {
			if (point.x == arr.get(i).x && point.y == arr.get(i).y) {
				continue;
			}
			if ((point.x + point.y) % 2 != (arr.get(i).x + arr.get(i).y) % 2) {
				yes++;

			} else {
				if (point.x + point.y == arr.get(i).x + arr.get(i).y
						|| point.x + arr.get(i).y == point.y + arr.get(i).x) {
					no++;
				} else {
					yes++;
				}
			}
		}
		if (no > 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<pos> point = new ArrayList<>();
		char[][] character = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String s = sc.next();
			character[i] = s.toCharArray();
		}
		for (int i = 0; i < 8; i++) {
			int count = 0;
			int count1 = 0;
			for (int j = 0; j < 8; j++) {
				if (character[i][j] == '*') {
					count++;
					if (count == 1) {
						point.add(new pos(8 - i, j + 1));
					}
				}
				if (character[j][i] == '*') {
					count1++;

				}
			}
			if (count > 1) {
				System.out.println("invalid");
				return;
			}
			if (count1 > 1) {
				System.out.println("invalid");
				return;
			}
		}
		if (point.size() == 8) {
			int yes = 0;
			int no = 0;
			int count1 = 0;
			int count2 = 0;
			for (int i = 0; i < point.size(); i++) {
				if (check(point, point.get(i), yes, no)) {
					count1++;
				} else {
					count2++;
				}
			}
			if (count1 == 8) {
				System.out.println("valid");
			} else {
				System.out.println("invalid");
			}
		} else {
			System.out.println("invalid");
		}
	}

}
