
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        InputReader ip = new InputReader(System.in);
        int n = ip.nextInt();
        int row[] = new int[n];
        int column[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            row[i] = ip.nextInt();
            column[i] = ip.nextInt();
        }
        Arrays.sort(row);
        Arrays.sort(column);
        int j = 1;
        long moves = 0;
        for(int i = 0; i < n; i++, j++)
        {
            if(row[i] < j)
                moves += j - row[i];
            else if(row[i] > j)
                moves += row[i] - j;
            if(column[i] < j)
                moves += j - column[i];
            else if(column[i] > j)
                moves += column[i] - j;   
        }
        System.out.println(moves);
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

