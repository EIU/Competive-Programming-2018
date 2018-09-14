
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) {
        InputReader ip = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        String spaces =  "  ";
        String dot =     "o ";
        String plus =    "    +";
        String twoPlus = "+   +";
        String other =   "+---+";
        String left =      "|    ";
        String right =     "    |";
        String leftRight = "|   |";
        String[] row0 = new String[11];
        String[] row1 = new String[11];
        String[] row2 = new String[11];
        String[] row3 = new String[11];
        String[] row4 = new String[11];
        String[] row5 = new String[11];
        String[] row6 = new String[11];
		for (int i = 0; i <= 9; ++i) {
			row0[i] = new String();
			if (i == 1)
				row0[i] = plus;
			else if (i == 4)
				row0[i] = twoPlus;
			else 
				row0[i] = other;
		}
		for (int i = 0; i <= 9; ++i) {
			row3[i] = new String();
			if (i == 1 || i == 7)
				row3[i] = plus;
			else if (i == 0)
				row3[i] = twoPlus;
			else
				row3[i] = other;
		}
		for (int i = 0; i <= 9; ++i) {
			row1[i] = new String();
			row2[i] = new String();
			if (i == 5 || i == 6) {
				row1[i] = left;
				row2[i] = left;
			} else if (i == 4 || i == 8 || i == 9 || i == 0) {
				row1[i] = leftRight;
				row2[i] = leftRight;
			} else {
				row1[i] = right;
				row2[i] = right;
			}
		}
		for (int i = 0; i <= 9; ++i) {
			row4[i] = new String();
			row5[i] = new String();
			if (i == 8 || i == 6 || i == 0) {
				row4[i] = leftRight;
				row5[i] = leftRight;
			} else if (i == 2) {
				row4[i] = left;
				row5[i] = left;
			} else {
				row4[i] = right;
				row5[i] = right;
			}
		}
		for (int i = 0; i <= 9; ++i) {
			row6[i] = new String();
			if(i == 1 || i == 4 || i == 7) {
				row6[i] = plus;
			}else {
				row6[i] = other;
			}
		}
		HashMap<Integer, String[]> rows = new HashMap<>();
		rows.put(0, row0);
		rows.put(1, row1);
		rows.put(2, row2);
		rows.put(3, row3);
		rows.put(4, row4);
		rows.put(5, row5);
		rows.put(6, row6);
        while(true) {
        	String time = ip.next();
        	if(time.equals("end"))
        		break;
        	for(int i = 0; i <= 6; ++i) {
        		String[] temp = rows.get(i);
        		for(int j = 0; j < time.length(); ++j) {
        			char number = time.charAt(j);
        			if(number == ':') {
        				if(i == 2 || i == 4)
        					builder.append(dot + " ");
        				else
        					builder.append(spaces+" ");
        			}else {
        				builder.append(temp[Integer.valueOf(String.valueOf(number))]);
        				if(j < 4) {
        					builder.append("  ");
        				}
        			}
        		}
        		builder.append("\n");
        	}
        	builder.append("\n\n");
        }
        builder.append("end");
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