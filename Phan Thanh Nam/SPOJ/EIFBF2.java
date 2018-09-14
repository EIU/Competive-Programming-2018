import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static InputReader sc = new InputReader(System.in);
    static int men;
    static int women;
    static ArrayList<Vertex>arr;
    static class Vertex {
        public int id = -1;
        public String Gender;
        public List<Vertex> neighbors = new ArrayList<Vertex>();
        private boolean visited = false;
 
        public Vertex(int id, String Gender) {
            this.id = id;
            this.Gender = Gender;
        }
 
        public void addNeighbor(Vertex child) {
            neighbors.add(child);
        }
 
    }
 
    static class ConnectedComponent {
        private Vertex vertex;
        private int num_man;
        private int num_woman;
        //private List<Vertex> list = new ArrayList<>();
 
        public ConnectedComponent(Vertex vertex, int num_man, int num_woman) {
            this.vertex = vertex;
            this.num_man = num_man;
            this.num_woman = num_woman;
        }
    }
 
    public static void dfs(Vertex u) {
        u.visited = true;
        arr.add(u);
        if(u.Gender.equals("Nam")){
            men++;
        }else {
            women++;
        }
        for (Vertex v : u.neighbors) {
            if (!v.visited) {
                dfs(v);
            }
        }
    }
 
    public static void bfs(Vertex v, List<Vertex> list) {
        v.visited = true;
        Queue<Vertex> queue = new LinkedList();
        queue.add(v);
        list.add(v);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            for (Vertex neighbor : currentVertex.neighbors) {
                if (!neighbor.visited) {
                    neighbor.visited = true;
                    queue.add(neighbor);
                    list.add(neighbor);
                }
            }
        }
    }
 
    public static Vertex[] readGraph(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices];
        for (int i = 0; i < nVertices; i++) {
            String Gender = sc.next();
            vertices[i] = new Vertex(i, Gender);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }
 
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertices = readGraph(n, m);
        StringBuilder sb = new StringBuilder();
        List<ConnectedComponent> list1 = new ArrayList<ConnectedComponent>();
//        for (int i = 0; i < vertices.length; i++) {
//            Collections.sort(vertices[i].neighbors, (a, b) -> {
//                if (a.id > b.id) {
//                    return 1;
//                } else if (a.id < b.id) {
//                    return -1;
//                }
//                return 0;
//            });
//        }
        for (int i = 0; i < n; i++) {
            men = 0;
            women = 0;
            if (!vertices[i].visited) {
                arr=new ArrayList<>();
                dfs(vertices[i]);
                for(int j=0;j<arr.size();j++){
                    ConnectedComponent CC = new ConnectedComponent(arr.get(j), men,women);
                    list1.add(CC);
                }
            }
        }
        list1.sort((ConnectedComponent a, ConnectedComponent b) -> Integer.compare(a.vertex.id, b.vertex.id));
        for(int i=0;i<list1.size();i++){
            sb.append(list1.get(i).vertex.id+1+ " " +list1.get(i).num_man  + " " + list1.get(i).num_woman + "\n");
        }
        System.out.println(sb);
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
 