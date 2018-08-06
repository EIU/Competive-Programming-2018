
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);

		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int n = scan.nextInt();
		int m = scan.nextInt();
		char[][] map = readMatrix(n,m,scan);
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		queue.add(0);
		queue.add(0);
		map[0][0] = 2;
		int ans = 0;
		while (!queue.isEmpty()) {
			int	x = queue.pollFirst();
			int y = queue.pollFirst();
			for (int k=0;k<4;k++) {
				int x1 = x + dx[k];
				int y1 = y + dy[k];
				if (x1>=0 && x1 < n+2 && y1>=0 && y1<m+2) {
					if (map[x1][y1] == '1') {
						ans++;
					}
					if (map[x1][y1] == '0') {
						map[x1][y1] = '2';
						queue.add(x1);
						queue.add(y1);
					}
				}
			}
		}
		System.out.println(ans);
	}
	static char[][] readMatrix(int n,int m,InputReader scan){
		char[][] res = new char[n+2][m+2];
		
		for (int i=0;i<n+2;i++) {
			for (int j=0;j<m+2;j++) {
				res[i][j] = '0';
			}
		}
		for (int i=0;i<n;i++) {
			String a = scan.next();
			for (int j=0;j<m;j++) {
				res[i+1][j+1] = a.charAt(j);
			}
		}
		return res;
	}

	static class InputReader {

		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}

				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
