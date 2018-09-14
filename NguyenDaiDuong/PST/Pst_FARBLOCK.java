import java.io.*;
import java.util.*;

class FARBLOCK_Co_Gai {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		Vertex[] vetices = readGraph(reader.nextInt());
		int test = reader.nextInt();
		for (int i = 0; i < test; i++) {
			builder.append(vetices[reader.nextInt()].count + "\n");
		}
		System.out.print(builder);
	}

	public static Vertex[] readGraph(int nVertices) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nVertices - 1; ++i) {
			vertices[reader.nextInt()].count++;
			vertices[reader.nextInt()].count++;
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		int count = 0;

		public Vertex(int id) {
			this.id = id;
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
