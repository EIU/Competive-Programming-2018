package w2problemf;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;



public class W2ProblemF {
    public static String Color(int row, int column){
        if(column % 2 == 0)
            if(row % 2 == 0)
                return "White";
            else
                return "Black";
        else
            if(row % 2 == 0)
                return "Black";
            else
                return "White";
        
    }
    public static void main(String[] args) {
        InputReader ip = new InputReader(System.in);
        int n = ip.nextInt();
        HashMap<Integer, Integer> chessmanMoves = new HashMap<>();
        HashMap<String, Integer> columnsIndex = new HashMap<>();
        columnsIndex.put("H",1);
        columnsIndex.put("G",2);
        columnsIndex.put("F",3);
        columnsIndex.put("E",4);
        columnsIndex.put("D",5);
        columnsIndex.put("C",6);
        columnsIndex.put("B",7);
        columnsIndex.put("A",8);
        HashMap<Integer, String> columnsName = new HashMap<>();
        columnsName.put(1,"H");
        columnsName.put(2,"G");
        columnsName.put(3,"F");
        columnsName.put(4,"E");
        columnsName.put(5,"D");
        columnsName.put(6,"C");
        columnsName.put(7,"B");
        columnsName.put(8,"A");
        for(int i = 0; i < n; i++)
        {
            int columnX = columnsIndex.get(ip.next());
            int rowX = ip.nextInt();
            int columnY = columnsIndex.get(ip.next());
            int rowY = ip.nextInt();
            if(columnX == columnY && rowX == rowY)
            {
                System.out.println(0+" "+columnsName.get(columnX) + " "+rowX);
            }
            else if(Color(rowX, columnX).equals(Color(rowY, columnY)))
            {
                //find all moves of chess
                int column, row;
                for(column = columnX, row = rowX; column <= 8 && row <= 8; column++, row++)
                    chessmanMoves.put(column, row);
                for(column = columnX, row = rowX; column <= 8 && row >= 1; column++, row--)
                    chessmanMoves.put(column, row);
                for(column = columnX, row = rowX; column >= 1 && row <= 8; column--, row++)
                    chessmanMoves.put(column, row);
                for(column = columnX, row = rowX; column >= 1 && row >= 1; column--, row--)
                    chessmanMoves.put(column, row);
                //find all moves of destination and check if it's match any moves of chess 
                boolean isConnected = false;
                for (column = columnY, row = rowY; column <= 8 && row <= 8; column++, row++)
                    if (chessmanMoves.get(column) == row) {
                        if (rowY == row && columnY == column) {
                            System.out.println(1 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row);
                        }
                        else
                        System.out.println(2 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row + " " + columnsName.get(columnY) + " " + rowY);
                        isConnected = true;
                        break;
                    }
                if (isConnected)
                    continue;
                for (column = columnY, row = rowY; column <= 8 && row >= 1; column++, row--)
                    if (chessmanMoves.get(column) == row) {
                        if (rowY == row && columnY == column) {
                            System.out.println(1 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row);
                        }
                        else
                        System.out.println(2 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row + " " + columnsName.get(columnY) + " " + rowY);
                        isConnected = true;
                        break;
                    }  
                if (isConnected)
                    continue;
                for (column = columnY, row = rowY; column >= 1 && row <= 8; column--, row++) 
                    if (chessmanMoves.get(column) == row) {
                        if (rowY == row && columnY == column) {
                            System.out.println(1 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row);
                        }
                        else
                        System.out.println(2 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row + " " + columnsName.get(columnY) + " " + rowY);
                        isConnected = true;
                        break;
                    }
                if (isConnected) 
                    continue;
                for (column = columnY, row = rowY; column >= 1 && row >= 1; column--, row--) 
                    if (chessmanMoves.get(column) == row) {
                        if (rowY == row && columnY == column) {
                            System.out.println(1 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row);
                        }
                        else
                        System.out.println(2 + " " + columnsName.get(columnX) + " " + rowX + " " + columnsName.get(column) + " " + row + " " + columnsName.get(columnY) + " " + rowY);
                        isConnected = true;
                        break;
                    }
                if (isConnected) 
                    continue;
            }
            else
                System.out.println("Impossible");
           
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
}

