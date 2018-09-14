
import java.util.*;
import java.io.*;

class Vertex{
    List<Edge> neighbors = new ArrayList<>();
}
class Edge{
    int current;
    int neighbor;
    long weight;
    public Edge(int current, int neighbor, long weight) {
        this.current = current;
        this.neighbor = neighbor;
        this.weight = weight;
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Graph{
    Vertex[] vertices;
    public Graph(int n) {
        vertices = new Vertex[n];
        for(int i = 0 ; i < n; ++i){
            vertices[i] = new Vertex();
        }
    }
    public void addEdges(int u, int v, long w){
        vertices[u].neighbors.add(new Edge(u, v, w));
        vertices[v].neighbors.add(new Edge(v, u, w));
    }
    public long mst(int n, ArrayList<Edge> edges) {
        Queue<Edge> piorityQueue = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o1.weight, o2.weight); 
        });
        boolean[] mark = new boolean[n];
        long totalWeight = 0;
        mark[0] = true;
        for(Edge e : vertices[0].neighbors){
            piorityQueue.add(e);
        }
        while(edges.size() < n - 1 && !piorityQueue.isEmpty()){
            Edge e = piorityQueue.poll();
            int current = e.current;
            int neighbor = e.neighbor;
            long weight = e.weight;
            
            if(mark[current] && mark[neighbor]){
                continue;
            }
            if(mark[current]){
                for (Edge en : vertices[neighbor].neighbors) {
                    piorityQueue.add(en);
                }
            }
            if(mark[neighbor]){
                for (Edge ec : vertices[current].neighbors) {
                    piorityQueue.add(ec);
                }
            }
            mark[current] = mark[neighbor] = true;
            edges.add(e);
            totalWeight += weight;
        }
        return totalWeight;
    }
    
}
public class Main {
    static boolean readFile = false;
	public static void main(String[] args) throws IOException {
	    InputReader ip = new InputReader();
            StringBuilder builder = new StringBuilder();
            while (true) {
                int n = ip.nextInt();
                int m = ip.nextInt();
                if (n == 0 && m == 0) {
                    break;
                }
                Graph g = new Graph(n);
                for (int i = 0; i < m; ++i) {
                    g.addEdges(ip.nextInt(), ip.nextInt(), ip.nextLong());
                }
                ArrayList<Edge> edges = new ArrayList<>();
                long total = g.mst(n, edges);
                if (edges.size() == n - 1) {
                    builder.append(total + "\n");
                    ArrayList<Pair> arr = new ArrayList<>();
                    for(int i = 0; i < edges.size(); ++i){
                        int x = edges.get(i).current;
                        int y = edges.get(i).neighbor;
                        arr.add(new Pair(Math.min(x, y), Math.max(x, y)));
                    }
                    Collections.sort(arr, (u,v)->{
                        if(u.x > v.x)
                            return 1;
                        else if(u.x < v.x)
                            return -1;
                        else{
                            if(u.y > v.y)
                                return 1;
                            else if(u.y < v.y)
                                return -1;
                            else
                                return 0;
                        }
                    });
                    for (Pair p : arr) {
                        builder.append(p.x + " " + p.y + "\n");
                    }
                } else {
                    builder.append("Impossible\n");
                }
            }
            System.out.print(builder);
    }

	static class InputReader {

		InputStream is = System.in;
		byte[] inbuf = new byte[1 << 23];
		int lenbuf = 0, ptrbuf = 0;

		public InputReader() throws IOException {
			lenbuf = is.read(inbuf);
		}

		public int readByte() {

			if (ptrbuf >= lenbuf) {
				return -1;
			}

			return inbuf[ptrbuf++];
		}

		public boolean hasNext() {
			int t = skip();

			if (t == -1) {
				return false;
			}
			ptrbuf--;
			return true;
		}

		public boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		public int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public char nextChar() {
			return (char) skip();
		}

		public String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public char[] ns(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		public char[][] nm(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++)
				map[i] = ns(m);
			return map;
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		public long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

	}
}


