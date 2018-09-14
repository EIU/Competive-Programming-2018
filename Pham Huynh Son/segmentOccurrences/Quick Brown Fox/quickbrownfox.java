import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class quickbrownfox {
	public static void main(String[] args) throws IOException {
		InputReader input = new InputReader(System.in);
		StringBuilder strBuilder = new StringBuilder();
		String str ="abcdefghijklmnopqrstuvwxyz";
		String [] pangram=str.split("");
		int n= input.nextInt();
//		input.nextLine();
		for(int i=0;i<n;i++) {
			String inStr= input.nextLine().toLowerCase();
			StringBuilder strBuilder2 = new StringBuilder();
			for(int j=0;j<26;j++) {
				if(!inStr.contains(pangram[j]))
					strBuilder2.append(pangram[j]);
			}
			strBuilder.append((strBuilder2.length()>0)?"missing"+" "+strBuilder2:"pangram").append("\n");
		}
		System.out.println(strBuilder);
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
