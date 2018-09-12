import java.io.*;
import java.util.*;

class MST {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        int numberOfVers = reader.nextInt(), numberOfEdges = reader.nextInt();
        while (numberOfVers + numberOfEdges != 0) {
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            Vertex[] vertexs = readGraph(numberOfVers, numberOfEdges);
            boolean[] addVertex = new boolean[numberOfVers];
            addVertex[0] = true;
            queue.addAll(vertexs[0].neighbors);
            List<Edge> usedEdges = new ArrayList<>();
            long sum = 0;
            while (!queue.isEmpty()) {
                Edge minEdge = queue.poll();
                if (!addVertex[minEdge.endpoint1.id] || !addVertex[minEdge.endpoint2.id]) {
                    usedEdges.add(minEdge);
                    sum += minEdge.weight;
                    queue.addAll(addVertex[minEdge.endpoint1.id] ? vertexs[minEdge.endpoint2.id].neighbors
                            : vertexs[minEdge.endpoint1.id].neighbors);
                    addVertex[minEdge.endpoint2.id] = addVertex[minEdge.endpoint1.id] = true;
                }
            }
            usedEdges.sort((c1, c2) -> {
                if (c1.endpoint1.id == c2.endpoint1.id)
                    return c1.endpoint2.id - c2.endpoint2.id;
                else
                    return c1.endpoint1.id - c2.endpoint1.id;
            });
            if (usedEdges.size() != numberOfVers - 1)
                builder.append("Impossible\n");
            else {
                builder.append(sum + "\n");
                for (Edge i : usedEdges)
                    builder.append(i.endpoint1.id + " " + i.endpoint2.id + "\n");
            }
            numberOfVers = reader.nextInt();
            numberOfEdges = reader.nextInt();
        }
        System.out.print(builder.delete(builder.lastIndexOf("\n"), builder.length()));
    }

    public static Vertex[] readGraph(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices];
        Edge[] edges = new Edge[nEdges];
        for (int i = 0; i < nVertices; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            int weight = reader.nextInt();
            edges[i] = u > v ? new Edge(vertices[v], vertices[u], weight) : new Edge(vertices[u], vertices[v], weight);
            vertices[u].addNeighbor(edges[i]);
            vertices[v].addNeighbor(edges[i]);
        }
        return vertices;
    }

    static class Vertex {
        public int id;
        public List<Edge> neighbors = new ArrayList<Edge>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Edge child) {
            neighbors.add(child);
        }
    }

    public static class Edge implements Comparable<Edge> {
        public Vertex endpoint1;
        public Vertex endpoint2;
        public int weight;

        public Edge(Vertex endpoint1, Vertex endpoint2, int weight) {
            super();
            this.endpoint1 = endpoint1;
            this.endpoint2 = endpoint2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
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
