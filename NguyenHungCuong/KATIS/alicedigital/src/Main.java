
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		
		StringBuilder result = new StringBuilder();
		
		int test = scan.nextInt();
		while (test-->0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] arr = new int[n];
			ArrayList<Integer> index = new ArrayList<>();
			for (int i=0;i<n;i++) {
				arr[i] = scan.nextInt();
				if (arr[i] == m) {
					index.add(i);
				}
			}
			int max = 0;
			for (Integer i : index) {
				int sum = m;
				for (int left = i-1;left>=0;left--) {
					if (arr[left] <= m) {
						break;
					}
					sum += arr[left];
				}
				for (int right = i+1;right<n;right++) {
					if (arr[right] <= m) {
						break;
					}
					sum += arr[right];
				}
				max = Math.max(max, sum);
			}
			result.append(max).append("\n");
		}
		
		System.out.println(result);
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
