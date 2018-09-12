
import java.io.*;
import java.util.*;

class Main {
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);

		int n = scan.nextInt();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			String first = scan.next();
			String second = scan.next();
			if (!map.containsKey(first)) {
				map.put(first, new ArrayList<>());
			}
			if (!map.containsKey(second)) {
				map.put(second, new ArrayList<>());
			} 
			map.get(first).add(second);
			map.get(second).add(first);
		}
		for (ArrayList<String> i : map.values()) {
			i.sort((a,b)->a.compareTo(b));
		}

		String father = scan.next();
		result.append("-").append(father).append("\n");
		dfs(father,"-",map,result);
		
		System.out.println(result);
	}
	
	static void dfs(String father,String deg, HashMap<String, ArrayList<String>> map,StringBuilder result) {
		for (String son : map.get(father)) {
			map.get(son).remove(father);
			result.append(deg).append("---").append(son).append("\n");
			dfs(son,deg+"---",map,result);
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

//	static class InputReader {
//
//		InputStream is = System.in;
//		byte[] inbuf = new byte[1 << 23];
//		int lenbuf = 0, ptrbuf = 0;
//
//		public InputReader() throws IOException {
//			lenbuf = is.read(inbuf);
//		}
//
//		public int readByte() {
//
//			if (ptrbuf >= lenbuf) {
//				return -1;
//			}
//
//			return inbuf[ptrbuf++];
//		}
//
//		public boolean hasNext() {
//			int t = skip();
//
//			if (t == -1) {
//				return false;
//			}
//			ptrbuf--;
//			return true;
//		}
//
//		public boolean isSpaceChar(int c) {
//			return !(c >= 33 && c <= 126);
//		}
//
//		public int skip() {
//			int b;
//			while ((b = readByte()) != -1 && isSpaceChar(b))
//				;
//			return b;
//		}
//
//		public double nextDouble() {
//			return Double.parseDouble(next());
//		}
//
//		public char nextChar() {
//			return (char) skip();
//		}
//
//		public String next() {
//			int b = skip();
//			StringBuilder sb = new StringBuilder();
//			while (!(isSpaceChar(b))) {
//				sb.appendCodePoint(b);
//				b = readByte();
//			}
//			return sb.toString();
//		}
//
//		public char[] ns(int n) {
//			char[] buf = new char[n];
//			int b = skip(), p = 0;
//			while (p < n && !(isSpaceChar(b))) {
//				buf[p++] = (char) b;
//				b = readByte();
//			}
//			return n == p ? buf : Arrays.copyOf(buf, p);
//		}
//
//		public char[][] nm(int n, int m) {
//			char[][] map = new char[n][];
//			for (int i = 0; i < n; i++) {
//				map[i] = ns(m);
//			}
//			return map;
//		}
//
//		public int[] na(int n) {
//			int[] a = new int[n];
//			for (int i = 0; i < n; i++) {
//				a[i] = nextInt();
//			}
//			return a;
//		}
//
//		public int nextInt() {
//			int num = 0, b;
//			boolean minus = false;
//			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//				;
//			if (b == '-') {
//				minus = true;
//				b = readByte();
//			}
//
//			while (true) {
//				if (b >= '0' && b <= '9') {
//					num = num * 10 + (b - '0');
//				} else {
//					return minus ? -num : num;
//				}
//				b = readByte();
//			}
//		}
//
//		public long nextLong() {
//			long num = 0;
//			int b;
//			boolean minus = false;
//			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//				;
//			if (b == '-') {
//				minus = true;
//				b = readByte();
//			}
//
//			while (true) {
//				if (b >= '0' && b <= '9') {
//					num = num * 10 + (b - '0');
//				} else {
//					return minus ? -num : num;
//				}
//				b = readByte();
//			}
//		}
//
//	}
}
