

import java.io.*;
import java.util.*;

class DFS {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n=reader.nextInt();
		int m=reader.nextInt();
		int []arr=new int [n];
		int []arr2=new int [m];
		for(int i=0;i<n;i++) {
			arr[i]=reader.nextInt();
		}
		for(int i=0;i<m;i++) {
			arr2[i]=reader.nextInt();
		}
		for(int i:arr) {
			for(int j:arr2) {
				if(i==j)
					System.out.print(i+" ");
			}
		}
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
