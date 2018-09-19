import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Vertex[] list = readGraph(n, m, scan);
        int com = 0;
        for (int i = 1; i <= n; i++) {
            if (!list[i].visited)
                bfs(list[i], com++);
        }
        boolean ok = true;
        for (int i = 1; i <= n; i++) {
            if (list[i].com != list[n-i+1].com) {
                ok = false;
                break;
            }
        }
        System.out.println(ok ? "YES" : "NO");
    }

    static void bfs(Vertex u, int com) {
        u.visited = true;
        u.com = com;
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(u);
        while (!q.isEmpty()) {
            Vertex cur = q.poll();
            for (Vertex v : cur.neighbors) {
                if (!v.visited) {
                    v.visited = true;
                    v.com = cur.com;
                    q.add(v);
                }
            }
        }
    }

    public static Vertex[] readGraph(int nVertices, int nEdges, InputReader scan) {
        Vertex[] vertices = new Vertex[nVertices + 1];
        for (int i = 1; i <= nVertices; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }

    static class Vertex {

        public int id;
        public List<Vertex> neighbors = new ArrayList<>();
        public boolean visited = false;
        public int com = -1;

        public Vertex(int id) {
            this.id = id;
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