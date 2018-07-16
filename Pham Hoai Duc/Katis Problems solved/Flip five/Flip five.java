
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Vertex{
	HashSet<Integer> neighBor = new HashSet<>();
}
class Graph{
	Vertex[] vertices;
	public Graph(int n) {
		vertices = new Vertex[n];
		for(int i = 0; i < n; i++)
			vertices[i] = new Vertex();
	}
	public void addEdge(int u, int v) {
		vertices[u].neighBor.add(v);
		vertices[v].neighBor.add(u);
	}
	public boolean isAllWhite(int[] input)
	{
		if(input[0] == 0 && input[1] == 0 && input[2] == 0 && input[3] == 0 && input[4] == 0 && input[5] == 0 && input[6] == 0 && input[7] == 0 && input[8] == 0)
			return true;
		return false;
	}
	public void convertColor(int cell, int[] input)
	{
		if(input[cell] == 1)
			input[cell] = 0;
		else
			input[cell] = 1;
		for(int nbrCell : vertices[cell].neighBor)
			if(input[nbrCell] == 1)
				input[nbrCell] = 0;
			else
				input[nbrCell] = 1;
	}
	public void BruteForce(int cell, int[] input, int clicks, int minClicks)
	{
		if(clicks > minClicks)
			return;
		if(cell == 9)
		{
			if(isAllWhite(input))
				if(clicks < minClicks)
				{
					minClicks = clicks;
					System.out.println(minClicks);
				}	
		}
		else
		{
			BruteForce(cell + 1, input, clicks, minClicks);
			convertColor(cell, input);
			clicks++;
			BruteForce(cell + 1, input, clicks, minClicks);
			convertColor(cell, input);
			clicks--;
		}		
	}
}
public class Main {
    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader(System.in);
        int n = ip.nextInt();
		for(int t = 0; t < n; t++)
		{
			StringBuilder charInput = new StringBuilder();
			int[] bitInput = new int[9];
			for(int i = 0; i < 3; i++)
				charInput.append(ip.next());
			for(int i = 0; i < 9; i++)
				if(charInput.charAt(i) == '*')
					bitInput[i] = 1;
			Graph g = new Graph(9);
			g.addEdge(0, 1);
			g.addEdge(0, 3);
			g.addEdge(1, 2);
			g.addEdge(1, 4);
			g.addEdge(2, 5);
			g.addEdge(3, 4);
			g.addEdge(3, 6);
			g.addEdge(4, 5);
			g.addEdge(4, 7);
			g.addEdge(5, 8);
			g.addEdge(6, 7);
			g.addEdge(7, 8);
			g.BruteForce(0, bitInput, 0, 10);
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