
import java.util.*;
import java.io.*;

class Vertex{
    ArrayList<Edge> childList = new ArrayList<>();
    ArrayList<Edge> parentList = new ArrayList<>();
}
class Edge{
    int id;
    long w;
    public Edge(int id, long w) {
        this.id = id;
        this.w = w;
    }  
}
class Graph{
    Vertex[] sets;
    public Graph(int n) {
        sets = new Vertex[n];
        for(int i = 0; i < n; ++i)
            sets[i] = new Vertex();
    }
    public void add(int u, int v, long w){
        sets[u].childList.add(new Edge(v, w));
        sets[v].parentList.add(new Edge(u, w));
    }
    public void sortChild(int v) {
        if (sets[v].childList.size() > 1) {
            Collections.sort(sets[v].childList, (v1, v2) -> {
                return Long.compare(v1.w, v2.w);
            });
            for (int i = 0; i < sets[v].childList.size() - 1; ++i) {
                Edge left = sets[v].childList.get(i);
                Edge right = sets[v].childList.get(i + 1);
                int temp = v;
                sets[right.id].parentList.removeIf((t) -> {
                    return t.id == temp;
                });
                sets[left.id].childList.add(new Edge(right.id, right.w / left.w));
                sets[right.id].parentList.add(new Edge(left.id, right.w / left.w));
                if(sets[left.id].childList.size() > 1)
                    sortChild(left.id);
            }
            ArrayList<Edge> list = new ArrayList<>();
            list.add(sets[v].childList.get(0));
            sets[v].childList.retainAll(list);
        }
    }
    public void sortParent(int v){
        if(sets[v].parentList.size() > 1){
            Collections.sort(sets[v].parentList, (v1, v2)->{
                return Long.compare(v2.w, v1.w);
            });
            for(int i = 0; i < sets[v].parentList.size() - 1; ++i){
                Edge left = sets[v].parentList.get(i);
                Edge right = sets[v].parentList.get(i + 1);
                int temp = v;
                sets[left.id].childList.removeIf((t) -> {
                    return t.id == temp; 
                });
                sets[left.id].childList.add(new Edge(right.id, left.w/right.w));
                sets[right.id].parentList.add(new Edge(left.id, left.w/right.w));
                if(sets[right.id].parentList.size() > 1)
                    sortParent(right.id);
            }
            ArrayList<Edge> list = new ArrayList<>();
            list.add(sets[v].parentList.get(sets[v].parentList.size() - 1));
            sets[v].parentList.retainAll(list);
        }
    }
    
    public void traverse(int v, HashMap<Integer, String> mapIS, StringBuilder builder, long sum){
        
        if(!sets[v].childList.isEmpty()){
            builder.append(sum +""+ mapIS.get(v) + " = ");
            traverse(sets[v].childList.get(0).id, mapIS, builder, sum * sets[v].childList.get(0).w);
        }else{
            builder.append(sum +""+mapIS.get(v)+"\n");
        }
    }
}
public class Main {
    static boolean readFile = false;
	public static void main(String[] args) throws IOException {
	    InputReader ip = new InputReader();
            StringBuilder builder = new StringBuilder();
            while(true){
                int n = ip.nextInt();
                if(n == 0) break;
                Graph g = new Graph(n);
                HashMap<String, Integer> mapSI = new HashMap<>();
                HashMap<Integer, String> mapIS = new HashMap<>();
                for(int i = 0; i < n; ++i){
                    String s = ip.next(); mapIS.put(i, s); mapSI.put(s, i);
                }
                for(int i = 0; i < n - 1; ++i){
                    String u = ip.next(); ip.next(); long w = ip.nextLong(); String v = ip.next();
                    g.add(mapSI.get(u), mapSI.get(v), w);
                }
                for(int i = 0; i < n; ++i) g.sortChild(i);
                for(int i = 0; i < n; ++i) g.sortParent(i);
                for(int i = 0; i < n; ++i){
                    if(g.sets[i].parentList.isEmpty()){
                        g.traverse(i, mapIS, builder, 1);
                        break;
                    }
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


