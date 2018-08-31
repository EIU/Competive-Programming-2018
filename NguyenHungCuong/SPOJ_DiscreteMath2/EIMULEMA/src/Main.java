
import java.io.*;
import java.util.*;

class Main {
	static List<Vertex> order = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		StringBuilder result = new StringBuilder();
		int vertices = scan.nextInt();

		Vertex[] list = readGraph(vertices, scan);
		
		for (Vertex i : list) {
			result.append(i.id+" "+i.sale+"\n");
		}
		System.out.println(result);
	}

	static int dfs(Vertex u) {
		u.visited = true;
		u.sale *= 0.15;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				u.sale += dfs(v);
			}
		}
		return u.sale/2;
	}

	public static Vertex[] readGraph(int nVertices, InputReader scan) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i,scan.nextInt());
		}
		for (int i = 0; i < nVertices-1; ++i) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			vertices[u].addNeighbor(vertices[v]);
		}
		dfs(vertices[0]);
		return vertices;
	}

	static class Vertex {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public int level = -1;
		public int sale;

		public Vertex(int id, int sale) {
			this.id = id;
			this.sale = sale;
		}

		public int getDeg() {
			return this.neighbors.size();
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
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
