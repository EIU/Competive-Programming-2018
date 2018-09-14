import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
	public static void permu(char[] charac, ArrayList<String> s,StringBuilder sb) {
		int i = 0, j;
		if (i >= 0) {
			s.add(new String(charac));
			sb.append(charac);
			sb.append("\n");
			for (i = charac.length - 2; i >= 0; i--) {
				if (charac[i] < charac[i + 1]) {
					break;
				}
			}
			for (j = charac.length - 1; j > i; j--) {
				if (i < 0)
					break;
				if (charac[i] < charac[j]) {
					break;
				}
			}
			if (i >= 0) {
				char c = charac[i];
				charac[i] = charac[j];
				charac[j] = c;
				for (int k = i + 1, h = charac.length - 1; k < h; k++, h--) {
					char a = charac[k];
					charac[k] = charac[h];
					charac[h] = a;
				}
				permu(charac, s,sb);
			}
		}
	}
 
	public static void main(String[] args) {
		InputReader sc=new InputReader(System.in);
		String s = sc.next();
		char[] charac = s.toCharArray();
		StringBuilder sb=new StringBuilder();
		Arrays.sort(charac);
		ArrayList<String> a = new ArrayList<>();
		permu(charac, a,sb);
		System.out.println(a.size());	
		System.out.println(sb);
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
 