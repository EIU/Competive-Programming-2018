import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Asciifigurerotation {
	public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader(System.in);
        boolean first = true;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            if(first==true)System.out.println();
            char[][] character = new char[n][n];
            int length_max = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                length_max=Math.max(length_max, s.length());
                for (int j = s.length() - 1; j < 20; j++) {
                    s += " ";
                }
                character[i] = s.toCharArray();
            }
            String[] ch = new String[n];
            for (int i = 0; i < length_max; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    char a = character[j][i];
                    if (a == '|') {
                        ch[j] = "-";
                    } else if (a == '-') {
                        ch[j] = "|";
                    } else if (a == ' ') {
                        ch[j] = " ";
                    }  else {
                        ch[j] = a + "";
                    }
                }
                TrimRight(ch);
                for (int j = n - 1; j >= 0; j--) {
                    if (ch[j].equals(" ")) {
                        System.out.print(" ");
                    } else {
                        System.out.print(ch[j]);
                    }
                }
                System.out.println();
            }
        }
	}
	public static String[] TrimRight(String[] s) {
		for (int j = 0; j < s.length; j++) {
            if (s[j] == " ") {
                s[j] = "";
            } else {
                break;
            }
        }
		return s;
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
