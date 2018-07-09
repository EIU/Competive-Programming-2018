package problembw2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ProblemBW2 {

	public static void main(String[] args) throws IOException {
	           InputReader ip = new InputReader(System.in);
                   StringBuilder builder = new StringBuilder();
            while(true) {
                int n = ip.nextInt();
                if (n == 0) {
                    break;
                } else {
                    String[] originalPicture = new String[n];
                    HashMap<Integer, Integer> originalRowLengths = new HashMap<>();
                    int maxOriginalRowLength = Integer.MIN_VALUE;
                    for (int i = 0; i < n; i++) {
                        originalPicture[i] = ip.nextLine();
                        int length = originalPicture[i].length();
                        originalRowLengths.put(i, length);
                        if (maxOriginalRowLength < length) {
                            maxOriginalRowLength = length;
                        }
                    }
                    //init 90 degrees picture 
                    String[] picture90Degrees = new String[maxOriginalRowLength];
                    for (int i = 0; i < maxOriginalRowLength; i++) {
                        picture90Degrees[i] = "";
                    }
                    //get 90 degrees picture 
                    for (int i = 0; i < maxOriginalRowLength; i++) {
                        for (int j = n - 1; j >= 0; j--) {
                            if (i >= originalRowLengths.get(j)) {
                                picture90Degrees[i] += ' ';
                                continue;
                            }
                            char character = originalPicture[j].charAt(i);
                            if (character == '-') {
                                character = '|';
                            } else if (character == '|') {
                                character = '-';
                            }
                            picture90Degrees[i] += character;
                        }
                    }       
                    //trim end
                    for (int i = 0; i < maxOriginalRowLength; i++) {
                        String temp = picture90Degrees[i].replaceAll("\\s+$", "");                   
                             builder.append(temp+"\n");
                    }
                    builder.append("\n");
                }              
            }
            int index = builder.lastIndexOf("\n");
            builder.delete(index,  index + 1);
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
