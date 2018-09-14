import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Islands {

	static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int count(int[][] Graph, int R, int C) {
		int island = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (Graph[i][j] == 'L') {
					island += 1;
				}
			}
		}
		return island;
	}

	public static void bfs(int[][] Graph, int r, int c) {
		Queue<pos> q = new ArrayDeque<>();
		pos point = new pos(r, c);
		q.add(point);
		while (q.isEmpty()) {
			pos a = q.poll();
			for (int i = r; i < c + 1; i++) {
				for (int j = r; j < c + 1; j++) {
					if(Graph[i][j]=='L') {
						
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] Graph = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			Graph[i] = s.toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(Graph[i][j]);
			}
			System.out.println();
		}

	}

}