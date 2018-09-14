
import java.io.*;
import java.util.*;

class Main {
	static final InputReader scan = new InputReader(System.in);
	public static void main(String[] args) throws Exception {
		StringBuilder result = new StringBuilder();
		int vertices = scan.nextInt();
		int edges = scan.nextInt();
		int query = scan.nextInt();

		HashMap<String,Vertex> girls = new HashMap<>();
		for (int i = 0; i < vertices; ++i) {
			girls.put(scan.next(),new Vertex());
		}
		for (int i = 0; i < edges; ++i) {
			Vertex u = girls.get(scan.next());
			Vertex v = girls.get(scan.next());
			u.addNeighbor(v);
			v.addNeighbor(u);
		}
		int groupNumber = 0;
		for (Vertex i : girls.values()) {
			if (!i.visited) {
				bfs(i,groupNumber++);
			}
		}
		boolean ok;
		int amount;
		int index;
		int[] group = new int[groupNumber];
		while (query-->0) {
			ok = true;
			amount = scan.nextInt();
			while (amount-->0) {
				if (ok) {
					index = girls.get(scan.next()).groupNumber;
					if (group[index] != 0) {
						ok = false;
					} else {
						group[index]++;
					}
				} else {
					scan.next();
				}
			}
			result.append(ok?"Yes\n":"No\n");
			Arrays.fill(group, 0);
		}
		
		System.out.println(result);
	}
	static void bfs(Vertex girl,int groupNumber) {
		girl.visited = true;
		girl.groupNumber = groupNumber;
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(girl);
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			for (Vertex v : current.neighbors) {
				if (!v.visited) {
					v.visited = true;
					v.groupNumber = groupNumber;
					queue.add(v);
				}
			}
		}
	}
	static class Vertex {
		public int groupNumber = -1;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;

		public Vertex() {
			super();
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
