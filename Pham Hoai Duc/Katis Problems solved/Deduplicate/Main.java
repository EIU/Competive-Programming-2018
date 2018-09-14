
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static long hashing(String s){
		long value = s.charAt(0);
		for(int i = 1; i < s.length(); ++i) {
			value ^= s.charAt(i);
		}
		return value;
	}
    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
		while(true) {
			int n = ip.nextInt();
			if(n == 0) {
				break;
			}
			HashSet<String> map = new HashSet<>();
			String[] s = new String[n];
			long[] hash = new long[n];
			for(int i = 0; i < n; ++i) {
				s[i] = ip.nextLine();
				map.add(s[i]);
				hash[i] = hashing(s[i]);
			}
			builder.append(map.size() + " ");
			int col = 0;
			for(int i = 0; i < n - 1; ++i) {
				for(int j = i + 1; j < n; ++j ) {
					if(hash[i] == hash[j] && !s[i].equals(s[j])) {
						col++;
					}
				}
			}
			builder.append(col+"\n");	
		}
		System.out.println(builder);
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