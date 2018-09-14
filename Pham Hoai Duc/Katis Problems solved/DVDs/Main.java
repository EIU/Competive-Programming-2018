
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) {
        InputReader ip = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int T = ip.nextInt();
		for (int t = 0; t < T; ++t) {
			int n = ip.nextInt();
			int[] arr = new int[n];
			int[] list = new int[n];
			for (int i = 0; i < n; ++i) {
				list[i] = ip.nextInt();
				arr[i] = list[i];
			}
			Arrays.sort(arr);
			int count = 0;
			for (int i = 0, j = 0; i < n;) {
				if (list[i] == arr[j]) {
					i++;
					j++;
				} else {
					count++;
					i++;
				}
			}
			builder.append(count+"\n");
		}
		System.out.print(builder);
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